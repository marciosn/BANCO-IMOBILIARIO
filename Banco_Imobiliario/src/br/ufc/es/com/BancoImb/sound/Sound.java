package br.ufc.es.com.BancoImb.sound;


import br.ufc.es.com.BancoImb.constantes.Constantes;


public class Sound {
	public void winSound(){
		new jplay.Sound(new Constantes().PATH_AUDIO + "champions.wav").play();		
	}

	public void sorteSound(){
		new jplay.Sound(new Constantes().PATH_AUDIO + "caixinha.wav").play();;
	}

}
