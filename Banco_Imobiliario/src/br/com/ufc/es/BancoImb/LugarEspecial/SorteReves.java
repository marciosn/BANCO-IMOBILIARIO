package br.com.ufc.es.BancoImb.LugarEspecial;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.ufc.es.BancoImb.interfaces.ILogradouroEspecial;
import br.com.ufc.es.BancoImb.model.Casa;
import br.com.ufc.es.BancoImb.model.Jogador;

public class SorteReves extends LogradouroEspecial implements ILogradouroEspecial{
	
	private List<Float> cartas;
	private int indice;
	public SorteReves(String nome) {
		super(nome);
		cartas  = new ArrayList<Float>();
		criarDeckCartas();
	}

	@Override
	public void efeitoDaCasa(Jogador jogador) {
		sorteReves();		
		if((indice % 2)  == 0){
			jogador.receberTaxa(cartas.get(indice));
			JOptionPane.showMessageDialog(null, "Sorte"+ "\n" + "Receba: "+
			cartas.get(indice) + "\n" +
			"Seu novo saldo é: " + jogador.getSaldo());
		}else{
			jogador.pagarTaxa(cartas.get(indice));
			JOptionPane.showMessageDialog(null, "Revés"+"\n" + "Pague: "+
			cartas.get(indice) +
			"\n" + "Seu novo saldo é: " + jogador.getSaldo());
		}		
	}
	
	public int sorteReves(){
		indice = ((int) ( (Math.random() * 19) + 1 ));
		return indice;
	}
	
	public void Sr(int indice){
		
	}
	
	public void criarDeckCartas(){
		cartas.add((float) 200);
		cartas.add((float) 100);
		cartas.add((float) 150);
		cartas.add((float) 250);
		cartas.add((float) 220);
		cartas.add((float) 180);
		cartas.add((float) 190);
		cartas.add((float) 240);
		cartas.add((float) 120);
		cartas.add((float) 160);
		cartas.add((float) 180);
		cartas.add((float) 140);
		cartas.add((float) 150);
		cartas.add((float) 200);
		cartas.add((float) 160);
		cartas.add((float) 210);
		cartas.add((float) 200);
		cartas.add((float) 160);
		cartas.add((float) 180);
		cartas.add((float) 260);
	}
	
}
















