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
import br.ufc.es.com.BancoImb.interfaces.IDesenhaComponentes;
import br.ufc.es.com.BancoImb.model.CasaDoTabuleiro;
import br.ufc.es.com.BancoImb.model.Jogador;
import br.ufc.es.com.BancoImb.model.LogradouroComercializavel;
import br.ufc.es.com.BancoImb.utils.Constantes;


public class DesenhaComponentesGraficos implements IDesenhaComponentes{
	private Window window;
	private Scene scene;
	private Mouse mouse;
	private Animation botao;
	private Animation portfolioButton0;
	private Animation portfolioButton1;
	private JTextArea portfolio;
	
	public DesenhaComponentesGraficos() {
	}
	@Override
	public void instanciaObjetos(){
		window = new Window(1080, 720);
		window.setCursor( window.createCustomCursor(new Constantes().MOUSE) );
		mouse = window.getMouse();
		portfolio = new JTextArea();
		scene = new Scene();
		scene.loadFromFile(new Constantes().CENARIO);
		scene.setDrawStartPos(0, 1);
	}
	@Override
	public void desenhaPecasNoTabuleiro(List<CasaDoTabuleiro> tabuleiro) {
		for (Jogador jogador : tabuleiro.get(new Constantes().INDICE_DA_CASA_DE_PARTIDA).getJogadoresNaCasa()) {
			scene.addOverlay(jogador.getPeca());
		}
	}
	@Override
	public void atualizaTabuleiro() {
		scene.draw();
		desenhaBotaoDados();
		desenhaBotaoPortifolio();
		window.update();
	}
	@Override
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
	@Override
	public void desenhaBotaoDados(){
		botao = new Animation(new Constantes().DADOS);
		botao.x = 800;
		botao.y = 110;
		botao.draw();
	}
	@Override
	public void moverPecaJogador(Jogador jogador){
		Point posicao = jogador.getPosicaoJogador().getPosicao();
		jogador.getPeca().x = posicao.x;
		jogador.getPeca().y = posicao.y;
		atualizaTabuleiro();
	}
	@Override
	public void ativaBotaoPortifolio(Mouse mouse, List<Jogador> jogadores){
		if(mouse.isOverObject(portfolioButton0) && mouse.isLeftButtonPressed())
			exibeLogradourosDoJogador(jogadores.get(0));
		else
			if(mouse.isOverObject(portfolioButton1) && mouse.isLeftButtonPressed())
			exibeLogradourosDoJogador(jogadores.get(1));
	}
	@Override
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
	@Override
	public String inputDigiteONomeDoJogador(int id){
		int idJog = id + 1;
		String nome = JOptionPane.showInputDialog(null,"Digite o nome do jogador " + idJog);
		return nome;
	}
	@Override
	public String inputEntradaDados(Jogador jogador){
		String dados = JOptionPane.showInputDialog(null,"Digite quantas casas o jogador " 
				+jogador.getNome().toUpperCase()
				+ " vai andar!");
		return dados;
	}
	@Override
	public int inputRepostaDoJogadorSobreCompraLogradouro(String nomeLogradouro){
		int respostaDoJogador = JOptionPane.showConfirmDialog(null,"Voc� para na casa " 
				+ nomeLogradouro.toUpperCase()+"\n"+ "Essa casa n�o possui propriet�rio," 
				+" quer compra-la?",
				nomeLogradouro,
				JOptionPane.YES_NO_OPTION);
		
		return respostaDoJogador;
	}
	@Override
	public void messageJogadorNaoPossuiSaldo(Jogador jogador, List<Jogador> jogadoresAindaJogando){
		jogador.getPeca().loadImage(new Constantes().FORA_DO_JOGO);
		atualizaTabuleiro();
		JOptionPane.showMessageDialog(null, "O jogador "
				+ jogador.getNome().toUpperCase() + "\n"
				+ "N�o possui mais saldo e vai deixar o jogo"
				+ "\n" + "Exite agora "
				+ jogadoresAindaJogando.size(),
				"Jogador Sai do Jogo",
				JOptionPane.PLAIN_MESSAGE,
				new ImageIcon(new Constantes().TRISTE));
	}
	@Override
	public void messageExisteUmCampeao(List<Jogador> jogadoresAindaJogando){
		new jplay.Sound(new Constantes().CHAMPIONS).play();
		
		JOptionPane.showMessageDialog(null, "O jogador "
				+ jogadoresAindaJogando.get(0).getNome().toUpperCase() + "\n"
				+ "Venceu o jogo",
				"Vencedor",
				JOptionPane.PLAIN_MESSAGE,
				new ImageIcon(new Constantes().TROFEU));
	}
	@Override
	public void messageNumeroDeEntradaDadosInvalido(){
		JOptionPane.showMessageDialog(null,"Voc� digitou o numero dos dados de maneira errada");
	}
	@Override
	public void messageNomeInvalido(){
		JOptionPane.showMessageDialog(null,"Nome n�o pode ser vazio e deve conter no minimo 3 letras");
	}
	@Override
	public void messageInputVazio(){
		JOptionPane.showMessageDialog(null,"O input n�o pode ser vazio");
	}
	@Override
	public void messageJogadorEstaPreso(Jogador jogador){
		JOptionPane.showMessageDialog(null,"O "+jogador.getNome().toUpperCase() +" est� preso e vai passar a vez de jogar");
	}
	@Override
	public void messageJogadorDaVez(Jogador jogador){
		JOptionPane.showMessageDialog(null,"� Vez do jogador "+jogador.getNome().toUpperCase());
	}
	@Override
	public void messageLucrosDividendos(Jogador jogador, float lucrosDividendos){
		JOptionPane.showMessageDialog(null, "Lucros ou Dividendos" 
				+ "\n" +"Receba " + lucrosDividendos
				+ "\n" +"Seu novo Saldo � " 
				+ jogador.getSaldo());
	}
	@Override
	public void messageImpostoDeRenda(Jogador jogador, float imposto){
		JOptionPane.showMessageDialog(null, "Imposto de renda, voc� precisa pagar seus impostos" 
				+ "\n" + "Pague "+imposto
				+ "\n" +"Seu novo Saldo � " 
				+ jogador.getSaldo());
	}
	@Override
	public void messageParadaLivre(Jogador jogador){
		JOptionPane.showMessageDialog(null, "Ol� "+jogador.getNome().toUpperCase() 
				+"\n"+"Esta casa � uma Parada Livre" 
				+ "\n"+ "N�o precisa pagar impostos!");
	}
	@Override
	public void messageCasaDePartida(Jogador jogador, float bonus){
		JOptionPane.showMessageDialog(null, "Voc� passou pela casa de partida, merece um pr�mio" 
				+ "\n" +"Receba "+bonus
				+ "\n" +"Seu novo Saldo � " 
				+ jogador.getSaldo());
	}
	@Override
	public void messageJogadorComprouLogradouro(Jogador jogador, String nomeLogradouro){
		JOptionPane.showMessageDialog(null, "O jogador " 
				+ jogador.getNome().toUpperCase() 
				+ " comprou a casa " 
				+"["+ nomeLogradouro +"]"+ "\n" 
				+"O novo saldo do jogador �: " 
				+ jogador.getSaldo());
	}
	@Override
	public void messageJogadorPagouTaxa(Jogador jogador, Jogador proprietario){
		JOptionPane.showMessageDialog(null, "Esta casa � de propriedade do jogador " 
				+ proprietario.getNome().toUpperCase() +"\n" 
				+ "Voc� precisa pagar uma taxa por passar aqui, seu novo saldo �: " 
				+ jogador.getSaldo() + "\n" 
				+ proprietario.getNome().toUpperCase() 
				+ " agora possui saldo = " 
				+ proprietario.getSaldo());
	}
	@Override
	public void messageSorte(Jogador jogador, float sorteValor){
		JOptionPane.showMessageDialog(null, "Sorte"+ "\n" + "Receba: "
				+ sorteValor + "\n" +"Seu novo saldo �: " 
				+ jogador.getSaldo(), "Sorte",
				JOptionPane.PLAIN_MESSAGE,
				new ImageIcon(new Constantes().FELIZ));
	}
	
	public void messageReves(Jogador jogador, float revesValor){
		JOptionPane.showMessageDialog(null, "Reves"+ "\n" + "Pague: " 
				+revesValor	+"\n" + "Seu novo saldo �: " 
				+ jogador.getSaldo(), "Reves",
				JOptionPane.PLAIN_MESSAGE,
				new ImageIcon(new Constantes().TRISTE));
	}
	@Override
	public void messageNaoPossuiSaldoParaComprar(){
		JOptionPane.showMessageDialog(null, "N�o possui Saldo"+ "\n" 
				+ "Voc� n�o possui saldo suficiente para comprar este logradouro",
				"N�o possui saldo",
				JOptionPane.PLAIN_MESSAGE);
	}
	@Override
	public void messageACasaJaESua(){
		JOptionPane.showMessageDialog(null, "Esta Casa � sua"+ "\n"
				+ "Esta casa j� � sua, pode ficar a vontade!",
				"Esta Casa � sua",
				JOptionPane.PLAIN_MESSAGE);
	}
	@Override
	public void messageCasaVaParaPrisa(Jogador jogador){
		JOptionPane.showMessageDialog(null, "Voc� parou na casa v� para a pris�o" 
				+"\n"+"V� para a prisao" 
				+ "\n"+ "Pague uma multa de R$ 100" 
				+ "\n"	+ "Seu novo Saldo � R$ " 
				+ jogador.getSaldo());
	}
	@Override
	public void messageVoceParouNaPrisao(Jogador jogador){
		JOptionPane.showMessageDialog(null, "Voc� parou na casa v� para a pris�o" 
				+ "\n"+"V� para a prisao" 
				+ "\n"+ "Pague uma multa de R$ 100"
				+ "\n"+"Passe a vez de jogar"
				+ "\n"+ "Seu novo Saldo � R$ " 
				+ jogador.getSaldo());
	}
	@Override
	public void messageVaPara(CasaDoTabuleiro destino){
		JOptionPane.showMessageDialog(null, "V� para a Casa " + destino.getNome().toUpperCase() 
				+ "\n"+ "Que fica localizada na posic�o " 
				+ destino.getIndice(),
				"V� Para...",
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
