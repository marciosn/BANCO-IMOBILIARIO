package br.ufc.es.com.BancoImb.control;

public class CalcularIndiceProximaCasa {
	public int obterIndiceProximaCasa(int indiceAtual, int resultDado) {
		int indiceProximaCasa;
		indiceProximaCasa = indiceAtual + resultDado;
		if(indiceProximaCasa > 39){
			int percent = indiceProximaCasa % 40;
			indiceProximaCasa = percent;
		}
		return indiceProximaCasa;
	}

}
