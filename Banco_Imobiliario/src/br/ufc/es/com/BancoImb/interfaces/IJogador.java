package br.ufc.es.com.BancoImb.interfaces;

import br.ufc.es.com.BancoImb.model.CasaDoTabuleiro;

public interface IJogador {
	public void comprar(CasaDoTabuleiro logradouro);
	//public void pagarTaxa(CasaDoTabuleiro logradouro);
	public void pagarTaxa(float taxa);
	//public void receberTaxa(CasaDoTabuleiro logradouro);
	public void receberTaxa(float taxa);
	public void adicionarLogradouroAOPortifolio(CasaDoTabuleiro logradouro);

}
