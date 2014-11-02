package br.com.ufc.es.BancoImb.control;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import br.com.ufc.es.BancoImb.constantes.Constantes;
import br.com.ufc.es.BancoImb.model.CasaDoTabuleiro;
import br.com.ufc.es.BancoImb.model.ContaBancaria;
import br.com.ufc.es.BancoImb.model.Jogador;
import br.com.ufc.es.BancoImb.model.PecaJogador;
import br.com.ufc.es.BancoImb.model.Tabuleiro;
import br.com.ufc.es.BancoImb.view.BIInterfaceGrafica;

/**
 * https://github.com/marciosn/BANCO-IMOBILIARIO.git
 * 
 * @author Márcio Souza
 * 
 * **/
public class Controlador_Banco_Imobiliario {
	private Tabuleiro tabuleiro;
	private List<Jogador> jogadores;
	private List<Jogador> jogadoresAindaJogando;
	private Jogador jogadorDaVEZ;
	private boolean executando = true;
	private CasaDoTabuleiro destino;
	private ExecutaComportamentoDaCasa executar;
	private Constantes constante;
	private MudarJogadorNaVez mudarVez;
	private BIInterfaceGrafica view;
	private RulesGame rules;
	private br.com.ufc.es.BancoImb.sound.Sound som;

	public Controlador_Banco_Imobiliario() {
		constante = new Constantes();
		mudarVez = new MudarJogadorNaVez();
		view = new BIInterfaceGrafica();
		rules = new RulesGame();
		som = new br.com.ufc.es.BancoImb.sound.Sound();

		tabuleiro = new Tabuleiro();
		jogadores = new ArrayList<Jogador>();
		jogadoresAindaJogando = new ArrayList<Jogador>();
		view.draw();
		inserirJogador();
		executar = new ExecutaComportamentoDaCasa();
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
		
		String qtd = view.qtdJogadoresDesejada();
		int qtd_jogadores = Integer.valueOf(qtd);
		if (rules.qtdJogadoresIsValida(qtd_jogadores)) {
			for (int i = 0; i < qtd_jogadores;) {
				String nomeJogador = JOptionPane.showInputDialog(null,"Digite o nome do jogador de ID = " + i);
				if(rules.verificaNome(nomeJogador)){
				String peca = "peca" + jogadores.size() + ".png";
				System.out.println(peca);
				InserindoJogadorNoJogo(new Jogador(nomeJogador, new ContaBancaria(500), new PecaJogador(constante.PATH_IMAGE + peca)));
				i++;
				}
			}
			adicionarJogadoresNaCasaDePartida(jogadores);
			
			view.iniciarPecas(tabuleiro.getTabuleiro());
		} else {
			view.quantidadeInvalidaJogadores();
			inserirJogador();
		}

	}
	public void mudaJogadorVEZ(int IdJogadorAtual, List<Jogador> jogadores){
		setJogadorNaVEZ(tabuleiro.getJogadorByID(mudarVez.mudarVezDeJogar(IdJogadorAtual, jogadores)));
	}

	public void iniciarJogo() {
		while (executando) {
			if(rules.isPressed(view.getMouse(), view.getBotao())){
				
			if (rules.verificaSeExisteVencedor(jogadoresAindaJogando)) {
				executando = false;
				view.getWindow().exit();
			}
			
			view.draw();
			
			System.out.println(" A vez de jogar é do jogador "
					+ jogadorDaVEZ.getNome() + " que possui ID: "
					+ jogadorDaVEZ.getID());

			String resultado = view.entradaDados(jogadorDaVEZ);

			if (rules.jogadaIsValida(resultado)) {
				int resultadoDados = Integer.valueOf(resultado);
				if (rules.tamanhoJogadaIsValida(resultadoDados)) {
					
					int indiceCasaDestino = tabuleiro.calculaIndiceProximaCasa(jogadorDaVEZ.getPosicaoJogador(), resultadoDados);
					
					destino = tabuleiro.getCasaByIndice(indiceCasaDestino);
					
					moverJogador(jogadorDaVEZ, destino);
					view.moverPecaJogador(destino, jogadorDaVEZ);
					executar.executarComportamento(jogadorDaVEZ, destino);

					if (rules.verificaSeJogadorAindaPossuiSaldo(jogadorDaVEZ)) {
						mudaJogadorVEZ(jogadorDaVEZ.getID(), jogadores);
					}else{
						jogadoresAindaJogando.remove(jogadorDaVEZ);
						jogadores.remove(jogadorDaVEZ);
						
						view.jogadorNaoPossuiSaldo(jogadorDaVEZ, jogadoresAindaJogando);
						mudaJogadorVEZ(jogadorDaVEZ.getID(), jogadores);
					}

				} else {
					view.numeroDeEntradaDadosInvalido();
				}
			}else{
				view.inputVazio();
			}
			
		}
			view.ativaBotaoPortifolio(view.getMouse(), jogadores);		
		}
		view.getWindow().exit();
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
