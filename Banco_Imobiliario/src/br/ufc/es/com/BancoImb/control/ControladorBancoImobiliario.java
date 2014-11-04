package br.ufc.es.com.BancoImb.control;

import java.util.ArrayList;
import java.util.List;

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
	private EfeitoDaCasa efeito;
	private Constantes constante;
	private CalculaIndiceJogadorDaVez calculaIndiceJogador;
	private DesenhaComponentesGraficos desenha;
	private VerificacoesDeLogicaDoJogo verifica;
	private CalcularIndiceProximaCasa calculaIndiceCasa;

	public ControladorBancoImobiliario() {
		constante = new Constantes();
		calculaIndiceJogador = new CalculaIndiceJogadorDaVez();
		desenha = new DesenhaComponentesGraficos();
		verifica = new VerificacoesDeLogicaDoJogo();
		calculaIndiceCasa = new CalcularIndiceProximaCasa();

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
		for (int i = 0; i < constante.QUANTIDADE_jOGADORES;) {
			String nomeJogador = desenha.messageDigiteONomeDoJogador(i);
			if(verifica.verificaNomeIsValido(nomeJogador)){
				String peca = constante.PECA + jogadores.size() + constante.FORMATO_IMAGEM;
				InserirJogadorNaListaDeJogadores(
						new Jogador(nomeJogador,
						new ContaBancaria(500), 
						new PecaJogador(constante.PATH_IMAGE + peca)));
			i++;
			}else
			desenha.messageNomeInvalido();
		}
		adicionarListaDeJogadoresNaCasaDePartida(jogadores);
		iniciaJogadorDaVez();
		desenha.desenhaPecasNoTabuleiro(tabuleiro.getTabuleiro());
	}
	public void adicionarListaDeJogadoresNaCasaDePartida(List<Jogador> jogadores) {
		for (Jogador jogador : jogadores) {
			jogadoresAindaJogando.add(jogador);
			tabuleiro.adiconarJogadoresACasaDePartida(constante.INDICE_DA_CASA_DE_PARTIDA, jogador);
		}
	}
	public void iniciaJogadorDaVez(){
		jogadorDaVEZ = jogadores.get(constante.JOGADOR_NA_PRIMEIRA_POSICAO_DA_LISTA);
	}
	public void moverJogador(Jogador jogador, CasaDoTabuleiro casa) {
		tabuleiro.moverJogador(jogador, casa);
	}
	public void mudaJogadorDaVez(int IdJogadorAtual, List<Jogador> jogadores){
		setJogadorDaVEZ(tabuleiro.getJogadorByID(calculaIndiceJogador.calculaIndiceProximoJogador(IdJogadorAtual, jogadores)));
	}
	public void iniciarJogo() {
		CasaDoTabuleiro destino;
		while (executando) {
			if(verifica.verificaIsPressed(desenha.getMouse(), desenha.getBotao())){
				
			desenha.draw();
			String resultado = desenha.entradaDados(jogadorDaVEZ);

			if (verifica.verificaJogadaIsValida(resultado)) {
				int resultadoDados = Integer.valueOf(resultado);
				if (verifica.verificaTamanhoJogadaIsValida(resultadoDados)) {
					
					int indiceCasaDestino = calculaIndiceCasa.obterIndiceProximaCasa(jogadorDaVEZ.getPosicaoAtualJogador(), resultadoDados);
					destino = tabuleiro.getCasaByIndice(indiceCasaDestino);
					
					moverJogador(jogadorDaVEZ, destino);
					desenha.moverPecaJogador(destino, jogadorDaVEZ);
					efeito.executarComportamento(jogadorDaVEZ, destino);

					if (verifica.verificaSeJogadorAindaPossuiSaldo(jogadorDaVEZ)) {
						mudaJogadorDaVez(jogadorDaVEZ.getID(), jogadores);
					}else{
						jogadoresAindaJogando.remove(jogadorDaVEZ);
						desenha.messageJogadorNaoPossuiSaldo(jogadorDaVEZ, jogadoresAindaJogando);
						desenha.messageExisteUmCampeao(jogadoresAindaJogando);
						executando = false;
					}
				} else
					desenha.messageNumeroDeEntradaDadosInvalido();
			}else
				desenha.messageInputVazio();
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
