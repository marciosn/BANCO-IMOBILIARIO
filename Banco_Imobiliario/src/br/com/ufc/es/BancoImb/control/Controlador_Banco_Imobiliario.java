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

	public void desenhaBotao() {
		botao = new Animation("botao.png");
		botao.x = 183;
		botao.y = 104;
		botao.draw();
	}

	public void InserindoJogadores(Jogador jogador) {
		jogadores.add(jogador);
	}

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

	public void moverJogador(Jogador jogador, CasaDoTabuleiro casa) {
		tabuleiroJogo.moverJogador(jogador, casa);
	}

	public void inserirJogadorNaCasa(int posicao, Jogador jogador) {
		tabuleiroJogo.adiconarJogadoresACasa(posicao, jogador);
	}

	public void inserirJogador() {

		String qtd = JOptionPane.showInputDialog(null,
				"Digite a quantidade de jogadores do Jogo!");
		int qtd_jogadores = Integer.valueOf(qtd);

		if (qtd_jogadores > 1 && qtd_jogadores < 6) {
			for (int i = 0; i < qtd_jogadores;) {
				String nomeJogador = JOptionPane.showInputDialog(null,
						"Digite o nome do jogador de ID = " + i);
				String peca = "peca" + jogadores.size() + ".png";
				System.out.println(peca);
				InserindoJogadores(new Jogador(nomeJogador, new ContaBancaria(
						1000), new PecaJogador(constante.PATH_IMAGE + peca)));
				i++;
			}
			adicionarJogadoresNaCasaDePartida(jogadores);
			iniciarPecas();
		} else {
			JOptionPane.showMessageDialog(null,
					"Você digitou uma quantidade invalida de jogadores");
			inserirJogador();
		}

	}

	public void mudarVezDeJogar(int indiceJogador) {
		int indiceProx = 0, temp = 0;
		indiceProx = indiceJogador + 1;
		if (indiceProx > jogadores.size() - 1) {
			temp = indiceProx % jogadores.size();
			indiceProx = temp;
		}
		setJogadorNaVEZ(tabuleiroJogo.getJogadorByID(indiceProx));
	}

	public void iniciarJogo() {
		while (executando) {

			if (jogadoresAindaJogando.size() == 1) {
				new Sound(constante.PATH_AUDIO + "champions.wav").play();
				;
				JOptionPane.showMessageDialog(null, "O jogador "
						+ jogadoresAindaJogando.get(0).getNome() + "\n"
						+ "Venceu o jogo", "Vencedor", JOptionPane.OK_OPTION);
				executando = false;
				window.exit();
			}
			draw();

			System.out.println(" A vez de jogar é do jogador "
					+ jogadorNaVEZ.getNome() + " que possui ID: "
					+ jogadorNaVEZ.getID());

			jogador = jogadorNaVEZ;

			String resultado = JOptionPane.showInputDialog(null,
					"Digite o resultado dos dados");

			if (!resultado.equals("")) {

				int resultadoDados = Integer.valueOf(resultado);

				if (resultadoDados <= 12) {

					int indiceCasaDestino = tabuleiroJogo
							.calculaIndiceProximaCasa(
									jogador.getPosicaoJogador(), resultadoDados);
					destino = tabuleiroJogo.getCasaByIndice(indiceCasaDestino);

					Point posicao = destino.getPosicao();
					jogador.getPeca().x = posicao.x;
					jogador.getPeca().y = posicao.y;

					moverJogador(jogador, destino);

					executar.executarComportamento(jogador, destino);

					if (!possuiSaldoParaContinuar(jogador)) {
						jogadoresAindaJogando.remove(jogador);
						JOptionPane.showMessageDialog(null, "O jogador "
								+ jogador.getNome() + "\n"
								+ "Não possui mais saldo e vai deixar o jogo"
								+ "\n" + "Exitem agora "
								+ jogadoresAindaJogando.size(),
								"Jogador Sai do Jogo", JOptionPane.OK_OPTION);
					}
					mudarVezDeJogar(jogador.getID());

				} else {
					JOptionPane
							.showMessageDialog(null,
									"Você digitou o numero dos dados de maneira errada");
				}
			}
			System.out
					.println("<<<<<<<<<<==============================================================================>>>>>>>>>>");

		}
		window.exit();

	}

	public void draw() {
		scene.draw();
		botao = new Animation(constante.PATH_IMAGE + "botao.png");
		botao.x = 183;
		botao.y = 104;
		botao.draw();
		window.update();
	}

	public boolean possuiSaldoParaContinuar(Jogador jogador) {
		boolean possuiSaldo = false;
		if (jogador.getSaldo() < 0) {
			return possuiSaldo;
		} else {
			possuiSaldo = true;
		}
		return possuiSaldo;
	}

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
