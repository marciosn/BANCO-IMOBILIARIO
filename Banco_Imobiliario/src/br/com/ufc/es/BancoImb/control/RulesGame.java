package br.com.ufc.es.BancoImb.control;

import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import jplay.Sound;
import br.com.ufc.es.BancoImb.constantes.Constantes;
import br.com.ufc.es.BancoImb.model.Jogador;

public class RulesGame {
	public boolean verificaJogadoresAindaNoJogo(List<Jogador> jogadoresNoJogo){
		boolean aindaJogando = false;
		if (jogadoresNoJogo.size() == 1) {
			new Sound(new Constantes().PATH_AUDIO + "champions.wav").play();
			JOptionPane.showMessageDialog(null, "O jogador "
					+ jogadoresNoJogo.get(0).getNome() + "\n"
					+ "Venceu o jogo", "Vencedor", JOptionPane.PLAIN_MESSAGE, new ImageIcon(new Constantes().PATH_IMAGE + "win.png"));
			
		}
		return aindaJogando;
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

}
