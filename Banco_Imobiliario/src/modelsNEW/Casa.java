package modelsNEW;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import br.ufc.es.com.BancoImb.model.Jogador;

public class Casa{
	String nome;
	List<Jogador> jogadoresNaCasa;
	Point posicao;
	
	public Casa() {
		jogadoresNaCasa = new ArrayList<Jogador>();
	}
}
