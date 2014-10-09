package br.com.ufc.es.BancoImb.control;

import javax.swing.JOptionPane;

import br.com.ufc.es.BancoImb.model.CasaDoTabuleiro;
import br.com.ufc.es.BancoImb.model.Jogador;

public class ExecutaComportamentoDaCasa {
	public void executarComportamento(Jogador jogador, CasaDoTabuleiro casa) {
		if(casa.getValor() != 0){
		
		if (!casa.isVendido()) {
			int respostaDoJogador = JOptionPane.showConfirmDialog(null, "Essa casa não possui proprietário, quer compra-la ?",
					"Comprar Casa", JOptionPane.YES_NO_OPTION);
			
			if(respostaDoJogador == 0){
				jogador.comprar(casa);
				
				JOptionPane.showMessageDialog(null, "O jogador " + jogador.getNome() + " comprou a casa " + casa.getNome() + "\n" + 
				"O novo saldo do jogador é: " + jogador.getSaldo());
			}
			
		}else{
			jogador.pagarTaxa(casa);
			casa.getProprietario().receberTaxa(casa);
			JOptionPane.showMessageDialog(null, "Esta casa é de propriedade do jogador " + casa.getProprietario().getNome() +"\n" +
					"Você precisa pagar uma taxa por passar aqui, seu novo saldo é: " + jogador.getSaldo() + "\n" +
					 casa.getProprietario().getNome() + "agora possui saldo = " + casa.getProprietario().getSaldo());
		}
		
	}
		else{
			casa.executarComportamento(jogador);
		}
			

	}

}
