package br.com.ufc.es.BancoImb.control;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import jplay.Animation;
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
 * @author M�rcio Souza
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

	public Controlador_Banco_Imobiliario() {
		constante = new Constantes();
		
		/**
		 * objeto referentes a interface grafica
		 * */
		window = new Window(1080, 720);
		keyboard = window.getKeyboard();
		mouse = window.getMouse();
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
	 * Esse m�todo � respons�vel apenas por inserir um objeto jogador na Lista de jogadores
	 * 
	 * **/
	public void InserindoJogadores(Jogador jogador) {
		jogadores.add(jogador);
	}

	/***
	 * Esse m�todo adiciona a List de jogadores (citada no metodo anterior) na casa inicial do tabuleiro
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

	/***
	 * Esse m�todo � responsavel pela insercao manual dos jogadores
	 * a pessoa que esta jogando, escolhe quantos jogadores existem no jogo
	 * depois informa seus nomes e entao o jogo come�a
	 * **/
	public void inserirJogador() {
		String qtd = JOptionPane.showInputDialog(null,"Digite a quantidade de jogadores do Jogo!");
		int qtd_jogadores = Integer.valueOf(qtd);
		if (qtd_jogadores > 1 && qtd_jogadores < 6) {
			for (int i = 0; i < qtd_jogadores;) {
				String nomeJogador = JOptionPane.showInputDialog(null,"Digite o nome do jogador de ID = " + i);
				String peca = "peca" + jogadores.size() + ".png";
				System.out.println(peca);
				InserindoJogadores(new Jogador(nomeJogador, new ContaBancaria(1000), new PecaJogador(constante.PATH_IMAGE + peca)));
				i++;
				
				/**
				 * a chamada de metodo InserindoJogadores, faz com que o objeto jogador que acabou de ser criado pelo usuario
				 * seja adicionado no arraylist jogadores.
				 * **/
			}
			/**
			 * 
			 * ap�s o fim do la�o, o usuario informou a quantidade e o nome dos jogadores q o jogo deve ter
			 * agora no metodo seguinte, o array de jogadores, � passado para o m�todo, e todos os n jogadores
			 * sao adicionadas na casa de possicao 0 do array tabuleiro.
			 * **/
			adicionarJogadoresNaCasaDePartida(jogadores);
			
			iniciarPecas();  // essa chamada de m�todo � responsavel por iterar um la�o responsavel por imprmir as imagens na tela.
		} else {
			JOptionPane.showMessageDialog(null,	"Voc� digitou uma quantidade invalida de jogadores");
		
			/**
			 * aqui o metodo inserirJogador � chamado novamente caso o usuario digite uma quantidade de jogadores invalida
			 * **/
			inserirJogador();
		}

	}

	/**
	 * Esse m�todo seta um objeto com o jogador que esta na vez de jogar
	 * o metodo recebe como parametro o int com o indice do jogador que esta jogando 
	 * assim ele calcula o indice do proximo jogador, busca o jogador por indice
	 * fazendo uma chamada a classe tabuleiro e recupera o objeto jogador que esta na vez agora
	 * **/
	public void mudarVezDeJogar(int indiceJogador) {
		int indiceProx = 0, temp = 0;
		indiceProx = indiceJogador + 1;
		if (indiceProx > jogadores.size() - 1) {
			temp = indiceProx % jogadores.size();
			indiceProx = temp;
		}
		/**
		 * aqui o retorno do metodo getJogadorByID � setado na variavel jogador da vez
		 * para obter um objeto jogador apenas � necess�rio possuir um indice
		 * **/
		setJogadorNaVEZ(tabuleiroJogo.getJogadorByID(indiceProx));
	}
	/**
	 * metodo que inicia o la�o do jogo
	 * **/
	public void iniciarJogo() {
		while (executando) {
			/**
			 * esse if verifica a quantidade de jogadores ainda no jogo
			 * se a quantidade for igual a 1 quer dizer q ja existe um vencedor
			 * **/
			if (jogadoresAindaJogando.size() == 1) {
				new Sound(constante.PATH_AUDIO + "champions.wav").play();
				
				JOptionPane.showMessageDialog(null, "O jogador "
						+ jogadoresAindaJogando.get(0).getNome() + "\n"
						+ "Venceu o jogo", "Vencedor", JOptionPane.OK_OPTION);
				executando = false;
				window.exit();
			}
			
			draw();  //chama o metodo que desenha a tela do jogo
			
			System.out.println(" A vez de jogar � do jogador "
					+ jogadorNaVEZ.getNome() + " que possui ID: "
					+ jogadorNaVEZ.getID());

			jogador = jogadorNaVEZ;

			String resultado = JOptionPane.showInputDialog(null,"Digite o resultado dos dados");

			if (!resultado.equals("") || !resultado.equals(null)) { //se o resultado do input for vazio nao pode entrar no la�o
				int resultadoDados = Integer.valueOf(resultado);
				if (resultadoDados <= 12 || resultadoDados < 1) {
					/**
					 * a variavel indiceCasaDestino recebe o resultado do calculo do indice da proxima casa
					 * **/
					int indiceCasaDestino = tabuleiroJogo.calculaIndiceProximaCasa(jogador.getPosicaoJogador(), resultadoDados);
					
					/**
					 * a vari�vel destino � do tipo casa, ela recebe o retorno do metodo getCasaByID, o unico paramentro
					 * necessario para se obte um objeto casa � saber seu indice
					 * */
					destino = tabuleiroJogo.getCasaByIndice(indiceCasaDestino);
					
					/**
					 * uma vez que ja possuimos a casa de destino ja � possivel pegar a posicao da casa
					 * na qual o icone do jogador devera ser movida
					 * **/
					Point posicao = destino.getPosicao();
					jogador.getPeca().x = posicao.x;
					jogador.getPeca().y = posicao.y;

					/**
					 * aqui o jogador � realmente movido de casa no tabuleiro
					 * ele � retitado da casa que se encontra e adicionado na casa destino
					 * 
					 * **/
					moverJogador(jogador, destino);

					/**
					 * essa chamada de m�todo � usada por todos os tipos de logradouros
					 * seja ele comercializavel ou nao, essa chamada faz com que seja possivel comprar uma casa
					 * e executar o efeito especial de outra casa
					 * **/
					executar.executarComportamento(jogador, destino);

					/**
					 * aqui acontece a verifica��o do saldo do jogador, caso ele nao possua mais saldo ele 
					 * � retirado de uma outra lista que nao � a jogadores, mas que tambem possui todos os jogadores do jogo
					 * essa retirada da lista acontece, porque em algum momento a quantidade de jogadores ainda jogando sera 
					 * verificada, e casa haja apenas um, temos um vencedor.
					 * **/
					if (possuiSaldoParaContinuar(jogador)) {
						mudarVezDeJogar(jogador.getID());
					}else{
						jogadoresAindaJogando.remove(jogador);
						JOptionPane.showMessageDialog(null, "O jogador "
								+ jogador.getNome() + "\n"
								+ "N�o possui mais saldo e vai deixar o jogo"
								+ "\n" + "Exitem agora "
								+ jogadoresAindaJogando.size(),
								"Jogador Sai do Jogo", JOptionPane.OK_OPTION);
					}

				} else {
					JOptionPane.showMessageDialog(null,"Voc� digitou o numero dos dados de maneira errada");
				}
			}else{
				JOptionPane.showMessageDialog(null,"O input n�o pode ser vazio");
			}
			System.out.println("<<<<<<<<<<==============================================================================>>>>>>>>>>");

		}
		window.exit();

	}

	public void draw() {
		scene.draw();
		/*botao = new Animation(constante.PATH_IMAGE + "botao.png");
		botao.x = 183;
		botao.y = 104;
		botao.draw();*/
		window.update();
	}

	/**
	 * verifica que recebe um objeto jogador e verifica se saldo � maior que 0
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
	 *m�todo que crias pe�as no tabuleiro
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
