package br.com.ufc.es.BancoImb.sound;


import br.com.ufc.es.BancoImb.constantes.Constantes;


public class Sound {
	public void winSound(){
		new jplay.Sound(new Constantes().PATH_AUDIO + "champions.wav").play();		
	}

	public void sorteSound(){
		new jplay.Sound(new Constantes().PATH_AUDIO + "caixinha.wav").play();;
	}

}
