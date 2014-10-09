package br.com.ufc.es.BancoImb.control;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Scanner;

import javax.swing.JFrame;

import br.com.ufc.es.BancoImb.LogradourComercializavel.Jogador;
import br.com.ufc.es.BancoImb.model.Casa;
import br.com.ufc.es.BancoImb.model.ContaBancaria;
import br.com.ufc.es.BancoImb.model.Portifolio;
import br.com.ufc.es.BancoImb.model.Tabuleiro;

public class Jogo extends JFrame {
	public static void main(String[] args) {
		boolean executando = true;
		Scanner entrada = new Scanner(System.in);
		Casa origem = null, destino = null;
		Jogador jogador = null;
		Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();

		BancoImobiliario bancoImobiliario = new BancoImobiliario();
		VerificarEstadoCasa verf = new VerificarEstadoCasa();

		Jogador marcio = new Jogador("marcio", new ContaBancaria(10000));
		Jogador souza = new Jogador("souza", new ContaBancaria(10000));
		Jogador nobre = new Jogador("nobre", new ContaBancaria(10000));
		Jogador edu = new Jogador("edu", new ContaBancaria(10000));
		Jogador dudu = new Jogador("dudu", new ContaBancaria(10000));

		bancoImobiliario.InserindoJogadores(marcio);
		bancoImobiliario.InserindoJogadores(souza);
		bancoImobiliario.InserindoJogadores(nobre);
		/*bancoImobiliario.InserindoJogadores(edu);
		bancoImobiliario.InserindoJogadores(dudu);*/
		

		bancoImobiliario.adicionarJogadoresNaCasaDePartida(bancoImobiliario.getJodagores());

		Casa casa = bancoImobiliario.tabuleiroJogo.getCasaPeloIndice(0);
		System.out.println("A casa " + casa.getNome() + " possui "
				+ casa.getJogadoresNaCasa().size() + " jogadores");
		for (Jogador j : casa.getJogadoresNaCasa()) {
			System.out.println("Nome: " + j.getNome() + " ID: " + j.getID());
		}

		System.out.println("\n");
		System.out.println("\n");
		System.out.println("\t BANCO IMOBILIARIO");

		System.out.println("Digite 1 para mover o usuario");
		
		int opcao = entrada.nextInt();
		while (executando) {
			switch (opcao) {

			case 1:
				System.out.println("\t A vez de jogar é do jogador " + bancoImobiliario.getJogadorNaVEZ().getNome() +" que possui ID: "+ bancoImobiliario.getJogadorNaVEZ().getID());
				System.out.println("\n");

				jogador =  bancoImobiliario.getJogadorNaVEZ();

				System.out.println("Digite o resultado do lançamento dos dados");
				int resultadoDados = entrada.nextInt();
				if (resultadoDados <= 12) {
					int indiceCasaDestino = bancoImobiliario.tabuleiroJogo.calculaIndiceProximaCasa(jogador.getPosicaoJogador(),resultadoDados);
					destino = bancoImobiliario.tabuleiroJogo.getCasaPeloIndice(indiceCasaDestino);
					
					
					
					System.out.println("\t Nome da casa destino: "+ destino.getNome());
					System.out.println("\t O indice da casa destino é: "+ bancoImobiliario.getTabuleiroJogo().getIndiceCasa(destino));
					System.out.println("\t Possui: "+ destino.getNumJogadoresCasa()	+ " jogadores na casa");

					bancoImobiliario.tabuleiroJogo.moverJogador(jogador,destino);
				}
				
				verf.verificarEstado(jogador,destino);
				
				System.out.println("<<<<<<<<<<==============================================================================>>>>>>>>>>");
					bancoImobiliario.mudarVezDeJogar(jogador.getID());
				System.out.println("<<<<<<<<<<==============================================================================>>>>>>>>>>");
				
				break;

			default:
				break;
			}

		}

	}

}
