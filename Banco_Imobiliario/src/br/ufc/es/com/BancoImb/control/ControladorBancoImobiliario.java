package br.ufc.es.com.BancoImb.control;

import java.util.List;

import br.ufc.es.com.BancoImb.model.CasaDoTabuleiro;
import br.ufc.es.com.BancoImb.model.Jogador;
import br.ufc.es.com.BancoImb.repositorios.RepositorioLists;
import br.ufc.es.com.BancoImb.tabuleiro.Tabuleiro;
import br.ufc.es.com.BancoImb.utils.ObterProximoIndice;
import br.ufc.es.com.BancoImb.utils.Constantes;
import br.ufc.es.com.BancoImb.utils.DisparaEfeitoCasaPartida;
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
	private DesenhaComponentesGraficos desenha;
	private VerificacoesDeLogicaDoJogo verifica;
	private RepositorioLists repositorioLists;
	private InsereJogadores insereJogadores;
	private ObterProximoIndice obterIndice;

	public ControladorBancoImobiliario() {
		desenha = new DesenhaComponentesGraficos();
		
		//inicia a construção dos componentes graficos
		instanciaComponentesGraficos();
		
		verifica = new VerificacoesDeLogicaDoJogo();
		repositorioLists = new RepositorioLists();
		efeito = new EfeitoDaCasa();
		tabuleiro = new Tabuleiro(repositorioLists.getTabuleiro());
		desenha.atualizaTabuleiro();
		obterIndice = new ObterProximoIndice();
		insereJogadores = new InsereJogadores(repositorioLists);
		inserirJogadores();
		iniciarJogo();
	}
	
	public void inserirJogadores(){
		insereJogadores.inserirJogador();
		iniciaJogadorDaVez();
		desenha.desenhaPecasNoTabuleiro(tabuleiro.getTabuleiro());
	}
	public void instanciaComponentesGraficos(){
		desenha.instanciaObjetos();
	}
	public void iniciaJogadorDaVez(){
		jogadorDaVEZ = repositorioLists.getPrimeiroJogadorDaLista();
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
		setJogadorDaVEZ(tabuleiro.getJogadorByID(obterIndice.obterIndiceProxJogador(IdJogadorAtual, jogadores)));
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
					
					int indiceCasaDestino = obterIndice.obterIndiceProxCasa(jogadorDaVEZ.getPosicaoAtualJogador(), resultadoDados);
					destino = tabuleiro.getCasaByIndice(indiceCasaDestino);
					
					moverJogador(jogadorDaVEZ, destino);

					if (verifica.verificaSeJogadorAindaPossuiSaldo(jogadorDaVEZ)) {
						mudaJogadorDaVez(jogadorDaVEZ.getID(), repositorioLists.getJogadores());
					}else{
						repositorioLists.removerDeJogadoresAindaJogando(jogadorDaVEZ);
						desenha.messageJogadorNaoPossuiSaldo(jogadorDaVEZ, repositorioLists.getJogadoresAindaJogando());
						desenha.messageExisteUmCampeao(repositorioLists.getJogadoresAindaJogando());
						executando = false;
					}
				} else
					desenha.messageNumeroDeEntradaDadosInvalido();
			}else
				desenha.messageInputVazio();
		}
			desenha.ativaBotaoPortifolio(desenha.getMouse(), repositorioLists.getJogadores());		
		}
		desenha.getWindow().exit();
	}
	public void setJogadorDaVEZ(Jogador jogadorDaVEZ) {
		this.jogadorDaVEZ = jogadorDaVEZ;
	}
}
