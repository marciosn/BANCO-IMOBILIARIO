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
	List<Jogador> jogadores;
	List<Jogador> jogadoresAindaJogando;
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
		
		tabuleiroJogo = new Tabuleiro();
		jogadores = new ArrayList<Jogador>();
		jogadoresAindaJogando = new ArrayList<Jogador>();
		//criarJogadores();
		draw();
		inserirJogador();
		executar = new ExecutaComportamentoDaCasa();
		iniciarJogo();
		
	}
	public void InserindoJogadores(Jogador jogador) {
		jogadores.add(jogador);
	}
	public void adicionarJogadoresNaCasaDePartida(List<Jogador> jogadores) {
		for (Jogador j : jogadores) {
			jogadoresAindaJogando.add(j);
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
		InserindoJogadores(new Jogador("Brocador", new ContaBancaria(1000), new PecaJogador("peca0.png")));
		InserindoJogadores(new Jogador("Pet", new ContaBancaria(1000), new PecaJogador("peca1.png")));
		/*InserindoJogadores(new Jogador("nobre", new ContaBancaria(1000), new PecaJogador("peca3.png")));
		InserindoJogadores(new Jogador("edu", new ContaBancaria(1000), new PecaJogador("peca4.png")));
		InserindoJogadores(new Jogador("dudu", new ContaBancaria(1000), new PecaJogador("peca5.png")));*/
		adicionarJogadoresNaCasaDePartida(jogadores);
		iniciarPecas();
	}
	public void inserirJogador(){
		
		String qtd = JOptionPane.showInputDialog(null, "Digite a quantidade de jogadores do Jogo!");
		int qtd_jogadores = Integer.valueOf(qtd);
		
		if(qtd_jogadores > 0 && qtd_jogadores < 6){
		for(int i = 0 ; i < qtd_jogadores;){
			String nomeJogador = JOptionPane.showInputDialog(null, "Digite o nome do jogador de ID = " + i);
			String peca = "peca" + jogadores.size() + ".png";
			System.out.println(peca);
			InserindoJogadores(new Jogador(nomeJogador, new ContaBancaria(1000), new PecaJogador(peca)));
			i++;
		}
		adicionarJogadoresNaCasaDePartida(jogadores);
		iniciarPecas();
		}
		
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
		if(indiceProx > jogadores.size()- 1){
			temp = indiceProx % jogadores.size();
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
			if(jogadoresAindaJogando.size() == 1){
				JOptionPane.showMessageDialog(null, "O jogador "+jogadoresAindaJogando.get(0).getNome() + "\n" + "Venceu o jogo", "Vencedor", JOptionPane.OK_OPTION);
				executando = false;
				window.exit(); 
			}
			draw(); 
			
				System.out.println("\t A vez de jogar é do jogador " + jogadorNaVEZ.getNome() +" que possui ID: "+ jogadorNaVEZ.getID());
				System.out.println("\n");

				jogador =  jogadorNaVEZ;

				System.out.println("Digite o resultado do lançamento dos dados");
				
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
					
					System.out.println("\t Nome da casa destino: "+ destino.getNome() + " A posicao é: " + destino.getPosicao());
					System.out.println("\t O indice da casa destino é: "+ tabuleiroJogo.getIndiceByCasa(destino));
					System.out.println("\t Possui: "+ destino.getNumJogadoresCasa()	+ " jogadores na casa");
					moverJogador(jogador,destino);
				}
				
			
				executar.executarComportamento(jogador,destino);
				
				if(!possuiSaldoParaContinuar(jogador)){
					jogadoresAindaJogando.remove(jogador);
				JOptionPane.showMessageDialog(null, "O jogador "+jogador.getNome() + "\n" +
					"Não possui mais saldo e vai deixar o jogo" + "\n" +
					"Exitem agora " + jogadoresAindaJogando.size(), "Jogador Sai do Jogo", JOptionPane.OK_OPTION);
				}
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
	
	public boolean possuiSaldoParaContinuar(Jogador jogador){
		boolean possuiSaldo = false;
		if(jogador.getSaldo() < 0){
			return possuiSaldo;
		}
		else{
		possuiSaldo = true;
		}
		return possuiSaldo;
	}
	public List<Jogador> getJodagores() {
		return jogadores;
	}
	public Tabuleiro getTabuleiroJogo() {
		return tabuleiroJogo;
	}
}










