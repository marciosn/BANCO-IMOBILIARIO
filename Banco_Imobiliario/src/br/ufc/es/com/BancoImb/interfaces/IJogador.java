package br.ufc.es.com.BancoImb.interfaces;

import br.ufc.es.com.BancoImb.model.LogradouroComercializavel;

public interface IJogador {
	public void comprar(LogradouroComercializavel casa);
	public void pagarTaxa(float taxa);
	public void receberTaxa(float taxa);
	public void adicionarLogradouroAOPortifolio(LogradouroComercializavel logradouro);
	public int getQuantidadeLogradouros();

}
