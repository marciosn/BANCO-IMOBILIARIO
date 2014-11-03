package br.ufc.es.com.BancoImb.control;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import br.ufc.es.com.BancoImb.constantes.Constantes;
import br.ufc.es.com.BancoImb.model.CasaDoTabuleiro;
import br.ufc.es.com.BancoImb.model.ContaBancaria;
import br.ufc.es.com.BancoImb.model.Jogador;
import br.ufc.es.com.BancoImb.model.PecaJogador;
import br.ufc.es.com.BancoImb.tabuleiro.Tabuleiro;
import br.ufc.es.com.BancoImb.view.DesenhaComponentesGraficos;

/**
 * https://github.com/marciosn/BANCO-IMOBILIARIO.git
 * 
 * @author Márcio Souza
 * 
 * **/
public class ControladorBancoImobiliario {
	private Tabuleiro tabuleiro;
	private List<Jogador> jogadores;
	private List<Jogador> jogadoresAindaJogando;
	private Jogador jogadorDaVEZ;
	private boolean executando = true;
	private CasaDoTabuleiro destino;
	private EfeitoDaCasa efeito;
	private Constantes constante;
	private MudarJogadorDaVez mudarVez;
	private DesenhaComponentesGraficos desenha;
	private RulesGame rules;

	public ControladorBancoImobiliario() {
		constante = new Constantes();
		mudarVez = new MudarJogadorDaVez();
		desenha = new DesenhaComponentesGraficos();
		rules = new RulesGame();

		tabuleiro = new Tabuleiro();
		jogadores = new ArrayList<Jogador>();
		jogadoresAindaJogando = new ArrayList<Jogador>();
		desenha.draw();
		inserirJogador();
		efeito = new EfeitoDaCasa();
		iniciarJogo();
	}

	public void InserindoJogadorNoJogo(Jogador jogador) {
		jogadores.add(jogador);
	}
	
	public void adicionarJogadoresNaCasaDePartida(List<Jogador> jogadores) {
		for (Jogador j : jogadores) {
			jogadoresAindaJogando.add(j);
			tabuleiro.adiconarJogadoresACasa(0, j);
			System.out.println("Classe: Banco Imobiliario"+ " -> Inserindo o jogador " + j.getNome() + " ID = "	+ j.getID());
		}
		jogadorDaVEZ = jogadores.get(0);
	}

	public void moverJogador(Jogador jogador, CasaDoTabuleiro casa) {
		tabuleiro.moverJogador(jogador, casa);
	}
	
	public void removerJogadorQueNaoPossuiSaldo(Jogador jogador){
		tabuleiro.removeJogadorDefinitivo(jogador);
	}

	public void inserirJogador() {
		
		String qtd = desenha.qtdJogadoresDesejada();
		int qtd_jogadores = Integer.valueOf(qtd);
		if (rules.verificaQuantidadeJogadoresIsValida(qtd_jogadores)) {
			for (int i = 0; i < qtd_jogadores;) {
				String nomeJogador = JOptionPane.showInputDialog(null,"Digite o nome do jogador de ID = " + i);
				if(rules.verificaNomeIsValido(nomeJogador)){
				String peca = "peca" + jogadores.size() + ".png";
				System.out.println(peca);
				InserindoJogadorNoJogo(new Jogador(nomeJogador, new ContaBancaria(500), new PecaJogador(constante.PATH_IMAGE + peca)));
				i++;
				}
			}
			adicionarJogadoresNaCasaDePartida(jogadores);
			
			desenha.iniciarPecas(tabuleiro.getTabuleiro());
		} else {
			desenha.quantidadeInvalidaJogadores();
			inserirJogador();
		}

	}
	public void mudaJogadorVEZ(int IdJogadorAtual, List<Jogador> jogadores){
		setJogadorNaVEZ(tabuleiro.getJogadorByID(mudarVez.mudarVezDeJogar(IdJogadorAtual, jogadores)));
	}

	public void iniciarJogo() {
		while (executando) {
			if(rules.verificaIsPressed(desenha.getMouse(), desenha.getBotao())){
				
			if (rules.verificaSeExisteVencedor(jogadoresAindaJogando)) {
				executando = false;
				desenha.getWindow().exit();
			}
			
			desenha.draw();
			
			System.out.println(" A vez de jogar é do jogador "
					+ jogadorDaVEZ.getNome() + " que possui ID: "
					+ jogadorDaVEZ.getID());

			String resultado = desenha.entradaDados(jogadorDaVEZ);

			if (rules.verificaJogadaIsValida(resultado)) {
				int resultadoDados = Integer.valueOf(resultado);
				if (rules.verificaTamanhoJogadaIsValida(resultadoDados)) {
					
					int indiceCasaDestino = tabuleiro.calculaIndiceProximaCasa(jogadorDaVEZ.getPosicaoJogador(), resultadoDados);
					
					destino = tabuleiro.getCasaByIndice(indiceCasaDestino);
					
					moverJogador(jogadorDaVEZ, destino);
					desenha.moverPecaJogador(destino, jogadorDaVEZ);
					efeito.executarComportamento(jogadorDaVEZ, destino);

					if (rules.verificaSeJogadorAindaPossuiSaldo(jogadorDaVEZ)) {
						mudaJogadorVEZ(jogadorDaVEZ.getID(), jogadores);
					}else{
						jogadoresAindaJogando.remove(jogadorDaVEZ);
						jogadores.remove(jogadorDaVEZ);
						
						desenha.jogadorNaoPossuiSaldo(jogadorDaVEZ, jogadoresAindaJogando);
						mudaJogadorVEZ(jogadorDaVEZ.getID(), jogadores);
					}

				} else {
					desenha.numeroDeEntradaDadosInvalido();
				}
			}else{
				desenha.inputVazio();
			}
			
		}
			desenha.ativaBotaoPortifolio(desenha.getMouse(), jogadores);		
		}
		desenha.getWindow().exit();
	}
	public List<Jogador> getJodagores() {
		return jogadores;
	}

	public Tabuleiro getTabuleiroJogo() {
		return tabuleiro;
	}

	public Jogador getJogadorNaVEZ() {
		return jogadorDaVEZ;
	}

	public void setJogadorNaVEZ(Jogador jogadorDaVEZ) {
		this.jogadorDaVEZ = jogadorDaVEZ;
	}
}
