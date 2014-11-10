package br.ufc.es.com.BancoImb.utils;

import jplay.Animation;
import jplay.Mouse;
import br.ufc.es.com.BancoImb.interfaces.IVerificacoes;
import br.ufc.es.com.BancoImb.model.Jogador;
import br.ufc.es.com.BancoImb.model.LogradouroComercializavel;

public class VerificacoesDeLogicaDoJogo implements IVerificacoes{

	@Override
	public boolean verificaSeJogadorAindaPossuiSaldo(Jogador jogador) {
		// TODO Auto-generated method stub
		boolean possuiSaldo = false;
		if (jogador.getSaldo() <= 0) {
			return possuiSaldo;
		} else {
			possuiSaldo = true;
		}
		return possuiSaldo;	
	}

	@Override
	public boolean verificaJogadaNaoNulaOuVazia(String resultado) {
		// TODO Auto-generated method stub
		boolean isValida = false;
		if (!verificaInputDiferentedeNull(resultado) && !resultado.equals("") && !resultado.equals(null)) {
			isValida = true;
		}
		return isValida;	
	}

	@Override
	public boolean verificaSeNumerosDosDadosSaoValidos(int resultadoDados) {
		// TODO Auto-generated method stub
		boolean tamanhoIsValido = false;		
		if (resultadoDados <= 12 && resultadoDados > 0) {
			tamanhoIsValido = true;
		}
		return tamanhoIsValido;
	}

	@Override
	public boolean verificaQuantidadeJogadoresIsValida(int qtd_jogadores) {
		// TODO Auto-generated method stub
		boolean qtdIsValida = false;
		if (qtd_jogadores == new Constantes().QUANTIDADE_jOGADORES) {
			qtdIsValida = true;
		}
		return qtdIsValida;
	}

	@Override
	public boolean verificaNomeIsValido(String nomeJogador) {
		// TODO Auto-generated method stub
		boolean nomeIsValido = false;
		if(!verificaInputDiferentedeNull(nomeJogador) && !nomeJogador.equals("") && nomeJogador.length() >= 3){
			nomeIsValido = true;
		}
		return nomeIsValido;
	}

	@Override
	public boolean verificaIsPressionado(Mouse mouse, Animation botao) {
		// TODO Auto-generated method stub
		boolean isPressed = false;
		if(mouse.isOverObject(botao) && mouse.isLeftButtonPressed()){
			isPressed = true;
		}
		return isPressed;
	}

	@Override
	public boolean verificaInputDiferentedeNull(String entrada) {
		// TODO Auto-generated method stub
		boolean isNull = false;
		if(entrada == null){
			isNull = true;
		}
		return isNull;
	}

	@Override
	public boolean verificaSeJogadorPossuiSaldoParaComprar(Jogador jogador,
			LogradouroComercializavel casa) {
		// TODO Auto-generated method stub
		boolean possuiSaldo = false;
		if(jogador.getSaldo() >=  casa.getValor()){
			possuiSaldo = true;
		}
		return possuiSaldo;
	}

	@Override
	public boolean verificaSeACasaJaEDoJogador(Jogador jogador,
			LogradouroComercializavel casa) {
		// TODO Auto-generated method stub
		boolean aCasaEMinha = false;
		if(casa.getProprietario().equals(jogador)){
			aCasaEMinha = true;
		}
		return aCasaEMinha;
	}

	@Override
	public boolean verificaSeJogadorEstaPreso(Jogador jogador) {
		// TODO Auto-generated method stub
		boolean estaPreso = false;
		if(jogador.getIndiceAtualJogador() == 30){ //30 é a posição da casa prisão no tabuleiro
			estaPreso = true;
		}
		return estaPreso;
	}
	@Override
	public boolean verificaSeJogadorPassouNaPartida(int posicaoAtual, int resultadoDados){
		boolean passouNaPartida = false;
		int soma = posicaoAtual + resultadoDados;
		if(soma != 39){
			if(soma > new Constantes().QUANTIDADE_DE_CASAS_DO_TABULEIRO - 1)
			passouNaPartida = true;
		}
		return passouNaPartida;
	}
}
