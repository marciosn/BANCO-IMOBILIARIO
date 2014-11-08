package br.ufc.es.com.BancoImb.Lugradouros;

import java.awt.Point;

import br.ufc.es.com.BancoImb.model.CasaDoTabuleiro;
import br.ufc.es.com.BancoImb.model.Jogador;
import br.ufc.es.com.BancoImb.model.LogradouroComercializavel;
import br.ufc.es.com.BancoImb.utils.VerificacoesDeLogicaDoJogo;
import br.ufc.es.com.BancoImb.view.DesenhaComponentesGraficos;

public class LogradouroComumEmpresa extends LogradouroComercializavel{
	public LogradouroComumEmpresa(String nome, float valor, float taxa,
			Point posicao, int indice) {
		super(nome, valor, taxa, posicao, indice);
		desenha = new DesenhaComponentesGraficos();
		verifica = new VerificacoesDeLogicaDoJogo();
	}

	private DesenhaComponentesGraficos desenha;
	private VerificacoesDeLogicaDoJogo verifica;

	/*public LogradouroComumEmpresa(String nome, float valor, float taxa, Point posicao) {
		super(nome, valor, taxa, posicao);
		desenha = new DesenhaComponentesGraficos();
		verifica = new VerificacoesDeLogicaDoJogo();
	}*/
	
	public void ativarEfeito(Jogador jogador){
		if (!this.isVendido()) {
			int respostaDoJogador = desenha.inputRepostaDoJogadorSobreCompraLogradouro(this.getNome());
			
			if(respostaDoJogador == 0){
				if(verifica.verificaSeJogadorPossuiSaldoParaComprar(jogador, this)){
				jogador.comprar(this);
				desenha.messageJogadorComprouLogradouro(jogador, this.getNome());
				}else
					desenha.messageNaoPossuiSaldoParaComprar();
			}
		}else{
			if(!verifica.verificaSeACasaEMinha(jogador, this)){
			jogador.pagarTaxa(this.getTaxa());
			this.getProprietario().receberTaxa(this.getTaxa());
			desenha.messageJogadorPagouTaxa(jogador, this.getProprietario());
			}else
				desenha.messageACasaJaESua();
		}
	}
	public void mover(Jogador jogador, CasaDoTabuleiro destino){
		CasaDoTabuleiro origem = jogador.getPosicaoJogador();
		jogador.setPosicaoJogador(destino);
		jogador.setIndiceAtualJogador(destino.getIndice());
		destino.adicionarJogadoresNaListaDaCasa(jogador);
		origem.removerJogadoresDaListaDaCasa(jogador);
	}
	
}
