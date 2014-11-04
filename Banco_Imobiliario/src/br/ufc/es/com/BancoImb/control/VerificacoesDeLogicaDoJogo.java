package br.ufc.es.com.BancoImb.control;

import jplay.Animation;
import jplay.Mouse;
import br.ufc.es.com.BancoImb.constantes.Constantes;
import br.ufc.es.com.BancoImb.interfaces.IVerificacoesDeLogicaDoJogo;
import br.ufc.es.com.BancoImb.model.Jogador;

public class VerificacoesDeLogicaDoJogo implements IVerificacoesDeLogicaDoJogo{
	@Override
	public boolean verificaSeJogadorAindaPossuiSaldo(Jogador jogador){
		boolean possuiSaldo = false;
		if (jogador.getSaldo() <= 0) {
			return possuiSaldo;
		} else {
			possuiSaldo = true;
		}
		return possuiSaldo;
		
	}
	@Override
	public boolean verificaJogadaIsValida(String resultado){
		boolean isValida = false;
		if (!resultado.equals("") && !resultado.equals(null)) {
			isValida = true;
		}
		return isValida;	
	}
	@Override
	public boolean verificaTamanhoJogadaIsValida(int resultadoDados){
		boolean tamanhoIsValido = false;		
		if (resultadoDados <= 12 && resultadoDados > 0) {
			tamanhoIsValido = true;
		}
		return tamanhoIsValido;
	}
	@Override
	public boolean verificaQuantidadeJogadoresIsValida(int qtd_jogadores){
		boolean qtdIsValida = false;
		if (qtd_jogadores == new Constantes().QUANTIDADE_jOGADORES) {
			qtdIsValida = true;
		}
		return qtdIsValida;
	}
	@Override
	public boolean verificaNomeIsValido(String nomeJogador){
		boolean nomeIsValido = false;
		if(!nomeJogador.equals("") && nomeJogador.length() >= 3){
			nomeIsValido = true;
		}
		return nomeIsValido;
	}
	@Override
	public boolean verificaIsPressed(Mouse mouse, Animation botao){
		boolean isPressed = false;
		if(mouse.isOverObject(botao) && mouse.isLeftButtonPressed()){
			isPressed = true;
		}
		return isPressed;
	}
}
