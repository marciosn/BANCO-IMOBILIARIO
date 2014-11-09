package br.ufc.es.com.BancoImb.control;

import java.util.List;

import javax.jws.Oneway;
import javax.swing.JOptionPane;

import br.ufc.es.com.BancoImb.model.CasaDoTabuleiro;
import br.ufc.es.com.BancoImb.model.Jogador;
import br.ufc.es.com.BancoImb.repositorios.RepositorioLists;
import br.ufc.es.com.BancoImb.utils.InsereJogadores;
import br.ufc.es.com.BancoImb.utils.ObterProximoIndice;
import br.ufc.es.com.BancoImb.utils.VerificacoesDeLogicaDoJogo;
import br.ufc.es.com.BancoImb.view.DesenhaComponentesGraficos;

/**
 * https://github.com/marciosn/BANCO-IMOBILIARIO.git
 * 
 * @author Márcio Souza
 * 
 * **/
public class ControllBancoImobiliario {
	
	private Tabuleiro tabuleiro;
	private Jogador jogadorDaVEZ;
	private boolean executando = true;
	private DesenhaComponentesGraficos desenha;
	private VerificacoesDeLogicaDoJogo verifica;
	private RepositorioLists lists;
	private InsereJogadores insereJogadores;
	private ObterProximoIndice obterIndice;

	public ControllBancoImobiliario() {
		desenha = new DesenhaComponentesGraficos();
		instanciaComponentesGraficos();
		verifica = new VerificacoesDeLogicaDoJogo();
		lists = new RepositorioLists();
		tabuleiro = new Tabuleiro(lists);
		desenha.atualizaTabuleiro();
		obterIndice = new ObterProximoIndice();
		insereJogadores = new InsereJogadores(lists);
		inserirJogadores();
		iniciarJogo();
	}
	
	public void inserirJogadores(){
		insereJogadores.inserirJogador();
		iniciaJogadorDaVez();
		desenha.desenhaPecasNoTabuleiro(lists.getTabuleiro());
	}
	
	public void instanciaComponentesGraficos(){
		desenha.instanciaObjetos();
	}
	
	public void iniciaJogadorDaVez(){
		jogadorDaVEZ = lists.getPrimeiroJogadorDaLista();
	}
	
	public void moverJogador(Jogador jogador, CasaDoTabuleiro destino) {
		desenha.moverPecaJogador(jogador, destino);
		destino.mover(jogadorDaVEZ, destino);
		destino.ativarEfeito(jogador);
	}

	public void mudaJogadorDaVez(int IdJogadorAtual, List<Jogador> jogadores){
			int id = obterIndice.obterIndiceProxJogador(IdJogadorAtual, jogadores);
			
			jogadorDaVEZ = lists.getJogadorByID(id);
			desenha.messageJogadorDaVez(jogadorDaVEZ);
			
			if(lists.getJogadoresPresos().contains(jogadorDaVEZ)){
				
				desenha.messageJogadorEstaPreso(jogadorDaVEZ);
				lists.getJogadoresPresos().remove(jogadorDaVEZ);
				int newId = jogadorDaVEZ.getID();
				jogadorDaVEZ = lists.getJogadorByID(obterIndice.obterIndiceProxJogador(newId, jogadores));
			}
	}
	
	public void iniciarJogo() {
		CasaDoTabuleiro destino;
		while (executando) {
			if(verifica.verificaIsPressionado(desenha.getMouse(), desenha.getBotao())){
				
			desenha.atualizaTabuleiro();
			String resultado = desenha.inputEntradaDados(jogadorDaVEZ);

			if (verifica.verificaJogadaNaoNulaOuVazia(resultado)) {
				int resultadoDados = Integer.valueOf(resultado);
				if (verifica.verificaSeNumerosDosDadosSaoValidos(resultadoDados)) {
					
					int indiceCasaDestino = obterIndice.obterIndiceProxCasa(jogadorDaVEZ.getIndiceAtualJogador(), resultadoDados);
					destino = lists.getCasaByIndice(indiceCasaDestino);
					
					moverJogador(jogadorDaVEZ, destino);
					
					if (verifica.verificaSeJogadorAindaPossuiSaldo(jogadorDaVEZ)) {
						mudaJogadorDaVez(jogadorDaVEZ.getID(), lists.getJogadores());
					}else{
						lists.removerDeJogadoresAindaJogando(jogadorDaVEZ);
						desenha.messageJogadorNaoPossuiSaldo(jogadorDaVEZ, lists.getJogadoresAindaJogando());
						desenha.messageExisteUmCampeao(lists.getJogadoresAindaJogando());
						executando = false;
					}
				} else
					desenha.messageNumeroDeEntradaDadosInvalido();
			}else
				desenha.messageInputVazio();
		}
			desenha.ativaBotaoPortifolio(desenha.getMouse(), lists.getJogadores());		
		}
		desenha.getWindow().exit();
	}
}
