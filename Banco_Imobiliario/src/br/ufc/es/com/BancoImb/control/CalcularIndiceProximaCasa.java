package br.ufc.es.com.BancoImb.control;

import br.ufc.es.com.BancoImb.constantes.Constantes;

public class CalcularIndiceProximaCasa {
	private Constantes constante;
	
	public CalcularIndiceProximaCasa() {
		constante = new Constantes();
	}
	
	public int obterIndiceProximaCasa(int indiceAtual, int resultDado) {
		int indiceProximaCasa;
		indiceProximaCasa = indiceAtual + resultDado;
		if(indiceProximaCasa > (constante.QUANTIDADE_DE_CASAS_DO_TABULEIRO - 1)){
			int percent = indiceProximaCasa % constante.QUANTIDADE_DE_CASAS_DO_TABULEIRO;
			indiceProximaCasa = percent;
		}
		return indiceProximaCasa;
	}

}
