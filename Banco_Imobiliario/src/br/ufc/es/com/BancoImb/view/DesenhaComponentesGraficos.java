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
import br.ufc.es.com.BancoImb.model.CasaDoTabuleiro;
import br.ufc.es.com.BancoImb.model.Jogador;
import br.ufc.es.com.BancoImb.sound.Sound;
import br.ufc.es.com.BancoImb.utils.Constantes;


public class DesenhaComponentesGraficos {
	private Window window;
	private Scene scene;
	private Mouse mouse;
	private Animation botao;
	private Animation portfolioButton0, portfolioButton1;
	private JTextArea portfolio;
	private Constantes constante;
	
	public DesenhaComponentesGraficos() {
	}
	
	public void instanciaObjetos(){
		constante = new Constantes();
		window = new Window(1080, 720);
		window.setCursor( window.createCustomCursor(constante.MOUSE) );
		mouse = window.getMouse();
		portfolio = new JTextArea();
		scene = new Scene();
		scene.loadFromFile(constante.CENARIO);
		scene.setDrawStartPos(0, 1);
	}

	public void desenhaPecasNoTabuleiro(List<CasaDoTabuleiro> tabuleiro) {
		for (Jogador jogador : tabuleiro.get(constante.INDICE_DA_CASA_DE_PARTIDA).getJogadoresNaCasa()) {
			scene.addOverlay(jogador.getPeca());
		}
	}
	public void atualizaTabuleiro() {
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
		JOptionPane.showMessageDialog(null," Saldo Atual: "
				+ jogador.getSaldo() 
				+"\n" + "Total de propriedades "
				+ jogador.getMeusLogradouros().size() 
				+"\n" + portfolio.getText(),
				"Portfolio: " 
				+jogador.getNome(),
				JOptionPane.PLAIN_MESSAGE,
				new ImageIcon(constante.PORTFOLIO));
	}
	public void desenhaBotaoDados(){
		botao = new Animation(constante.DADOS);
		botao.x = 800;
		botao.y = 110;
		botao.draw();
	}
	public void moverPecaJogador(Jogador jogador, CasaDoTabuleiro destino){
		Point posicao = destino.getPosicao();
		jogador.getPeca().x = posicao.x;
		jogador.getPeca().y = posicao.y;
		atualizaTabuleiro();
	}
	public void messageJogadorNaoPossuiSaldo(Jogador jogador, List<Jogador> jogadoresAindaJogando){
		jogador.getPeca().loadImage(constante.FORA_DO_JOGO);
		atualizaTabuleiro();
		JOptionPane.showMessageDialog(null, "O jogador "
				+ jogador.getNome() + "\n"
				+ "N�o possui mais saldo e vai deixar o jogo"
				+ "\n" + "Exite agora "
				+ jogadoresAindaJogando.size(),
				"Jogador Sai do Jogo",
				JOptionPane.PLAIN_MESSAGE,
				new ImageIcon(constante.TRISTE));
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
		portfolioButton0 = new Animation(constante.PORTFOLIO);
		portfolioButton0.x = 240;
		portfolioButton0.y = 140;
		portfolioButton0.draw();
		
		portfolioButton1 = new Animation(constante.PORTFOLIO);
		portfolioButton1.x = 340;
		portfolioButton1.y = 140;
		portfolioButton1.draw();
	}
	public String inputDigiteONomeDoJogador(int id){
		String nome = JOptionPane.showInputDialog(null,"Digite o nome do jogador de ID = " + id);
		return nome;
	}
	public String inputEntradaDados(Jogador jogador){
		String dados = JOptionPane.showInputDialog(null,"Digite quantas casas o jogador " 
				+jogador.getNome()
				+ " vai andar!");
		return dados;
	}
	public int inputRepostaDoJogadorSobreCompraLogradouro(String nomeLogradouro){
		int respostaDoJogador = JOptionPane.showConfirmDialog(null, "Essa casa n�o possui propriet�rio," 
				+" quer compra-la?",
				nomeLogradouro,
				JOptionPane.YES_NO_OPTION);
		
		return respostaDoJogador;
	}
	public void messageExisteUmCampeao(List<Jogador> jogadoresAindaJogando){
		new Sound().winSound();
		JOptionPane.showMessageDialog(null, "O jogador "
				+ jogadoresAindaJogando.get(0).getNome() + "\n"
				+ "Venceu o jogo",
				"Vencedor",
				JOptionPane.PLAIN_MESSAGE,
				new ImageIcon(constante.TROFEU));
	}
	public void messageNumeroDeEntradaDadosInvalido(){
		JOptionPane.showMessageDialog(null,"Voc� digitou o numero dos dados de maneira errada");
	}
	public void messageNomeInvalido(){
		JOptionPane.showMessageDialog(null,"Nome n�o pode ser vazio e deve conter no minimo 3 letras");
	}
	public void messageInputVazio(){
		JOptionPane.showMessageDialog(null,"O input n�o pode ser vazio");
	}
	public void messageLucrosDividendos(Jogador jogador, float lucrosDividendos){
		JOptionPane.showMessageDialog(null, "Lucros ou Dividendos" 
				+ "\n" +"Receba " + lucrosDividendos
				+ "\n" +"Seu novo Saldo � " 
				+ jogador.getSaldo());
	}
	public void messageImpostoDeRenda(Jogador jogador, float imposto){
		JOptionPane.showMessageDialog(null, "Imposto de renda, voc� precisa pagar seus impostos" 
				+ "\n" + "Pague "+imposto
				+ "\n" +"Seu novo Saldo � " 
				+ jogador.getSaldo());
	}
	public void messageParadaLivre(Jogador jogador){
		JOptionPane.showMessageDialog(null, "Ol� "+jogador.getNome() 
				+"\n"+"Esta casa � uma Parada Livre" 
				+ "\n"+ "N�o precisa pagar impostos!");
	}
	public void messageCasaDePartida(Jogador jogador, float bonus){
		JOptionPane.showMessageDialog(null, "Voc� passou pela casa de partida, merece um pr�mio" 
				+ "\n" +"Receba "+bonus
				+ "\n" +"Seu novo Saldo � " 
				+ jogador.getSaldo());
	}

	public void messageJogadorComprouLogradouro(Jogador jogador, String nomeLogradouro){
		JOptionPane.showMessageDialog(null, "O jogador " 
				+ jogador.getNome() 
				+ " comprou a casa " 
				+"["+ nomeLogradouro +"]"+ "\n" 
				+"O novo saldo do jogador �: " 
				+ jogador.getSaldo());
	}
	public void messageJogadorPagouTaxa(Jogador jogador, Jogador proprietario){
		JOptionPane.showMessageDialog(null, "Esta casa � de propriedade do jogador " 
				+ proprietario.getNome() +"\n" 
				+ "Voc� precisa pagar uma taxa por passar aqui, seu novo saldo �: " 
				+ jogador.getSaldo() + "\n" 
				+ proprietario.getNome() 
				+ " agora possui saldo = " 
				+ proprietario.getSaldo());
	}
	public void messageSorte(Jogador jogador, float sorteValor){
		JOptionPane.showMessageDialog(null, "Sorte"+ "\n" + "Receba: "
				+ sorteValor + "\n" +"Seu novo saldo �: " 
				+ jogador.getSaldo(), "Sorte",
				JOptionPane.PLAIN_MESSAGE,
				new ImageIcon(constante.FELIZ));
	}
	public void messageReves(Jogador jogador, float revesValor){
		JOptionPane.showMessageDialog(null, "Reves"+ "\n" + "Pague: " 
				+revesValor	+"\n" + "Seu novo saldo �: " 
				+ jogador.getSaldo(), "Reves",
				JOptionPane.PLAIN_MESSAGE,
				new ImageIcon(constante.TRISTE));
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
}
