package br.ufc.es.com.BancoImb.interfaces;

import br.ufc.es.com.BancoImb.model.CasaDoTabuleiro;
import br.ufc.es.com.BancoImb.model.Jogador;

public interface ICasaTabuleiro {
	public void adicionarJogadoresNaListaDaCasa(Jogador jogador);
	public void removerJogadoresDaListaDaCasa(Jogador jogador);
	public void mover(Jogador jogador, CasaDoTabuleiro destino);

}
