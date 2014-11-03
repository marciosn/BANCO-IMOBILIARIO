package br.ufc.es.com.BancoImb.LogradouroComum;

import java.awt.Point;

import javax.swing.JOptionPane;

import br.ufc.es.com.BancoImb.interfaces.IEfeitoCasa;
import br.ufc.es.com.BancoImb.model.Jogador;
import br.ufc.es.com.BancoImb.model.LogradouroComum;

public class LogradouroComumEmpresa extends LogradouroComum implements IEfeitoCasa{

	public LogradouroComumEmpresa(String nome, float valor, float taxa, Point posicao) {
		super(nome, valor, taxa, posicao);
		// TODO Auto-generated constructor stub
	}
	public void ativarEfeito(Jogador jogador){
		if (!this.isVendido()) {
			int respostaDoJogador = JOptionPane.showConfirmDialog(null, "Essa casa n�o possui propriet�rio, quer compra-la?",
					 this.getNome(), JOptionPane.YES_NO_OPTION);
			
			if(respostaDoJogador == 0){
				jogador.comprar(this);
				
				JOptionPane.showMessageDialog(null, "O jogador " + jogador.getNome() + " comprou a casa " +"["+ this.getNome() +"]"+ "\n" + 
				"O novo saldo do jogador �: " + jogador.getSaldo());
			}
			
		}else{
			jogador.pagarTaxa(this);
			this.getProprietario().receberTaxa(this);
			JOptionPane.showMessageDialog(null, "Esta casa � de propriedade do jogador " + this.getProprietario().getNome() +"\n" +
					"Voc� precisa pagar uma taxa por passar aqui, seu novo saldo �: " + jogador.getSaldo() + "\n" +
					 this.getProprietario().getNome() + " agora possui saldo = " + this.getProprietario().getSaldo());
		}
	}
	
}
