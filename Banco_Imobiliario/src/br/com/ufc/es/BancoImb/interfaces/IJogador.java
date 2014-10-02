package br.com.ufc.es.BancoImb.interfaces;

import br.com.ufc.es.BancoImb.model.LogradouroComercializavel;

public interface IJogador {
	
	public void comprar(LogradouroComercializavel logradouro);
	public void pagarTaxa(LogradouroComercializavel logradouro);
	public void receberTaxa(LogradouroComercializavel logradouro);

}
