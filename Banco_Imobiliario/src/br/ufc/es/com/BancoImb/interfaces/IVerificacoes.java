package br.ufc.es.com.BancoImb.interfaces;

import jplay.Animation;
import jplay.Mouse;
import br.ufc.es.com.BancoImb.model.Jogador;
import br.ufc.es.com.BancoImb.model.LogradouroComercializavel;

public interface IVerificacoes {
	public boolean verificaSeJogadorAindaPossuiSaldo(Jogador jogador);
	public boolean verificaJogadaNaoNulaOuVazia(String resultado);
	public boolean verificaSeNumerosDosDadosSaoValidos(int resultadoDados);
	public boolean verificaQuantidadeJogadoresIsValida(int qtd_jogadores);
	public boolean verificaNomeIsValido(String nomeJogador);
	public boolean verificaIsPressionado(Mouse mouse, Animation botao);
	public boolean verificaInputDiferentedeNull(String entrada);
	public boolean verificaSeJogadorPossuiSaldoParaComprar(Jogador jogador, LogradouroComercializavel casa);
	public boolean verificaSeACasaJaEDoJogador(Jogador jogador, LogradouroComercializavel casa);
	public boolean verificaSeJogadorEstaPreso(Jogador jogador);
	public boolean verificaSeJogadorPassouNaPartida(int posicaoAtual, int resultadoDados);

}
