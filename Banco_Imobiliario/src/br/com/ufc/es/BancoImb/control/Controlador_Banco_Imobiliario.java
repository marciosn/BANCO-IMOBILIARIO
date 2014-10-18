package br.com.ufc.es.BancoImb.control;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import jplay.Animation;
import jplay.GameImage;
import jplay.Keyboard;
import jplay.Mouse;
import jplay.Scene;
import jplay.Sound;
import jplay.Window;
import br.com.ufc.es.BancoImb.constantes.Constantes;
import br.com.ufc.es.BancoImb.model.CasaDoTabuleiro;
import br.com.ufc.es.BancoImb.model.ContaBancaria;
import br.com.ufc.es.BancoImb.model.Jogador;
import br.com.ufc.es.BancoImb.model.PecaJogador;
import br.com.ufc.es.BancoImb.model.Tabuleiro;

/**
 * https://github.com/marciosn/BANCO-IMOBILIARIO.git
 * 
 * @author Márcio Souza
 * 
 * **/
public class Controlador_Banco_Imobiliario {
	private Tabuleiro tabuleiroJogo;
	private List<Jogador> jogadores;
	private List<Jogador> jogadoresAindaJogando;
	private Jogador jogadorNaVEZ;
	private Jogador jogador;
	private boolean executando = true;
	private CasaDoTabuleiro destino;
	private ExecutaComportamentoDaCasa executar;
	private Constantes constante;

	private Window window;
	private Keyboard keyboard;
	private Scene scene;
	private Mouse mouse;
	private Animation botao;
	private Animation portfolioButton0, portfolioButton1, portfolioButton2, portfolioButton3, portfolioButton4;
	JTextArea portfolio;

	public Controlador_Banco_Imobiliario() {
		constante = new Constantes();
		
		/**
		 * objeto referentes a interface grafica
		 * */
		window = new Window(1080, 720);
		window.setCursor( window.createCustomCursor(constante.PATH_IMAGE + "mouse.png") );
		keyboard = window.getKeyboard();
		mouse = window.getMouse();
		portfolio = new JTextArea();
		scene = new Scene();
		scene.loadFromFile(constante.PATH_SCENE + "scene2.scn");
		scene.setDrawStartPos(0, 1);
		
		tabuleiroJogo = new Tabuleiro();
		jogadores = new ArrayList<Jogador>();
		jogadoresAindaJogando = new ArrayList<Jogador>();
		draw();
		inserirJogador();
		executar = new ExecutaComportamentoDaCasa();
		iniciarJogo();
	}

	/**
	 * Esse método é responsável apenas por inserir um objeto jogador na Lista de jogadores
	 * 
	 * **/
	public void InserindoJogadores(Jogador jogador) {
		jogadores.add(jogador);
	}

	/***
	 * Esse método adiciona a List de jogadores (citada no metodo anterior) na casa inicial do tabuleiro
	 * no caso a casa de partida
	 * **/
	public void adicionarJogadoresNaCasaDePartida(List<Jogador> jogadores) {
		for (Jogador j : jogadores) {
			jogadoresAindaJogando.add(j);
			tabuleiroJogo.adiconarJogadoresACasa(0, j);
			System.out.println("Classe: Banco Imobiliario"
					+ " -> Inserindo o jogador " + j.getNome() + " ID = "
					+ j.getID());
		}
		jogadorNaVEZ = jogadores.get(0);
	}

	/**
	 * metodo responsavel por chamar o metodo mover que esta implementado na classe tabuleiro
	 * os parametros necessarios sao o objeto a ser movido (no caso o objeto jogador e a casa do tabuleiro para a qual o jogador ira)
	 * **/
	public void moverJogador(Jogador jogador, CasaDoTabuleiro casa) {
		tabuleiroJogo.moverJogador(jogador, casa);
	}
	
	public void removerJogadorQueNaoPossuiSaldo(Jogador jogador){
		tabuleiroJogo.removeJogadorDefinitivo(jogador);
	}

	/***
	 * Esse método é responsavel pela insercao manual dos jogadores
	 * a pessoa que esta jogando, escolhe quantos jogadores existem no jogo
	 * depois informa seus nomes e entao o jogo começa
	 * **/
	public void inserirJogador() {
		
		String qtd = JOptionPane.showInputDialog(null,"Digite a quantidade de jogadores do Jogo!");
		int qtd_jogadores = Integer.valueOf(qtd);
		if (qtd_jogadores > 1 && qtd_jogadores < 6) {
			for (int i = 0; i < qtd_jogadores;) {
				String nomeJogador = JOptionPane.showInputDialog(null,"Digite o nome do jogador de ID = " + i);
				if(!nomeJogador.equals("")){
				String peca = "peca" + jogadores.size() + ".png";
				System.out.println(peca);
				InserindoJogadores(new Jogador(nomeJogador, new ContaBancaria(500), new PecaJogador(constante.PATH_IMAGE + peca)));
				i++;
				}
				
				/**
				 * a chamada de metodo InserindoJogadores, faz com que o objeto jogador que acabou de ser criado pelo usuario
				 * seja adicionado no arraylist jogadores.
				 * **/
			}
			/**
			 * 
			 * após o fim do laço, o usuario informou a quantidade e o nome dos jogadores q o jogo deve ter
			 * agora no metodo seguinte, o array de jogadores, é passado para o método, e todos os n jogadores
			 * sao adicionadas na casa de possicao 0 do array tabuleiro.
			 * **/
			adicionarJogadoresNaCasaDePartida(jogadores);
			
			iniciarPecas();  // essa chamada de método é responsavel por iterar um laço responsavel por imprmir as imagens na tela.
		} else {
			JOptionPane.showMessageDialog(null,	"Você digitou uma quantidade invalida de jogadores");
		
			/**
			 * aqui o metodo inserirJogador é chamado novamente caso o usuario digite uma quantidade de jogadores invalida
			 * **/
			inserirJogador();
		}

	}

	/**
	 * Esse método seta um objeto com o jogador que esta na vez de jogar
	 * o metodo recebe como parametro o int com o indice do jogador que esta jogando 
	 * assim ele calcula o indice do proximo jogador, busca o jogador por indice
	 * fazendo uma chamada a classe tabuleiro e recupera o objeto jogador que esta na vez agora
	 * **/
	public void mudarVezDeJogar(int indiceJogador) {
		System.out.println("\t Entrou no mudar vez");
		System.out.println("\t quantidade jogadores ainda jogando " + jogadores.size());
		int indiceProx = 0, temp = 0;
		System.out.println("\t indice do jogador que veio como paramentro é: " + indiceJogador);
		indiceProx = indiceJogador + 1;
		System.out.println("\t indiceprox é: " + indiceProx);
		if (indiceProx > jogadores.size() - 1) {
			System.out.println("\t entrou no if dentro do metodo mudar vez");
			temp = indiceProx % jogadores.size();
			indiceProx = temp;
		}
		
		if(!jogadores.contains(tabuleiroJogo.getJogadorByID(indiceProx)))
			System.out.println("\t"+ tabuleiroJogo.getJogadorByID(indiceProx).getNome() +"  nao esta na lista de jogadores");
		/**
		 * aqui o retorno do metodo getJogadorByID é setado na variavel jogador da vez
		 * para obter um objeto jogador apenas é necessário possuir um indice
		 * **/
		setJogadorNaVEZ(tabuleiroJogo.getJogadorByID(indiceProx));
	}
	/**
	 * metodo que inicia o laço do jogo
	 * **/
	public void iniciarJogo() {
		while (executando) {
			if(mouse.isOverObject(botao) && mouse.isLeftButtonPressed()){
				
			/**
			 * esse if verifica a quantidade de jogadores ainda no jogo
			 * se a quantidade for igual a 1 quer dizer q ja existe um vencedor
			 * **/
			if (jogadoresAindaJogando.size() == 1) {
				new Sound(constante.PATH_AUDIO + "champions.wav").play();
				
				JOptionPane.showMessageDialog(null, "O jogador "
						+ jogadoresAindaJogando.get(0).getNome() + "\n"
						+ "Venceu o jogo", "Vencedor", JOptionPane.PLAIN_MESSAGE, new ImageIcon(constante.PATH_IMAGE + "win.png"));
				executando = false;
				window.exit();
			}
			
			draw();  //chama o metodo que desenha a tela do jogo
			
			System.out.println(" A vez de jogar é do jogador "
					+ jogadorNaVEZ.getNome() + " que possui ID: "
					+ jogadorNaVEZ.getID());

			jogador = jogadorNaVEZ;
			String resultado = JOptionPane.showInputDialog(null,"Digite quantas casas o jogador " + jogador.getNome() + " vai andar!");

			if (!resultado.equals("") && !resultado.equals(null)) { //se o resultado do input for vazio nao pode entrar no laço
				int resultadoDados = Integer.valueOf(resultado);
				if (resultadoDados <= 12 || resultadoDados < 1) {
					/**
					 * a variavel indiceCasaDestino recebe o resultado do calculo do indice da proxima casa
					 * **/
					int indiceCasaDestino = tabuleiroJogo.calculaIndiceProximaCasa(jogador.getPosicaoJogador(), resultadoDados);
					
					/**
					 * a variável destino é do tipo casa, ela recebe o retorno do metodo getCasaByID, o unico paramentro
					 * necessario para se obte um objeto casa é saber seu indice
					 * */
					destino = tabuleiroJogo.getCasaByIndice(indiceCasaDestino);
					
					/**
					 * aqui o jogador é realmente movido de casa no tabuleiro
					 * ele é retitado da casa que se encontra e adicionado na casa destino
					 * 
					 * **/
					moverJogador(jogador, destino);
					
					/**
					 * uma vez que ja possuimos a casa de destino ja é possivel pegar a posicao da casa
					 * na qual o icone do jogador devera ser movida
					 * **/
					Point posicao = destino.getPosicao();
					jogador.getPeca().x = posicao.x;
					jogador.getPeca().y = posicao.y;
					draw();

					/**
					 * essa chamada de método é usada por todos os tipos de logradouros
					 * seja ele comercializavel ou nao, essa chamada faz com que seja possivel comprar uma casa
					 * e executar o efeito especial de outra casa
					 * **/
					executar.executarComportamento(jogador, destino);

					/**
					 * aqui acontece a verificação do saldo do jogador, caso ele nao possua mais saldo ele 
					 * é retirado de uma outra lista que nao é a jogadores, mas que tambem possui todos os jogadores do jogo
					 * essa retirada da lista acontece, porque em algum momento a quantidade de jogadores ainda jogando sera 
					 * verificada, e casa haja apenas um, temos um vencedor.
					 * **/
					if (possuiSaldoParaContinuar(jogador)) {
						System.out.println("\t entrou no if pra mudar a vez");
						mudarVezDeJogar(jogador.getID());
					}else{
						System.out.println("\t entrou no else pra mudar a vez");
						jogadoresAindaJogando.remove(jogador);
						jogadores.remove(jogador);
						//removerJogadorQueNaoPossuiSaldo(jogador);
						jogador.getPeca().loadImage(constante.PATH_IMAGE + "dead.png");
						draw();
						JOptionPane.showMessageDialog(null, "O jogador "
								+ jogador.getNome() + "\n"
								+ "Não possui mais saldo e vai deixar o jogo"
								+ "\n" + "Exite agora "
								+ jogadoresAindaJogando.size(),
								"Jogador Sai do Jogo", JOptionPane.PLAIN_MESSAGE, new ImageIcon(constante.PATH_IMAGE + "sad.png"));
						
						//JOptionPane.showMessageDialog(null,"Um jogador saiu", "Menos um no jogo" , JOptionPane.PLAIN_MESSAGE, new ImageIcon(constante.PATH_IMAGE + "sad.png"));
						
						mudarVezDeJogar(jogador.getID());
					}

				} else {
					JOptionPane.showMessageDialog(null,"Você digitou o numero dos dados de maneira errada");
				}
			}else{
				JOptionPane.showMessageDialog(null,"O input não pode ser vazio");
			}
			
		}
			/**
			 * essas condições ativam os botoes que exibem o portfolio do jogador
			 * 
			 * */
			
			if(mouse.isOverObject(portfolioButton0) && mouse.isLeftButtonPressed()){
				exibeLogradourosJogador(getJodagores().get(0));
			}
			if(mouse.isOverObject(portfolioButton1) && mouse.isLeftButtonPressed()){
				exibeLogradourosJogador(getJodagores().get(1));
			}
			if(mouse.isOverObject(portfolioButton2) && mouse.isLeftButtonPressed() && jogadores.size() == 3){
				exibeLogradourosJogador(getJodagores().get(2));
			}
			if(mouse.isOverObject(portfolioButton3) && mouse.isLeftButtonPressed() && jogadores.size() == 4){
				exibeLogradourosJogador(getJodagores().get(3));
			}
			if(mouse.isOverObject(portfolioButton4) && mouse.isLeftButtonPressed() && jogadores.size() == 5){
				exibeLogradourosJogador(getJodagores().get(4));
			}
			
			/**
			 * 
			 * */
		
		}
		window.exit();
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
	
	public void draw() {
		scene.draw();
		desenhaDadoBotao();
		desenhaPortfolioBotao();
		window.update();
	}
	
	public void desenhaDadoBotao(){
		botao = new Animation(constante.PATH_IMAGE + "dado.png");
		botao.x = 800;
		botao.y = 110;
		botao.draw();
	}
	/**
	 * isso pode vir a ser uma classe separada quando o projeto for refatorado
	 * **/
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
	/**
	 * verifica que recebe um objeto jogador e verifica se saldo é maior que 0
	 * retorna um boolean
	 * **/
	public boolean possuiSaldoParaContinuar(Jogador jogador) {
		boolean possuiSaldo = false;
		if (jogador.getSaldo() < 0) {
			return possuiSaldo;
		} else {
			possuiSaldo = true;
		}
		return possuiSaldo;
	}
	/**
	 * 
	 *método que crias peças no tabuleiro
	 * **/
	public void iniciarPecas() {
		for (Jogador j : tabuleiroJogo.getTabuleiro().get(0)
				.getJogadoresNaCasa()) {
			scene.addOverlay(j.getPeca());
		}
	}

	public List<Jogador> getJodagores() {
		return jogadores;
	}

	public Tabuleiro getTabuleiroJogo() {
		return tabuleiroJogo;
	}

	public Jogador getJogadorNaVEZ() {
		return jogadorNaVEZ;
	}

	public void setJogadorNaVEZ(Jogador jogadorDaVEZ) {
		this.jogadorNaVEZ = jogadorDaVEZ;
	}
}
