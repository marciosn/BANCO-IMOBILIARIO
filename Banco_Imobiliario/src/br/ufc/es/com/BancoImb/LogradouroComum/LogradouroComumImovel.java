package br.ufc.es.com.BancoImb.LogradouroComum;

import java.awt.Point;

import br.ufc.es.com.BancoImb.model.Jogador;
import br.ufc.es.com.BancoImb.model.LogradouroComum;
import br.ufc.es.com.BancoImb.view.DesenhaComponentesGraficos;

public class LogradouroComumImovel extends LogradouroComum{
	private DesenhaComponentesGraficos desenha;
	
	public LogradouroComumImovel(String nome, float valor, float taxa, Point posicao) {
		super(nome, valor, taxa, posicao);
		desenha = new DesenhaComponentesGraficos();
	}
	
	public void ativarEfeito(Jogador jogador){
		if (!this.isVendido()) {
			int respostaDoJogador = desenha.inputRepostaDoJogadorSobreCompraLogradouro(this.getNome());	
			
			if(respostaDoJogador == 0){
				jogador.comprar(this);
				desenha.messageJogadorComprouLogradouro(jogador, this.getNome());
			}
			
		}else{
			jogador.pagarTaxa(this.getTaxa());
			this.getProprietario().receberTaxa(this.getTaxa());
			desenha.messageJogadorPagouTaxa(jogador, this.getProprietario());
		}
		
	}
}
