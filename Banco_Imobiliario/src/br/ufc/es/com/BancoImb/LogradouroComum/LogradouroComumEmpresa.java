package br.ufc.es.com.BancoImb.LogradouroComum;

import java.awt.Point;

import br.ufc.es.com.BancoImb.model.Jogador;
import br.ufc.es.com.BancoImb.model.LogradouroComercializavel;
import br.ufc.es.com.BancoImb.utils.VerificacoesDeLogicaDoJogo;
import br.ufc.es.com.BancoImb.view.DesenhaComponentesGraficos;

public class LogradouroComumEmpresa extends LogradouroComercializavel{
	private DesenhaComponentesGraficos desenha;
	private VerificacoesDeLogicaDoJogo verifica;

	public LogradouroComumEmpresa(String nome, float valor, float taxa, Point posicao) {
		super(nome, valor, taxa, posicao);
		desenha = new DesenhaComponentesGraficos();
		verifica = new VerificacoesDeLogicaDoJogo();
	}
	
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
			jogador.pagarTaxa(this.getTaxa());
			this.getProprietario().receberTaxa(this.getTaxa());
			desenha.messageJogadorPagouTaxa(jogador, this.getProprietario());
		}
	}
	
}
