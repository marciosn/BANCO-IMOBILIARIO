package br.ufc.es.com.BancoImb.control;

import java.util.List;

import br.ufc.es.com.BancoImb.model.CasaDoTabuleiro;
import br.ufc.es.com.BancoImb.model.ContaBancaria;
import br.ufc.es.com.BancoImb.model.Jogador;
import br.ufc.es.com.BancoImb.model.PecaJogador;
import br.ufc.es.com.BancoImb.repositorios.Repositorio;
import br.ufc.es.com.BancoImb.tabuleiro.Tabuleiro;
import br.ufc.es.com.BancoImb.utils.CalculaIndices;
import br.ufc.es.com.BancoImb.utils.Constantes;
import br.ufc.es.com.BancoImb.utils.EfeitoDaCasa;
import br.ufc.es.com.BancoImb.utils.InsereJogadores;
import br.ufc.es.com.BancoImb.utils.VerificacoesDeLogicaDoJogo;
import br.ufc.es.com.BancoImb.view.DesenhaComponentesGraficos;

/**
 * https://github.com/marciosn/BANCO-IMOBILIARIO.git
 * 
 * @author Márcio Souza
 * 
 * **/
public class ControladorBancoImobiliario {
	
	private Tabuleiro tabuleiro;
	private Jogador jogadorDaVEZ;
	private boolean executando = true;
	private EfeitoDaCasa efeito;
	private Constantes constante;
	private DesenhaComponentesGraficos desenha;
	private VerificacoesDeLogicaDoJogo verifica;
	private Repositorio repo;
	private InsereJogadores insereJogadores;
	private CalculaIndices calcula;

	public ControladorBancoImobiliario() {
		constante = new Constantes();
		desenha = new DesenhaComponentesGraficos();
		instanciaComponentesGraficos();
		verifica = new VerificacoesDeLogicaDoJogo();
		repo = new Repositorio();
		efeito = new EfeitoDaCasa();
		tabuleiro = new Tabuleiro(repo.getTabuleiro());
		desenha.atualizaTabuleiro();
		calcula = new CalculaIndices();
		insereJogadores = new InsereJogadores(repo);
		//inserirJogador();
		insere();
		iniciarJogo();
	}
	
	public void insere(){
		insereJogadores.inserirJogador();
		iniciaJogadorDaVez();
		desenha.desenhaPecasNoTabuleiro(tabuleiro.getTabuleiro());
	}
	
	public void inserirJogador() {
		for (int i = 0; i < constante.QUANTIDADE_jOGADORES;) {
			String nomeJogador = desenha.inputDigiteONomeDoJogador(i);
			if(verifica.verificaNomeIsValido(nomeJogador)){
				String peca = constante.PECA + repo.getJogadores().size() + constante.FORMATO_IMAGEM;
				
				repo.adicionaJogador(new Jogador(nomeJogador,
						new ContaBancaria(500), 
						new PecaJogador(constante.PATH_IMAGE + peca)));
				
		i++;
			}else
			desenha.messageNomeInvalido();
		}
		repo.adicionaListaDeJogadoresNaCasaDePartida();
		iniciaJogadorDaVez();
		desenha.desenhaPecasNoTabuleiro(tabuleiro.getTabuleiro());
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
					
					int indiceCasaDestino = calcula.obterIndiceProxCasa(jogadorDaVEZ.getPosicaoAtualJogador(), resultadoDados);
					destino = tabuleiro.getCasaByIndice(indiceCasaDestino);
					
					moverJogador(jogadorDaVEZ, destino);

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
	public void salvarIntaciaTabuleiro(){
		constante.setTabuleiro(tabuleiro);
	}
	public void instanciaComponentesGraficos(){
		desenha.instanciaObjetos();
	}
	public void iniciaJogadorDaVez(){
		jogadorDaVEZ = repo.getJogadores().get(constante.JOGADOR_NA_PRIMEIRA_POSICAO_DA_LISTA);
	}
	public void moverJogador(Jogador jogador, CasaDoTabuleiro destino) {
		tabuleiro.moverJogador(jogador, destino);
		desenha.moverPecaJogador(jogador, destino);
		ativarEfeitoDaCasa(jogador, destino);
	}
	public void ativarEfeitoDaCasa(Jogador jogador, CasaDoTabuleiro destino){
		efeito.ativarEfeito(jogador, destino);
	}
	public void mudaJogadorDaVez(int IdJogadorAtual, List<Jogador> jogadores){
		setJogadorDaVEZ(tabuleiro.getJogadorByID(calcula.obterIndiceProxJogador(IdJogadorAtual, jogadores)));
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
