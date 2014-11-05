package br.ufc.es.com.BancoImb.LogradouroComum;

import java.awt.Point;

import javax.swing.JOptionPane;

import br.ufc.es.com.BancoImb.interfaces.IEfeitoCasa;
import br.ufc.es.com.BancoImb.model.Jogador;
import br.ufc.es.com.BancoImb.model.LogradouroComum;
import br.ufc.es.com.BancoImb.view.DesenhaComponentesGraficos;

public class LogradouroComumImovel extends LogradouroComum implements IEfeitoCasa{
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
			jogador.pagarTaxa(this);
			this.getProprietario().receberTaxa(this);
			desenha.messageJogadorPagouTaxa(jogador, this.getProprietario());
		}
		
	}
}
