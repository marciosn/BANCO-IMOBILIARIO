package br.ufc.es.com.BancoImb.interfaces;

import br.ufc.es.com.BancoImb.model.CasaDoTabuleiro;
import br.ufc.es.com.BancoImb.model.Jogador;

public interface ITabuleiro {
	public void criarCasasNoTabuleiro();
	public void adiconarJogadoresACasaDePartida(int indice, Jogador jogador);
	public void moverJogador(Jogador jogador, CasaDoTabuleiro destino);
	public CasaDoTabuleiro getCasaByIndice(int indice);
	public int getIndiceByCasa(CasaDoTabuleiro casa);
	public Jogador getJogadorByID(int id);
	public CasaDoTabuleiro getCasaByJogador(Jogador jogador);

}
