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
	private CalculaIndiceJogadorDaVez calculaProximoJogador;
	private DesenhaComponentesGraficos desenha;
	private VerificacoesDeLogicaDoJogo verifica;
	private CalcularIndiceProximaCasa calculaProximaCasa;

	public ControladorBancoImobiliario() {
		constante = new Constantes();
		calculaProximoJogador = new CalculaIndiceJogadorDaVez();
		desenha = new DesenhaComponentesGraficos();
		verifica = new VerificacoesDeLogicaDoJogo();
		calculaProximaCasa = new CalcularIndiceProximaCasa();

		tabuleiro = new Tabuleiro();
		jogadores = new ArrayList<Jogador>();
		jogadoresAindaJogando = new ArrayList<Jogador>();
		desenha.draw();
		inserirJogador();
		efeito = new EfeitoDaCasa();
		iniciarJogo();
	}

	public void InserirJogadorNaListaDeJogadores(Jogador jogador) {
		jogadores.add(jogador);
	}
	public void inserirJogador() {
		String qtd = desenha.qtdJogadoresDesejada();
		int qtd_jogadores = Integer.valueOf(qtd);
		if (verifica.verificaQuantidadeJogadoresIsValida(qtd_jogadores)) {
			for (int i = 0; i < qtd_jogadores;) {
				String nomeJogador = JOptionPane.showInputDialog(null,"Digite o nome do jogador de ID = " + i);
				if(verifica.verificaNomeIsValido(nomeJogador)){
				String peca = "peca" + jogadores.size() + ".png";
				System.out.println(peca);
				InserirJogadorNaListaDeJogadores(new Jogador(nomeJogador, new ContaBancaria(500), new PecaJogador(constante.PATH_IMAGE + peca)));
				i++;
				}
			}
			adicionarListaDeJogadoresNaCasaDePartida(jogadores);
			iniciaJogadorDaVez();
			desenha.iniciarPecas(tabuleiro.getTabuleiro());
		} else {
			desenha.quantidadeInvalidaJogadores();
			inserirJogador();
		}

	}
	public void adicionarListaDeJogadoresNaCasaDePartida(List<Jogador> jogadores) {
		for (Jogador j : jogadores) {
			jogadoresAindaJogando.add(j);
			tabuleiro.adiconarJogadoresACasaDePartida(0, j);
			System.out.println("Classe: Banco Imobiliario"+ " -> Inserindo o jogador " + j.getNome() + " ID = "	+ j.getID());
		}
	}
	public void iniciaJogadorDaVez(){
		jogadorDaVEZ = jogadores.get(0);
	}
	public void moverJogador(Jogador jogador, CasaDoTabuleiro casa) {
		tabuleiro.moverJogador(jogador, casa);
	}
	public void mudaJogadorDaVez(int IdJogadorAtual, List<Jogador> jogadores){
		setJogadorDaVEZ(tabuleiro.getJogadorByID(calculaProximoJogador.calculaIndiceProximoJogador(IdJogadorAtual, jogadores)));
	}
	public void iniciarJogo() {
		while (executando) {
			if(verifica.verificaIsPressed(desenha.getMouse(), desenha.getBotao())){
				
			if (verifica.verificaSeExisteVencedor(jogadoresAindaJogando)) {
				executando = false;
				desenha.getWindow().exit();
			}
			
			desenha.draw();
			String resultado = desenha.entradaDados(jogadorDaVEZ);

			if (verifica.verificaJogadaIsValida(resultado)) {
				int resultadoDados = Integer.valueOf(resultado);
				if (verifica.verificaTamanhoJogadaIsValida(resultadoDados)) {
					
					int indiceCasaDestino = calculaProximaCasa.obterIndiceProximaCasa(jogadorDaVEZ.getPosicaoAtualJogador(), resultadoDados);
					destino = tabuleiro.getCasaByIndice(indiceCasaDestino);
					
					moverJogador(jogadorDaVEZ, destino);
					desenha.moverPecaJogador(destino, jogadorDaVEZ);
					efeito.executarComportamento(jogadorDaVEZ, destino);

					if (verifica.verificaSeJogadorAindaPossuiSaldo(jogadorDaVEZ)) {
						mudaJogadorDaVez(jogadorDaVEZ.getID(), jogadores);
					}else{
						jogadoresAindaJogando.remove(jogadorDaVEZ);
						jogadores.remove(jogadorDaVEZ);
						
						desenha.jogadorNaoPossuiSaldo(jogadorDaVEZ, jogadoresAindaJogando);
						mudaJogadorDaVez(jogadorDaVEZ.getID(), jogadores);
					}
				} else
					desenha.numeroDeEntradaDadosInvalido();
			}else
				desenha.inputVazio();
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

	public Jogador getJogadorDaVEZ() {
		return jogadorDaVEZ;
	}

	public void setJogadorDaVEZ(Jogador jogadorDaVEZ) {
		this.jogadorDaVEZ = jogadorDaVEZ;
	}
}
