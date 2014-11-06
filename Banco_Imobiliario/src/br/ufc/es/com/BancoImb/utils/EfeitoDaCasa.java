package br.ufc.es.com.BancoImb.utils;

import br.ufc.es.com.BancoImb.model.CasaDoTabuleiro;
import br.ufc.es.com.BancoImb.model.Jogador;

public class EfeitoDaCasa {
	
	public void ativarEfeito(Jogador jogador, CasaDoTabuleiro casa) {
		
		casa.ativarEfeito(jogador);
	}

}
