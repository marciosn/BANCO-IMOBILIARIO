package br.com.ufc.es.BancoImb.view;

import jplay.Keyboard;
import jplay.Mouse;
import jplay.Scene;
import jplay.Window;
import br.com.ufc.es.BancoImb.model.Peca;

public class TabuleiroInterfaceGrafica {
	
	private Window window;  
    private Keyboard keyboard;  
    private Scene scene;  
    private Peca peca;
    private Mouse mouse;
	
	public TabuleiroInterfaceGrafica() {
		window = new Window(1080, 720);  
        keyboard = window.getKeyboard();
        mouse = window.getMouse();
        scene = new Scene();  
        scene.loadFromFile("scene2.scn");  
        scene.setDrawStartPos(0, 1);  

        peca = new Peca();
        peca.x = 32;  
        peca.y = 22;
        
        scene.addOverlay(peca);
	}
	
	public void desenhar(){
		scene.draw();  
        window.update();
	}

}
