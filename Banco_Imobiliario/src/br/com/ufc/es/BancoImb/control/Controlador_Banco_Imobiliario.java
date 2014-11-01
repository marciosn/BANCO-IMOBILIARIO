package br.com.ufc.es.BancoImb.control;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

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
import br.com.ufc.es.BancoImb.view.TabuleiroInterfaceGrafica;

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
	private MudarJogadorNaVez mudarVez;
	private TabuleiroInterfaceGrafica view;
	private RulesGame rules;

	public Controlador_Banco_Imobiliario() {
		constante = new Constantes();
		mudarVez = new MudarJogadorNaVez();
		view = new TabuleiroInterfaceGrafica();
		rules = new RulesGame();

		tabuleiroJogo = new Tabuleiro();
		jogadores = new ArrayList<Jogador>();
		jogadoresAindaJogando = new ArrayList<Jogador>();
		view.draw();
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
			System.out.println("Classe: Banco Imobiliario"+ " -> Inserindo o jogador " + j.getNome() + " ID = "	+ j.getID());
		}
		jogadorNaVEZ = jogadores.get(0);
	}

	public void moverJogador(Jogador jogador, CasaDoTabuleiro casa) {
		tabuleiroJogo.moverJogador(jogador, casa);
	}
	
	public void removerJogadorQueNaoPossuiSaldo(Jogador jogador){
		tabuleiroJogo.removeJogadorDefinitivo(jogador);
	}

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
			}
			adicionarJogadoresNaCasaDePartida(jogadores);
			
			view.iniciarPecas(tabuleiroJogo.getTabuleiro());
		} else {
			JOptionPane.showMessageDialog(null,	"Você digitou uma quantidade invalida de jogadores");
			inserirJogador();
		}

	}
	public void mudaJogadorVEZ(int IdJogadorAtual, List<Jogador> jogadores){
		setJogadorNaVEZ(tabuleiroJogo.getJogadorByID(mudarVez.mudarVezDeJogar(IdJogadorAtual, jogadores)));
	}

	public void iniciarJogo() {
		while (executando) {
			if(view.getMouse().isOverObject(view.getBotao()) && view.getMouse().isLeftButtonPressed()){
				
			if (jogadoresAindaJogando.size() == 1) {
				new Sound(constante.PATH_AUDIO + "champions.wav").play();
				
				JOptionPane.showMessageDialog(null, "O jogador "
						+ jogadoresAindaJogando.get(0).getNome() + "\n"
						+ "Venceu o jogo", "Vencedor", JOptionPane.PLAIN_MESSAGE, new ImageIcon(constante.PATH_IMAGE + "win.png"));
				executando = false;
				view.getWindow().exit();
			}
			
			view.draw();  //chama o metodo que desenha a tela do jogo
			
			System.out.println(" A vez de jogar é do jogador "
					+ jogadorNaVEZ.getNome() + " que possui ID: "
					+ jogadorNaVEZ.getID());

			jogador = jogadorNaVEZ;
			String resultado = JOptionPane.showInputDialog(null,"Digite quantas casas o jogador " + jogador.getNome() + " vai andar!");

			if (!resultado.equals("") && !resultado.equals(null)) { //se o resultado do input for vazio nao pode entrar no laço
				int resultadoDados = Integer.valueOf(resultado);
				if (resultadoDados <= 12 || resultadoDados < 1) {
					
					int indiceCasaDestino = tabuleiroJogo.calculaIndiceProximaCasa(jogador.getPosicaoJogador(), resultadoDados);
					
					destino = tabuleiroJogo.getCasaByIndice(indiceCasaDestino);
					
					moverJogador(jogador, destino);
					view.moverPecaJogador(destino, jogador);
					executar.executarComportamento(jogador, destino);

					if (rules.verificaSeJogadorAindaPossuiSaldo(jogador)) {
						mudaJogadorVEZ(jogador.getID(), jogadores);
					}else{
						System.out.println("\t entrou no else pra mudar a vez");
						jogadoresAindaJogando.remove(jogador);
						jogadores.remove(jogador);
						
						view.jogadorNaoPossuiSaldo(jogador, jogadoresAindaJogando);
						mudaJogadorVEZ(jogador.getID(), jogadores);
					}

				} else {
					JOptionPane.showMessageDialog(null,"Você digitou o numero dos dados de maneira errada");
				}
			}else{
				JOptionPane.showMessageDialog(null,"O input não pode ser vazio");
			}
			
		}

			
			if(view.getMouse().isOverObject(view.getPortfolioButton0()) && view.getMouse().isLeftButtonPressed()){
				view.exibeLogradourosJogador(getJodagores().get(0));
			}
			if(view.getMouse().isOverObject(view.getPortfolioButton1()) && view.getMouse().isLeftButtonPressed()){
				view.exibeLogradourosJogador(getJodagores().get(1));
			}
			if(view.getMouse().isOverObject(view.getPortfolioButton2()) && view.getMouse().isLeftButtonPressed() && jogadores.size() == 3){
				view.exibeLogradourosJogador(getJodagores().get(2));
			}
			if(view.getMouse().isOverObject(view.getPortfolioButton3()) && view.getMouse().isLeftButtonPressed() && jogadores.size() == 4){
				view.exibeLogradourosJogador(getJodagores().get(3));
			}
			if(view.getMouse().isOverObject(view.getPortfolioButton4()) && view.getMouse().isLeftButtonPressed() && jogadores.size() == 5){
				view.exibeLogradourosJogador(getJodagores().get(4));
			}
			
			/**
			 * 
			 * */
		
		}
		view.getWindow().exit();
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
