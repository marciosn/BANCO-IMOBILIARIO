package br.com.ufc.es.BancoImb.LugarEspecial;

import javax.swing.JOptionPane;

import br.com.ufc.es.BancoImb.interfaces.ILogradouroEspecial;
import br.com.ufc.es.BancoImb.model.Jogador;

public class SorteReves extends LogradouroEspecial implements ILogradouroEspecial{
	public SorteReves(String nome) {
		super(nome);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void efeitoDaCasa(Jogador jogador) {
		if(sorteReves() == 1){
			jogador.receberTaxa(150);
			
			JOptionPane.showMessageDialog(null, "Sorte receba 150" + "\n" + "Seu novo saldo é: " + jogador.getSaldo());
			
		}else{
			jogador.pagarTaxa(150);
			JOptionPane.showMessageDialog(null, "Reves pague 150" + "\n" + "Seu novo saldo é: " + jogador.getSaldo());
		}
	}
	
	public int sorteReves(){
		return ((int) ( (Math.random() * 2) + 1 ));
	}
}
