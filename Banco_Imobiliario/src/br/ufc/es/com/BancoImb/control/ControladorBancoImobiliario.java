package br.ufc.es.com.BancoImb.control;

import java.util.List;

import br.ufc.es.com.BancoImb.constantes.Constantes;
import br.ufc.es.com.BancoImb.model.CasaDoTabuleiro;
import br.ufc.es.com.BancoImb.model.ContaBancaria;
import br.ufc.es.com.BancoImb.model.Jogador;
import br.ufc.es.com.BancoImb.model.PecaJogador;
import br.ufc.es.com.BancoImb.repositorios.Repositorio;
import br.ufc.es.com.BancoImb.tabuleiro.Tabuleiro;
import br.ufc.es.com.BancoImb.view.DesenhaComponentesGraficos;

/**
 * https://github.com/marciosn/BANCO-IMOBILIARIO.git
 * 
 * @author M�rcio Souza
 * 
 * **/
public class ControladorBancoImobiliario {
	
	private Tabuleiro tabuleiro;
	private Jogador jogadorDaVEZ;
	private boolean executando = true;
	private EfeitoDaCasa efeito;
	private Constantes constante;
	private CalculaIndiceJogadorDaVez calculaIndiceJogador;
	private DesenhaComponentesGraficos desenha;
	private VerificacoesDeLogicaDoJogo verifica;
	private CalcularIndiceProximaCasa calculaIndiceCasa;
	private Repositorio repo;

	public ControladorBancoImobiliario() {
		constante = new Constantes();
		calculaIndiceJogador = new CalculaIndiceJogadorDaVez();
		desenha = new DesenhaComponentesGraficos();
		instanciaComponentesGraficos();
		verifica = new VerificacoesDeLogicaDoJogo();
		calculaIndiceCasa = new CalcularIndiceProximaCasa();
		repo = new Repositorio();
		efeito = new EfeitoDaCasa();
		tabuleiro = new Tabuleiro(repo.getTabuleiro());
		desenha.atualizaTabuleiro();
		inserirJogador();
		iniciarJogo();
	}
	public void instanciaComponentesGraficos(){
		desenha.instanciaObjetos();
	}
	public void InserirJogadorNaListaDeJogadores(Jogador jogador) {
		repo.getJogadores().add(jogador);
	}
	public void salvarIntaciaTabuleiro(){
		constante.setTabuleiro(tabuleiro);
	}
	public void inserirJogador() {
		for (int i = 0; i < constante.QUANTIDADE_jOGADORES;) {
			String nomeJogador = desenha.inputDigiteONomeDoJogador(i);
			if(verifica.verificaNomeIsValido(nomeJogador)){
				String peca = constante.PECA + repo.getJogadores().size() + constante.FORMATO_IMAGEM;
				InserirJogadorNaListaDeJogadores(
						new Jogador(nomeJogador,
						new ContaBancaria(500), 
						new PecaJogador(constante.PATH_IMAGE + peca)));
			i++;
			}else
			desenha.messageNomeInvalido();
		}
		adicionarListaDeJogadoresNaCasaDePartida(repo.getJogadores());
		iniciaJogadorDaVez();
		desenha.desenhaPecasNoTabuleiro(tabuleiro.getTabuleiro());
	}
	public void adicionarListaDeJogadoresNaCasaDePartida(List<Jogador> jogadores) {
		for (Jogador jogador : jogadores) {
			repo.getJogadoresAindaJogando().add(jogador);
			tabuleiro.adiconarJogadoresACasaDePartida(constante.INDICE_DA_CASA_DE_PARTIDA, jogador);
		}
	}
	public void iniciaJogadorDaVez(){
		jogadorDaVEZ = repo.getJogadores().get(constante.JOGADOR_NA_PRIMEIRA_POSICAO_DA_LISTA);
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
			if(verifica.verificaIsPressionado(desenha.getMouse(), desenha.getBotao())){
				
			desenha.atualizaTabuleiro();
			String resultado = desenha.inputEntradaDados(jogadorDaVEZ);

			if (verifica.verificaJogadaIsValida(resultado)) {
				int resultadoDados = Integer.valueOf(resultado);
				if (verifica.verificaTamanhoJogadaIsValida(resultadoDados)) {
					
					int indiceCasaDestino = calculaIndiceCasa.obterIndiceProximaCasa(jogadorDaVEZ.getPosicaoAtualJogador(), resultadoDados);
					destino = tabuleiro.getCasaByIndice(indiceCasaDestino);
					
					moverJogador(jogadorDaVEZ, destino);
					desenha.moverPecaJogador(destino, jogadorDaVEZ);
					efeito.ativarEfeito(jogadorDaVEZ, destino);

					if (verifica.verificaSeJogadorAindaPossuiSaldo(jogadorDaVEZ)) {
						mudaJogadorDaVez(jogadorDaVEZ.getID(), repo.getJogadores());
					}else{
						repo.getJogadoresAindaJogando().remove(jogadorDaVEZ);
						desenha.messageJogadorNaoPossuiSaldo(jogadorDaVEZ, repo.getJogadoresAindaJogando());
						desenha.messageExisteUmCampeao(repo.getJogadoresAindaJogando());
						executando = false;
					}
				} else
					desenha.messageNumeroDeEntradaDadosInvalido();
			}else
				desenha.messageInputVazio();
		}
			desenha.ativaBotaoPortifolio(desenha.getMouse(), repo.getJogadores());		
		}
		desenha.getWindow().exit();
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
