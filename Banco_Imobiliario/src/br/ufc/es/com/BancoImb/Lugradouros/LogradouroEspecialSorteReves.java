package br.ufc.es.com.BancoImb.Lugradouros;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import jplay.Sound;
import br.ufc.es.com.BancoImb.model.CasaDoTabuleiro;
import br.ufc.es.com.BancoImb.model.Jogador;
import br.ufc.es.com.BancoImb.model.LogradouroEspecial;
import br.ufc.es.com.BancoImb.repositorios.RepositorioLists;
import br.ufc.es.com.BancoImb.utils.Constantes;

public class LogradouroEspecialSorteReves extends LogradouroEspecial{
	private RepositorioLists lists;
	private List<Float> cartas;
	private int indice;
	
	public LogradouroEspecialSorteReves(String nome, Point posicao, int indice, RepositorioLists lists) {
		super(nome, posicao, indice, lists);
		this.lists = lists;
		cartas = new ArrayList<Float>();
		criarDeckCartas();
	}

	public void ativarEfeito(Jogador jogador) {
		indice = sorteReves();
		CasaDoTabuleiro destino = lists.getCasaByIndice(indice);
		System.out.println(indice+" Nome da casa de destino "+destino.getNome());
		
		if(indice > 20){
			
		if((indice % 2)  == 0){
			
			new Sound(new Constantes().CAIXINHA).play();
			jogador.receberTaxa(cartas.get(indice));
			
			JOptionPane.showMessageDialog(null, "Sorte"+ "\n" + "Receba: "+	cartas.get(indice) 
					+ "\n" +"Seu novo saldo é: " + jogador.getSaldo(),
					"Sorte", JOptionPane.PLAIN_MESSAGE,
					new ImageIcon(new Constantes().FELIZ));
		}else{
			
			jogador.pagarTaxa(cartas.get(indice));
			
			JOptionPane.showMessageDialog(null, "Revés"+"\n" + "Pague: "+cartas.get(indice) 
					+"\n" + "Seu novo saldo é: " + jogador.getSaldo(),
					"Reves", JOptionPane.PLAIN_MESSAGE,
					new ImageIcon(new Constantes().TRISTE));
		}
	}else{
		mover(jogador, destino);
		JOptionPane.showMessageDialog(null, "Vá para a Casa " + destino.getNome().toUpperCase() + "\n" 
		+ "Que fica localizada na posicão " + destino.getIndice(),	"Vá Para...", JOptionPane.PLAIN_MESSAGE);
		
		}
			
	}
	public int sorteReves(){
		indice = ((int) ( (Math.random() * 39) + 1 ));
		return indice;
	}
	
	public void criarDeckCartas(){
		cartas.add((float) 90);
		cartas.add((float) 70);
		cartas.add((float) 130);
		cartas.add((float) 50);
		cartas.add((float) 200);
		cartas.add((float) 120);
		cartas.add((float) 160);
		cartas.add((float) 40);
		cartas.add((float) 10);
		cartas.add((float) 190);
		cartas.add((float) 40);
		cartas.add((float) 70);
		cartas.add((float) 90);
		cartas.add((float) 100);
		cartas.add((float) 110);
		cartas.add((float) 10);
		cartas.add((float) 40);
		cartas.add((float) 60);
		cartas.add((float) 80);
		cartas.add((float) 160);
		cartas.add((float) 90);
		cartas.add((float) 70);
		cartas.add((float) 130);
		cartas.add((float) 50);
		cartas.add((float) 200);
		cartas.add((float) 120);
		cartas.add((float) 160);
		cartas.add((float) 40);
		cartas.add((float) 10);
		cartas.add((float) 190);
		cartas.add((float) 40);
		cartas.add((float) 70);
		cartas.add((float) 90);
		cartas.add((float) 100);
		cartas.add((float) 110);
		cartas.add((float) 10);
		cartas.add((float) 40);
		cartas.add((float) 60);
		cartas.add((float) 80);
		cartas.add((float) 160);
	}
}
