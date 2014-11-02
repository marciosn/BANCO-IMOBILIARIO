package br.com.ufc.es.BancoImb.view;

import java.awt.Point;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import br.com.ufc.es.BancoImb.constantes.Constantes;
import br.com.ufc.es.BancoImb.model.CasaDoTabuleiro;
import br.com.ufc.es.BancoImb.model.Jogador;
import jplay.Animation;
import jplay.Keyboard;
import jplay.Mouse;
import jplay.Scene;
import jplay.Window;


public class BIInterfaceGrafica {
	private Window window;
	private Keyboard keyboard;
	private Scene scene;
	private Mouse mouse;
	private Animation botao;
	private Animation portfolioButton0, portfolioButton1, portfolioButton2, portfolioButton3, portfolioButton4;
	private JTextArea portfolio;
	private Constantes constante;
	
	public BIInterfaceGrafica() {
		constante = new Constantes();
		window = new Window(1080, 720);
		window.setCursor( window.createCustomCursor(constante.PATH_IMAGE + "mouse.png") );
		keyboard = window.getKeyboard();
		mouse = window.getMouse();
		portfolio = new JTextArea();
		scene = new Scene();
		scene.loadFromFile(constante.PATH_SCENE + "scene2.scn");
		scene.setDrawStartPos(0, 1);
	}

	public void iniciarPecas(List<CasaDoTabuleiro> tabuleiro) {
		for (Jogador j : tabuleiro.get(0)
				.getJogadoresNaCasa()) {
			scene.addOverlay(j.getPeca());
		}
	}
	public void draw() {
		scene.draw();
		desenhaDadoBotao();
		desenhaPortfolioBotao();
		window.update();
	}
	public void exibeLogradourosJogador(Jogador jogador){
		portfolio.setText("");
		for(CasaDoTabuleiro c : jogador.getMeusLogradouros()){
			portfolio.append("["+c.getNome()+ " "+ c.getValor() +"]" + "\n");
		}
		JOptionPane.showMessageDialog(null," Saldo Atual: "+
		jogador.getSaldo() +"\n" + "Total de propriedades "+ jogador.getMeusLogradouros().size() +
		"\n" + portfolio.getText(), "Portfolio: " +jogador.getNome(), JOptionPane.PLAIN_MESSAGE, new ImageIcon(constante.PATH_IMAGE + "portfolio.png"));
	}
	public void desenhaDadoBotao(){
		botao = new Animation(constante.PATH_IMAGE + "dado.png");
		botao.x = 800;
		botao.y = 110;
		botao.draw();
	}
	public void moverPecaJogador(CasaDoTabuleiro destino, Jogador jogador){
		Point posicao = destino.getPosicao();
		jogador.getPeca().x = posicao.x;
		jogador.getPeca().y = posicao.y;
		draw();
	}
	public void jogadorNaoPossuiSaldo(Jogador jogador, List<Jogador> jogadoresAindaJogando){
		jogador.getPeca().loadImage(constante.PATH_IMAGE + "dead.png");
		draw();
		JOptionPane.showMessageDialog(null, "O jogador "
				+ jogador.getNome() + "\n"
				+ "Não possui mais saldo e vai deixar o jogo"
				+ "\n" + "Exite agora "
				+ jogadoresAindaJogando.size(),
				"Jogador Sai do Jogo", JOptionPane.PLAIN_MESSAGE, new ImageIcon(constante.PATH_IMAGE + "sad.png"));
	}

	public String entradaDados(Jogador jogador){
		String dados = JOptionPane.showInputDialog(null,"Digite quantas casas o jogador " + jogador.getNome() + " vai andar!");
		return dados;
	}
	public String qtdJogadoresDesejada(){
		String qtd = JOptionPane.showInputDialog(null,"Digite a quantidade de jogadores do Jogo!");
		return qtd;
	}
	public void quantidadeInvalidaJogadores(){
		JOptionPane.showMessageDialog(null,	"Você digitou uma quantidade invalida de jogadores");
	}
	public void numeroDeEntradaDadosInvalido(){
		JOptionPane.showMessageDialog(null,"Você digitou o numero dos dados de maneira errada");
	}
	public void inputVazio(){
		JOptionPane.showMessageDialog(null,"O input não pode ser vazio");
	}
	public void ativaBotaoPortifolio(Mouse mouse, List<Jogador> jogadores){
		if(mouse.isOverObject(portfolioButton0) && mouse.isLeftButtonPressed()){
			exibeLogradourosJogador(jogadores.get(0));
		}
		if(mouse.isOverObject(portfolioButton1) && mouse.isLeftButtonPressed()){
			exibeLogradourosJogador(jogadores.get(1));
		}
		if(mouse.isOverObject(portfolioButton2) && mouse.isLeftButtonPressed()){
			if(jogadores.size() >= 3)
			exibeLogradourosJogador(jogadores.get(2));
		}
		if(mouse.isOverObject(portfolioButton3) && mouse.isLeftButtonPressed()){
			if(jogadores.size() >= 4)
			exibeLogradourosJogador(jogadores.get(3));
		}
		if(mouse.isOverObject(portfolioButton4) && mouse.isLeftButtonPressed()){
			if(jogadores.size() == 5)
			exibeLogradourosJogador(jogadores.get(4));
		}
		
	}
	public void desenhaPortfolioBotao(){
		portfolioButton0 = new Animation(constante.PATH_IMAGE + "portfolio.png");
		portfolioButton0.x = 240;
		portfolioButton0.y = 140;
		portfolioButton0.draw();
		
		portfolioButton1 = new Animation(constante.PATH_IMAGE + "portfolio.png");
		portfolioButton1.x = 340;
		portfolioButton1.y = 140;
		portfolioButton1.draw();
		
		portfolioButton2 = new Animation(constante.PATH_IMAGE + "portfolio.png");
		portfolioButton2.x = 440;
		portfolioButton2.y = 140;
		portfolioButton2.draw();
		
		portfolioButton3 = new Animation(constante.PATH_IMAGE + "portfolio.png");
		portfolioButton3.x = 540;
		portfolioButton3.y = 140;
		portfolioButton3.draw();
		
		portfolioButton4 = new Animation(constante.PATH_IMAGE + "portfolio.png");
		portfolioButton4.x = 640;
		portfolioButton4.y = 140;
		portfolioButton4.draw();
	}

	public Window getWindow() {
		return window;
	}

	public void setWindow(Window window) {
		this.window = window;
	}

	public Mouse getMouse() {
		return mouse;
	}

	public void setMouse(Mouse mouse) {
		this.mouse = mouse;
	}

	public Animation getBotao() {
		return botao;
	}

	public void setBotao(Animation botao) {
		this.botao = botao;
	}

	public JTextArea getPortfolio() {
		return portfolio;
	}

	public void setPortfolio(JTextArea portfolio) {
		this.portfolio = portfolio;
	}

	public Animation getPortfolioButton0() {
		return portfolioButton0;
	}

	public void setPortfolioButton0(Animation portfolioButton0) {
		this.portfolioButton0 = portfolioButton0;
	}

	public Animation getPortfolioButton1() {
		return portfolioButton1;
	}

	public void setPortfolioButton1(Animation portfolioButton1) {
		this.portfolioButton1 = portfolioButton1;
	}

	public Animation getPortfolioButton2() {
		return portfolioButton2;
	}

	public void setPortfolioButton2(Animation portfolioButton2) {
		this.portfolioButton2 = portfolioButton2;
	}

	public Animation getPortfolioButton3() {
		return portfolioButton3;
	}

	public void setPortfolioButton3(Animation portfolioButton3) {
		this.portfolioButton3 = portfolioButton3;
	}

	public Animation getPortfolioButton4() {
		return portfolioButton4;
	}

	public void setPortfolioButton4(Animation portfolioButton4) {
		this.portfolioButton4 = portfolioButton4;
	}
}
