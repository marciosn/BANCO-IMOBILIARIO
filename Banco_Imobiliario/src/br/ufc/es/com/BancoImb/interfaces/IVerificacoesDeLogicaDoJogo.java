package br.ufc.es.com.BancoImb.interfaces;

import jplay.Animation;
import jplay.Mouse;
import br.ufc.es.com.BancoImb.model.Jogador;

public interface IVerificacoesDeLogicaDoJogo {
	public boolean verificaSeJogadorAindaPossuiSaldo(Jogador jogador);
	public boolean verificaJogadaIsValida(String resultado);
	public boolean verificaTamanhoJogadaIsValida(int resultadoDados);
	public boolean verificaQuantidadeJogadoresIsValida(int qtd_jogadores);
	public boolean verificaNomeIsValido(String nomeJogador);
	public boolean verificaIsPressed(Mouse mouse, Animation botao);
	public boolean inputDiferentedeNull(String entrada);

}
