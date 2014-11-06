package br.ufc.es.com.BancoImb.sound;


import br.ufc.es.com.BancoImb.utils.Constantes;

public class Sound {
	private Constantes constante;
	public Sound() {
		constante = new Constantes();
	}
	public void winSound(){
		new jplay.Sound(constante.CHAMPIONS).play();		
	}

	public void sorteSound(){
		new jplay.Sound(constante.CAIXINHA).play();;
	}

}
