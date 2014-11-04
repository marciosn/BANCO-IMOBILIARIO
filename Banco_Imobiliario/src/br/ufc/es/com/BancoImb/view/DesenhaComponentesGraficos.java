package br.ufc.es.com.BancoImb.view;

import java.awt.Point;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import jplay.Animation;
import jplay.Mouse;
import jplay.Scene;
import jplay.Window;
import br.ufc.es.com.BancoImb.constantes.Constantes;
import br.ufc.es.com.BancoImb.model.CasaDoTabuleiro;
import br.ufc.es.com.BancoImb.model.Jogador;
import br.ufc.es.com.BancoImb.sound.Sound;


public class DesenhaComponentesGraficos {
	private Window window;
	private Scene scene;
	private Mouse mouse;
	private Animation botao;
	private Animation portfolioButton0, portfolioButton1, portfolioButton2, portfolioButton3, portfolioButton4;
	private JTextArea portfolio;
	private Constantes constante;
	
	public DesenhaComponentesGraficos() {
		constante = new Constantes();
		window = new Window(1080, 720);
		window.setCursor( window.createCustomCursor(constante.PATH_IMAGE + "mouse.png") );
		mouse = window.getMouse();
		portfolio = new JTextArea();
		scene = new Scene();
		scene.loadFromFile(constante.PATH_SCENE + "scene2.scn");
		scene.setDrawStartPos(0, 1);
	}

	public void desenhaPecasNoTabuleiro(List<CasaDoTabuleiro> tabuleiro) {
		for (Jogador j : tabuleiro.get(0).getJogadoresNaCasa()) {
			scene.addOverlay(j.getPeca());
		}
	}
	public void draw() {
		scene.draw();
		desenhaBotaoDados();
		desenhaBotaoPortifolio();
		window.update();
	}
	public void exibeLogradourosDoJogador(Jogador jogador){
		portfolio.setText("");
		for(CasaDoTabuleiro c : jogador.getMeusLogradouros()){
			portfolio.append("["+c.getNome()+ " "+ c.getValor() +"]" + "\n");
		}
		JOptionPane.showMessageDialog(null," Saldo Atual: "+
		jogador.getSaldo() +"\n" + "Total de propriedades "+ jogador.getMeusLogradouros().size() +
		"\n" + portfolio.getText(), "Portfolio: " +jogador.getNome(), JOptionPane.PLAIN_MESSAGE, new ImageIcon(constante.PATH_IMAGE + "portfolio.png"));
	}
	public void desenhaBotaoDados(){
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
	public void messageJogadorNaoPossuiSaldo(Jogador jogador, List<Jogador> jogadoresAindaJogando){
		jogador.getPeca().loadImage(constante.PATH_IMAGE + "dead.png");
		draw();
		JOptionPane.showMessageDialog(null, "O jogador "
				+ jogador.getNome() + "\n"
				+ "Não possui mais saldo e vai deixar o jogo"
				+ "\n" + "Exite agora "
				+ jogadoresAindaJogando.size(),
				"Jogador Sai do Jogo", JOptionPane.PLAIN_MESSAGE, new ImageIcon(constante.PATH_IMAGE + "sad.png"));
	}
	public void messageExisteUmCampeao(List<Jogador> jogadoresAindaJogando){
		new Sound().winSound();
		JOptionPane.showMessageDialog(null, "O jogador "
				+ jogadoresAindaJogando.get(0).getNome() + "\n"
				+ "Venceu o jogo", "Vencedor", JOptionPane.PLAIN_MESSAGE, new ImageIcon(new Constantes().PATH_IMAGE + "win.png"));
	}
	public String messageDigiteONomeDoJogador(int id){
		String nome = JOptionPane.showInputDialog(null,"Digite o nome do jogador de ID = " + id);
		return nome;
	}
	public String entradaDados(Jogador jogador){
		String dados = JOptionPane.showInputDialog(null,"Digite quantas casas o jogador " + jogador.getNome() + " vai andar!");
		return dados;
	}
	public String qtdJogadoresDesejada(){
		String qtd = JOptionPane.showInputDialog(null,"Digite a quantidade de jogadores do Jogo!");
		return qtd;
	}
	public void messageNumeroDeEntradaDadosInvalido(){
		JOptionPane.showMessageDialog(null,"Você digitou o numero dos dados de maneira errada");
	}
	public void messageNomeInvalido(){
		JOptionPane.showMessageDialog(null,"Nome não pode ser vazio e deve conter no minimo 3 letras");
	}
	public void messageInputVazio(){
		JOptionPane.showMessageDialog(null,"O input não pode ser vazio");
	}
	public void ativaBotaoPortifolio(Mouse mouse, List<Jogador> jogadores){
		if(mouse.isOverObject(portfolioButton0) && mouse.isLeftButtonPressed()){
			exibeLogradourosDoJogador(jogadores.get(0));
		}
		if(mouse.isOverObject(portfolioButton1) && mouse.isLeftButtonPressed()){
			exibeLogradourosDoJogador(jogadores.get(1));
		}		
	}
	public void desenhaBotaoPortifolio(){
		portfolioButton0 = new Animation(constante.PATH_IMAGE + "portfolio.png");
		portfolioButton0.x = 240;
		portfolioButton0.y = 140;
		portfolioButton0.draw();
		
		portfolioButton1 = new Animation(constante.PATH_IMAGE + "portfolio.png");
		portfolioButton1.x = 340;
		portfolioButton1.y = 140;
		portfolioButton1.draw();
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
