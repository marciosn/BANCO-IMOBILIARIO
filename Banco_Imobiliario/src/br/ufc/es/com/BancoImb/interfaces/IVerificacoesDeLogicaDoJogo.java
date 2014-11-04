package br.ufc.es.com.BancoImb.interfaces;

import java.util.List;

import jplay.Animation;
import jplay.Mouse;

import br.ufc.es.com.BancoImb.model.Jogador;

public interface IVerificacoesDeLogicaDoJogo {
	public boolean verificaSeExisteVencedor(List<Jogador> jogadoresNoJogo);
	public boolean verificaSeJogadorAindaPossuiSaldo(Jogador jogador);
	public boolean verificaJogadaIsValida(String resultado);
	public boolean verificaTamanhoJogadaIsValida(int resultadoDados);
	public boolean verificaQuantidadeJogadoresIsValida(int qtd_jogadores);
	public boolean verificaNomeIsValido(String nomeJogador);
	public boolean verificaIsPressed(Mouse mouse, Animation botao);

}
