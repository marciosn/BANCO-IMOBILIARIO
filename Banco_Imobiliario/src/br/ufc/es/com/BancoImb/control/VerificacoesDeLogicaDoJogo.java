package br.ufc.es.com.BancoImb.control;

import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import jplay.Animation;
import jplay.Mouse;
import jplay.Sound;
import br.ufc.es.com.BancoImb.constantes.Constantes;
import br.ufc.es.com.BancoImb.interfaces.IVerificacoesDeLogicaDoJogo;
import br.ufc.es.com.BancoImb.model.Jogador;

public class VerificacoesDeLogicaDoJogo implements IVerificacoesDeLogicaDoJogo{
	
	private br.ufc.es.com.BancoImb.sound.Sound som;
	public VerificacoesDeLogicaDoJogo() {
		som = new br.ufc.es.com.BancoImb.sound.Sound();
	}
	@Override
	public boolean verificaSeExisteVencedor(List<Jogador> jogadoresNoJogo){
		boolean existeVencedor = false;
		if (jogadoresNoJogo.size() == 1) {
			existeVencedor = true;
			som.winSound();
			JOptionPane.showMessageDialog(null, "O jogador "
					+ jogadoresNoJogo.get(0).getNome() + "\n"
					+ "Venceu o jogo", "Vencedor", JOptionPane.PLAIN_MESSAGE, new ImageIcon(new Constantes().PATH_IMAGE + "win.png"));		
		}
		return existeVencedor;
	}
	@Override
	public boolean verificaSeJogadorAindaPossuiSaldo(Jogador jogador){
		boolean possuiSaldo = false;
		if (jogador.getSaldo() < 0) {
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
		if (qtd_jogadores > 1 && qtd_jogadores < 6) {
			qtdIsValida = true;
		}
		return qtdIsValida;
	}
	@Override
	public boolean verificaNomeIsValido(String nomeJogador){
		boolean nomeIsValido = false;
		if(!nomeJogador.equals("")){
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
