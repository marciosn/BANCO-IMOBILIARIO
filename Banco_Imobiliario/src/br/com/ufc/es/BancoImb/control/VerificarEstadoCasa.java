package br.com.ufc.es.BancoImb.control;

import javax.swing.JOptionPane;

import br.com.ufc.es.BancoImb.model.Casa;
import br.com.ufc.es.BancoImb.model.Jogador;

public class VerificarEstadoCasa {
	Jogador jogador;

	public void verificarEstado(Jogador jogador, Casa casa) {
		if (!casa.isVendido()) {
			int resposta = JOptionPane.showConfirmDialog(null, "Essa casa n�o possui propriet�rio, quer compra-la ?",
					"Comprar Casa", JOptionPane.YES_NO_OPTION);
			
			if(resposta == 0){
				jogador.comprar(casa);
				
				JOptionPane.showMessageDialog(null, "O jogador " + jogador.getNome() + " comprou a casa " + casa.getNome() + "\n" + 
				"O novo saldo do jogador �: " + jogador.getSaldo());
			}
			
		}else{
			jogador.pagarTaxa(casa);
			casa.getProprietario().receberTaxa(casa);
			JOptionPane.showMessageDialog(null, "Esta casa � de propriedade do jogador " + casa.getProprietario().getNome() +"\n" +
					"Voc� precisa pagar uma taxa por passar aqui, seu novo saldo �: " + jogador.getSaldo() + "\n" +
					 casa.getProprietario().getNome() + "agora possui saldo = " + casa.getProprietario().getSaldo());
		}

	}

}