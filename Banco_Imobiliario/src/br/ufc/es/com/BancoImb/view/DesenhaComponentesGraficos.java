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
import br.ufc.es.com.BancoImb.model.LogradouroComercializavel;
import br.ufc.es.com.BancoImb.utils.Constantes;


public class DesenhaComponentesGraficos {
	private Window window;
	private Scene scene;
	private Mouse mouse;
	private Animation botao;
	private Animation portfolioButton0;
	private Animation portfolioButton1;
	private JTextArea portfolio;
	
	public DesenhaComponentesGraficos() {
	}
	
	public void instanciaObjetos(){
		window = new Window(1080, 720);
		window.setCursor( window.createCustomCursor(new Constantes().MOUSE) );
		mouse = window.getMouse();
		portfolio = new JTextArea();
		scene = new Scene();
		scene.loadFromFile(new Constantes().CENARIO);
		scene.setDrawStartPos(0, 1);
	}

	public void desenhaPecasNoTabuleiro(List<CasaDoTabuleiro> tabuleiro) {
		for (Jogador jogador : tabuleiro.get(new Constantes().INDICE_DA_CASA_DE_PARTIDA).getJogadoresNaCasa()) {
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
		for(LogradouroComercializavel c : jogador.getMeusLogradouros()){
			
			portfolio.append("["+c.getNome()+ " "+ c.getValor() +"]" + "\n");
			
		}
		
		JOptionPane.showMessageDialog(null," Saldo Atual: "
				+ jogador.getSaldo() 
				+"\n" + "Total de propriedades "
				+ jogador.getMeusLogradouros().size() 
				+"\n" + portfolio.getText(),
				"Portfolio: " 
				+jogador.getNome().toUpperCase(),
				JOptionPane.PLAIN_MESSAGE,
				new ImageIcon(new Constantes().PORTFOLIO));
	}
	
	public void desenhaBotaoDados(){
		botao = new Animation(new Constantes().DADOS);
		botao.x = 800;
		botao.y = 110;
		botao.draw();
	}
	
	public void moverPecaJogador(Jogador jogador, CasaDoTabuleiro destino){
		Point posicao = destino.getPosicao();
		System.out.println(posicao);
		jogador.getPeca().x = posicao.x;
		jogador.getPeca().y = posicao.y;
		atualizaTabuleiro();
	}
	
	public void ativaBotaoPortifolio(Mouse mouse, List<Jogador> jogadores){
		if(mouse.isOverObject(portfolioButton0) && mouse.isLeftButtonPressed())
			exibeLogradourosDoJogador(jogadores.get(0));
		else
			if(mouse.isOverObject(portfolioButton1) && mouse.isLeftButtonPressed())
			exibeLogradourosDoJogador(jogadores.get(1));
	}
	
	public void desenhaBotaoPortifolio(){
		portfolioButton0 = new Animation(new Constantes().PORTFOLIO);
		portfolioButton0.x = 240;
		portfolioButton0.y = 140;
		portfolioButton0.draw();
		
		portfolioButton1 = new Animation(new Constantes().PORTFOLIO);
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
				+jogador.getNome().toUpperCase()
				+ " vai andar!");
		return dados;
	}
	
	public int inputRepostaDoJogadorSobreCompraLogradouro(String nomeLogradouro){
		int respostaDoJogador = JOptionPane.showConfirmDialog(null, "Essa casa não possui proprietário," 
				+" quer compra-la?",
				nomeLogradouro,
				JOptionPane.YES_NO_OPTION);
		
		return respostaDoJogador;
	}
	
	public void messageJogadorNaoPossuiSaldo(Jogador jogador, List<Jogador> jogadoresAindaJogando){
		jogador.getPeca().loadImage(new Constantes().FORA_DO_JOGO);
		atualizaTabuleiro();
		JOptionPane.showMessageDialog(null, "O jogador "
				+ jogador.getNome().toUpperCase() + "\n"
				+ "Não possui mais saldo e vai deixar o jogo"
				+ "\n" + "Exite agora "
				+ jogadoresAindaJogando.size(),
				"Jogador Sai do Jogo",
				JOptionPane.PLAIN_MESSAGE,
				new ImageIcon(new Constantes().TRISTE));
	}
	
	public void messageExisteUmCampeao(List<Jogador> jogadoresAindaJogando){
		new jplay.Sound(new Constantes().CHAMPIONS).play();
		
		JOptionPane.showMessageDialog(null, "O jogador "
				+ jogadoresAindaJogando.get(0).getNome().toUpperCase() + "\n"
				+ "Venceu o jogo",
				"Vencedor",
				JOptionPane.PLAIN_MESSAGE,
				new ImageIcon(new Constantes().TROFEU));
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
	
	public void messageLucrosDividendos(Jogador jogador, float lucrosDividendos){
		JOptionPane.showMessageDialog(null, "Lucros ou Dividendos" 
				+ "\n" +"Receba " + lucrosDividendos
				+ "\n" +"Seu novo Saldo é " 
				+ jogador.getSaldo());
	}
	
	public void messageImpostoDeRenda(Jogador jogador, float imposto){
		JOptionPane.showMessageDialog(null, "Imposto de renda, você precisa pagar seus impostos" 
				+ "\n" + "Pague "+imposto
				+ "\n" +"Seu novo Saldo é " 
				+ jogador.getSaldo());
	}
	
	public void messageParadaLivre(Jogador jogador){
		JOptionPane.showMessageDialog(null, "Olá "+jogador.getNome().toUpperCase() 
				+"\n"+"Esta casa é uma Parada Livre" 
				+ "\n"+ "Não precisa pagar impostos!");
	}
	
	public void messageCasaDePartida(Jogador jogador, float bonus){
		JOptionPane.showMessageDialog(null, "Você passou pela casa de partida, merece um prêmio" 
				+ "\n" +"Receba "+bonus
				+ "\n" +"Seu novo Saldo é " 
				+ jogador.getSaldo());
	}

	public void messageJogadorComprouLogradouro(Jogador jogador, String nomeLogradouro){
		JOptionPane.showMessageDialog(null, "O jogador " 
				+ jogador.getNome().toUpperCase() 
				+ " comprou a casa " 
				+"["+ nomeLogradouro +"]"+ "\n" 
				+"O novo saldo do jogador é: " 
				+ jogador.getSaldo());
	}
	
	public void messageJogadorPagouTaxa(Jogador jogador, Jogador proprietario){
		JOptionPane.showMessageDialog(null, "Esta casa é de propriedade do jogador " 
				+ proprietario.getNome().toUpperCase() +"\n" 
				+ "Você precisa pagar uma taxa por passar aqui, seu novo saldo é: " 
				+ jogador.getSaldo() + "\n" 
				+ proprietario.getNome().toUpperCase() 
				+ " agora possui saldo = " 
				+ proprietario.getSaldo());
	}
	
	public void messageSorte(Jogador jogador, float sorteValor){
		JOptionPane.showMessageDialog(null, "Sorte"+ "\n" + "Receba: "
				+ sorteValor + "\n" +"Seu novo saldo é: " 
				+ jogador.getSaldo(), "Sorte",
				JOptionPane.PLAIN_MESSAGE,
				new ImageIcon(new Constantes().FELIZ));
	}
	
	public void messageReves(Jogador jogador, float revesValor){
		JOptionPane.showMessageDialog(null, "Reves"+ "\n" + "Pague: " 
				+revesValor	+"\n" + "Seu novo saldo é: " 
				+ jogador.getSaldo(), "Reves",
				JOptionPane.PLAIN_MESSAGE,
				new ImageIcon(new Constantes().TRISTE));
	}
	
	public void messageNaoPossuiSaldoParaComprar(){
		JOptionPane.showMessageDialog(null, "Não possui Saldo"+ "\n" 
				+ "Você não possui saldo suficiente para comprar este logradouro",
				"Não possui saldo",
				JOptionPane.PLAIN_MESSAGE);
	}
	
	public void messageACasaJaESua(){
		JOptionPane.showMessageDialog(null, "Esta Casa é sua"+ "\n"
				+ "Esta casa já é sua, pode ficar a vontade!",
				"Esta Casa é sua",
				JOptionPane.PLAIN_MESSAGE);
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
