package br.com.ufc.es.BancoImb.control;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import br.com.ufc.es.BancoImb.LugarEspecial.Partida;
import br.com.ufc.es.BancoImb.model.Casa;
import br.com.ufc.es.BancoImb.model.ContaBancaria;
import br.com.ufc.es.BancoImb.model.Jogador;
import br.com.ufc.es.BancoImb.model.Tabuleiro;

/**
 * 
 * https://github.com/marciosn/Banco-Imobiliario.git
 * 
 * **/


public class BancoImobiliario {

	Tabuleiro tabuleiroJogo;
	List<Jogador> jodagores;
	Jogador jogadorNaVEZ;
	Jogador jogador;
	Scanner entrada = new Scanner(System.in);
	boolean executando = true;
	Casa destino;
	VerificarEstadoCasa verif;

	public BancoImobiliario() {
		tabuleiroJogo = new Tabuleiro();
		jodagores = new ArrayList<Jogador>();
		criarJogadores();
		verif = new VerificarEstadoCasa();
		iniciarJogo();
	}
	public void InserindoJogadores(Jogador jogador) {
		jodagores.add(jogador);
	}

	public void adicionarJogadoresNaCasaDePartida(List<Jogador> jogadores) {
		for (Jogador j : jogadores) {
			tabuleiroJogo.adiconarJogadoresACasa(0, j);
			System.out.println("Classe: Banco Imobiliario"
					+ " ----> Inserindo o jogador " + j.getNome() + " ID = " + j.getID());			
		}
		jogadorNaVEZ = jogadores.get(0);
	}
	
	public void inserirJogadorNaCasa(int posicao, Jogador jogador) {
		tabuleiroJogo.adiconarJogadoresACasa(posicao, jogador);
	}

	public void moverJogador(Jogador jogador, Casa origem, Casa destino) {
		tabuleiroJogo.moverJogador(jogador, origem, destino);
	}

	public List<Jogador> getJodagores() {
		return jodagores;
	}

	public void setJodagores(List<Jogador> jodagores) {
		this.jodagores = jodagores;
	}

	public Tabuleiro getTabuleiroJogo() {
		return tabuleiroJogo;
	}

	public void setTabuleiroJogo(Tabuleiro tabuleiroJogo) {
		this.tabuleiroJogo = tabuleiroJogo;
	}
	
	public void criarJogadores(){
		Jogador marcio = new Jogador("marcio", new ContaBancaria(10000));
		Jogador souza = new Jogador("souza", new ContaBancaria(10000));
		Jogador nobre = new Jogador("nobre", new ContaBancaria(10000));
		Jogador edu = new Jogador("edu", new ContaBancaria(10000));
		Jogador dudu = new Jogador("dudu", new ContaBancaria(10000));
		
		InserindoJogadores(marcio);
		InserindoJogadores(souza);
		InserindoJogadores(nobre);
		InserindoJogadores(edu);
		InserindoJogadores(dudu);
		
		adicionarJogadoresNaCasaDePartida(jodagores);
	}
	
	public Jogador getJogadorNaVEZ() {
		return jogadorNaVEZ;
	}

	public void setJogadorNaVEZ(Jogador jogadorDaVEZ) {
		this.jogadorNaVEZ = jogadorDaVEZ;
	}
	public void mudarVezDeJogar(int indiceJogador){
		int indiceProx = 0, temp = 0;
		indiceProx = indiceJogador + 1;
		if(indiceProx > jodagores.size()- 1){
			temp = indiceProx % jodagores.size();
			indiceProx = temp;
		}
			setJogadorNaVEZ(tabuleiroJogo.getJogadorASerMovido(indiceProx));
	}

	public void iniciarJogo(){
		System.out.println("Digite 1 para iniciar a logica do jogo");
		
		int opcao = entrada.nextInt();
		while (executando) {
			switch (opcao) {

			case 1:
				System.out.println("\t A vez de jogar é do jogador " + jogadorNaVEZ.getNome() +" que possui ID: "+ jogadorNaVEZ.getID());
				System.out.println("\n");

				jogador =  jogadorNaVEZ;

				System.out.println("Digite o resultado do lançamento dos dados");
				int resultadoDados = entrada.nextInt();
				if (resultadoDados <= 12) {
					int indiceCasaDestino = tabuleiroJogo.calculaIndiceProximaCasa(jogador.getPosicaoJogador(),resultadoDados);
					destino = tabuleiroJogo.getCasaPeloIndice(indiceCasaDestino);
					
					System.out.println("\t Nome da casa destino: "+ destino.getNome());
					System.out.println("\t O indice da casa destino é: "+ tabuleiroJogo.getIndiceCasa(destino));
					System.out.println("\t Possui: "+ destino.getNumJogadoresCasa()	+ " jogadores na casa");

					tabuleiroJogo.moverJogador(jogador,destino);
				}
				
				verif.verificarEstado(jogador,destino);
				
				System.out.println("<<<<<<<<<<==============================================================================>>>>>>>>>>");
					mudarVezDeJogar(jogador.getID());
				System.out.println("<<<<<<<<<<==============================================================================>>>>>>>>>>");
				
				break;

			default:
				break;
			}

		}
	}
}
