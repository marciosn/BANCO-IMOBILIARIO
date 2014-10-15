package br.com.ufc.es.BancoImb.view;

import jplay.Keyboard;
import jplay.Mouse;
import jplay.Scene;
import jplay.Window;

public class TabuleiroInterfaceGrafica {
	
	private Window window;  
    private Keyboard keyboard;  
    private Scene scene;  
    private Mouse mouse;
	
	public TabuleiroInterfaceGrafica() {
		window = new Window(1080, 720);  
        keyboard = window.getKeyboard();
        mouse = window.getMouse();
        scene = new Scene();  
        scene.loadFromFile("scene2.scn");  
        scene.setDrawStartPos(0, 1);  
	}
	
	public void desenhar(){
		scene.draw();  
        window.update();
	}

}
