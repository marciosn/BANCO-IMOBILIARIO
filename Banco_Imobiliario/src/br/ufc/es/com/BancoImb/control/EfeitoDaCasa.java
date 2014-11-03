package br.ufc.es.com.BancoImb.control;

import br.ufc.es.com.BancoImb.model.CasaDoTabuleiro;
import br.ufc.es.com.BancoImb.model.Jogador;

public class EfeitoDaCasa {
	
	public void executarComportamento(Jogador jogador, CasaDoTabuleiro casa) {
		casa.ativarEfeito(jogador);
	}

}
