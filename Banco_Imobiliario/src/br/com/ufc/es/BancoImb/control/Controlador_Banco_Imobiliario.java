package br.com.ufc.es.BancoImb.control;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

import jplay.Keyboard;
import jplay.Mouse;
import jplay.Scene;
import jplay.Window;
import br.com.ufc.es.BancoImb.model.CasaDoTabuleiro;
import br.com.ufc.es.BancoImb.model.ContaBancaria;
import br.com.ufc.es.BancoImb.model.Jogador;
import br.com.ufc.es.BancoImb.model.Peca;
import br.com.ufc.es.BancoImb.model.PecaJogador;
import br.com.ufc.es.BancoImb.model.Tabuleiro;

/**
 * https://github.com/marciosn/Banco-Imobiliario.git
 * 
 * **/
public class Controlador_Banco_Imobiliario{

	Tabuleiro tabuleiroJogo;
	List<Jogador> jodagores;
	Jogador jogadorNaVEZ;
	Jogador jogador;
	Scanner entrada = new Scanner(System.in);
	boolean executando = true;
	CasaDoTabuleiro destino;
	ExecutaComportamentoDaCasa executar;
	
	private Window window;  
    private Keyboard keyboard;  
    private Scene scene;  
    private Peca peca;
    private Mouse mouse;

	public Controlador_Banco_Imobiliario() {
		
		window = new Window(1080, 720);  
        keyboard = window.getKeyboard();
        mouse = window.getMouse();
        scene = new Scene();  
        scene.loadFromFile("scene2.scn");  
        scene.setDrawStartPos(0, 1);  

        /*peca = new Peca();
        peca.x = 32;  
        peca.y = 22;
        
        scene.addOverlay(peca);*/
		
		tabuleiroJogo = new Tabuleiro();
		jodagores = new ArrayList<Jogador>();
		criarJogadores();
		executar = new ExecutaComportamentoDaCasa();
		iniciarJogo();
		
	}
	public void InserindoJogadores(Jogador jogador) {
		jodagores.add(jogador);
	}
	public void adicionarJogadoresNaCasaDePartida(List<Jogador> jogadores) {
		for (Jogador j : jogadores) {
			tabuleiroJogo.adiconarJogadoresACasa(0, j);
			System.out.println("Classe: Banco Imobiliario"
					+ " ----> Inserindo o jogador " + j.getNome() + " ID = " + j.getID());			
		}
		jogadorNaVEZ = jogadores.get(0);
	}
	public void moverJogador(Jogador jogador, CasaDoTabuleiro casa){
		tabuleiroJogo.moverJogador(jogador, casa);
	}
	
	public void inserirJogadorNaCasa(int posicao, Jogador jogador) {
		tabuleiroJogo.adiconarJogadoresACasa(posicao, jogador);
	}
	public void criarJogadores(){   
		InserindoJogadores(new Jogador("marcio", new ContaBancaria(1000), new PecaJogador("peca1.png")));
		InserindoJogadores(new Jogador("marcio", new ContaBancaria(1000), new PecaJogador("peca2.png")));
		InserindoJogadores(new Jogador("nobre", new ContaBancaria(1000), new PecaJogador("peca3.png")));
		InserindoJogadores(new Jogador("edu", new ContaBancaria(1000), new PecaJogador("peca4.png")));
		InserindoJogadores(new Jogador("dudu", new ContaBancaria(1000), new PecaJogador("peca5.png")));
		adicionarJogadoresNaCasaDePartida(jodagores);
		iniciarPecas();
	}
	public Jogador getJogadorNaVEZ() {
		return jogadorNaVEZ;
	}
	public void setJogadorNaVEZ(Jogador jogadorDaVEZ) {
		this.jogadorNaVEZ = jogadorDaVEZ;
	}
	public void mudarVezDeJogar(int indiceJogador){
		int indiceProx = 0, temp = 0;
		indiceProx = indiceJogador + 1;
		if(indiceProx > jodagores.size()- 1){
			temp = indiceProx % jodagores.size();
			indiceProx = temp;
		}
			setJogadorNaVEZ(tabuleiroJogo.getJogadorByID(indiceProx));
	}
	
	public void iniciarPecas(){
		for(Jogador j : tabuleiroJogo.getTabuleiro().get(0).getJogadoresNaCasa()){
			 scene.addOverlay(j.getPeca());
		}
	}

	public void iniciarJogo(){
		while (executando) {
			draw(); 
			
				System.out.println("\t A vez de jogar � do jogador " + jogadorNaVEZ.getNome() +" que possui ID: "+ jogadorNaVEZ.getID());
				System.out.println("\n");

				jogador =  jogadorNaVEZ;

				System.out.println("Digite o resultado do lan�amento dos dados");
				
				String resultado = JOptionPane.showInputDialog(null, "Digite o resultado dos dados");
				
				int resultadoDados = Integer.valueOf(resultado);
				
				if (resultadoDados <= 12) {
					
					int indiceCasaDestino = tabuleiroJogo.calculaIndiceProximaCasa(jogador.getPosicaoJogador(),resultadoDados);
					destino = tabuleiroJogo.getCasaByIndice(indiceCasaDestino);
					
					Point posicao = destino.getPosicao();
			        //peca.x = posicao.x;  
			        //peca.y = posicao.y;
			        
			        jogador.getPeca().x = posicao.x;
			        jogador.getPeca().y = posicao.y;
					
					System.out.println("\t Nome da casa destino: "+ destino.getNome() + " A posicao �: " + destino.getPosicao());
					System.out.println("\t O indice da casa destino �: "+ tabuleiroJogo.getIndiceByCasa(destino));
					System.out.println("\t Possui: "+ destino.getNumJogadoresCasa()	+ " jogadores na casa");
					moverJogador(jogador,destino);
				}
				
			
				executar.executarComportamento(jogador,destino);
				
				System.out.println("<<<<<<<<<<==============================================================================>>>>>>>>>>");
					mudarVezDeJogar(jogador.getID());
				System.out.println("<<<<<<<<<<==============================================================================>>>>>>>>>>");
				
		}
		window.exit(); 
		
	}
	
	public void draw(){  
        scene.draw();  
        window.update();  
	}
	public List<Jogador> getJodagores() {
		return jodagores;
	}
	public Tabuleiro getTabuleiroJogo() {
		return tabuleiroJogo;
	}
}










