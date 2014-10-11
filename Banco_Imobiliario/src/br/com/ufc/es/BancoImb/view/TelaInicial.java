package br.com.ufc.es.BancoImb.view;

import jplay.Animation;
import jplay.Keyboard;
import jplay.Mouse;
import jplay.Scene;
import jplay.Window;
import br.com.ufc.es.BancoImb.model.Peca;

public class TelaInicial{
	
	private Window window;  
    private Keyboard keyboard;  
    private Scene scene;  
    private Peca peca;
    private Mouse mouse;
	
	public TelaInicial() {
		window = new Window(800, 600);  
        keyboard = window.getKeyboard();
        mouse = window.getMouse();
        scene = new Scene();  
        scene.loadFromFile("scene3.scn");  
        scene.setDrawStartPos(0, 1);  
        desenhar();
	}
	
	public void desenhar(){
		
		Animation botao = new Animation("start.png",12);
		botao.x = 350;  
        botao.y = 330; 
		botao.draw();
		scene.draw();  
        window.update();
	}

}
