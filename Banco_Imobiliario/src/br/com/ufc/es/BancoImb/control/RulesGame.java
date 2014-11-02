package br.com.ufc.es.BancoImb.control;

import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import jplay.Sound;
import br.com.ufc.es.BancoImb.constantes.Constantes;
import br.com.ufc.es.BancoImb.model.Jogador;

public class RulesGame {
	private br.com.ufc.es.BancoImb.sound.Sound som;
	public RulesGame() {
		som = new br.com.ufc.es.BancoImb.sound.Sound();
	}
	
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
	
	public boolean verificaSeJogadorAindaPossuiSaldo(Jogador jogador){
		boolean possuiSaldo = false;
		if (jogador.getSaldo() < 0) {
			return possuiSaldo;
		} else {
			possuiSaldo = true;
		}
		return possuiSaldo;
		
	}
	public boolean jogadaIsValida(String resultado){
		boolean isValida = false;
		if (!resultado.equals("") && !resultado.equals(null)) {
			isValida = true;
		}
		return isValida;	
	}
	public boolean tamanhoJogadaIsValida(int resultadoDados){
		boolean tamanhoIsValido = false;		
		if (resultadoDados <= 12 && resultadoDados > 0) {
			tamanhoIsValido = true;
		}
		return tamanhoIsValido;
	}
	public boolean qtdJogadoresIsValida(int qtd_jogadores){
		boolean qtdIsValida = false;
		if (qtd_jogadores > 1 && qtd_jogadores < 6) {
			qtdIsValida = true;
		}
		return qtdIsValida;
	}

}
