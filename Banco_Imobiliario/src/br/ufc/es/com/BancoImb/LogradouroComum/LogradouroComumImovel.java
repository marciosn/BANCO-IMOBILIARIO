package br.ufc.es.com.BancoImb.LogradouroComum;

import java.awt.Point;

import br.ufc.es.com.BancoImb.model.Jogador;
import br.ufc.es.com.BancoImb.model.LogradouroComercializavel;
import br.ufc.es.com.BancoImb.utils.VerificacoesDeLogicaDoJogo;
import br.ufc.es.com.BancoImb.view.DesenhaComponentesGraficos;

public class LogradouroComumImovel extends LogradouroComercializavel{
	public LogradouroComumImovel(String nome, float valor, float taxa,
			Point posicao, int indice) {
		super(nome, valor, taxa, posicao, indice);
		desenha = new DesenhaComponentesGraficos();
		verifica = new VerificacoesDeLogicaDoJogo();
	}

	private DesenhaComponentesGraficos desenha;
	private VerificacoesDeLogicaDoJogo verifica;
	
	/*public LogradouroComumImovel(String nome, float valor, float taxa, Point posicao) {
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
}
