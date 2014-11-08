package br.ufc.es.com.BancoImb.utils;

import jplay.Animation;
import jplay.Mouse;
import br.ufc.es.com.BancoImb.model.CasaDoTabuleiro;
import br.ufc.es.com.BancoImb.model.Jogador;
import br.ufc.es.com.BancoImb.model.LogradouroComercializavel;

public class VerificacoesDeLogicaDoJogo{
	public boolean verificaSeJogadorAindaPossuiSaldo(Jogador jogador){
		boolean possuiSaldo = false;
		if (jogador.getSaldo() <= 0) {
			return possuiSaldo;
		} else {
			possuiSaldo = true;
		}
		return possuiSaldo;	
	}
	public boolean verificaJogadaIsValida(String resultado){
		boolean isValida = false;
		if (!verificaInputDiferentedeNull(resultado) && !resultado.equals("") && !resultado.equals(null)) {
			isValida = true;
		}
		return isValida;	
	}
	public boolean verificaTamanhoJogadaIsValida(int resultadoDados){
		boolean tamanhoIsValido = false;		
		if (resultadoDados <= 12 && resultadoDados > 0) {
			tamanhoIsValido = true;
		}
		return tamanhoIsValido;
	}
	public boolean verificaQuantidadeJogadoresIsValida(int qtd_jogadores){
		boolean qtdIsValida = false;
		if (qtd_jogadores == new Constantes().QUANTIDADE_jOGADORES) {
			qtdIsValida = true;
		}
		return qtdIsValida;
	}
	public boolean verificaNomeIsValido(String nomeJogador){
		boolean nomeIsValido = false;
		if(!verificaInputDiferentedeNull(nomeJogador) && !nomeJogador.equals("") && nomeJogador.length() >= 3){
			nomeIsValido = true;
		}
		return nomeIsValido;
	}
	public boolean verificaIsPressionado(Mouse mouse, Animation botao){
		boolean isPressed = false;
		if(mouse.isOverObject(botao) && mouse.isLeftButtonPressed()){
			isPressed = true;
		}
		return isPressed;
	}
	public boolean verificaInputDiferentedeNull(String entrada){
		boolean isNull = false;
		if(entrada == null){
			isNull = true;
		}
		return isNull;
	}
	public boolean verificaSeJogadorPossuiSaldoParaComprar(Jogador jogador, LogradouroComercializavel casa){
		boolean possuiSaldo = false;
		if(jogador.getSaldo() >=  casa.getValor()){
			possuiSaldo = true;
		}
		return possuiSaldo;
	}
	public boolean verificaSeACasaEMinha(Jogador jogador, LogradouroComercializavel casa){
		boolean aCasaEMinha = false;
		if(casa.getProprietario().equals(jogador)){
			aCasaEMinha = true;
		}
		return aCasaEMinha;
	}
}