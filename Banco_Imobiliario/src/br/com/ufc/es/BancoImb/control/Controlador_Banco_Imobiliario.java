package br.com.ufc.es.BancoImb.control;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.ufc.es.BancoImb.model.CasaDoTabuleiro;
import br.com.ufc.es.BancoImb.model.ContaBancaria;
import br.com.ufc.es.BancoImb.model.Jogador;
import br.com.ufc.es.BancoImb.model.Tabuleiro;

/**
 * https://github.com/marciosn/Banco-Imobiliario.git
 * **/
public class Controlador_Banco_Imobiliario {

	Tabuleiro tabuleiroJogo;
	List<Jogador> jodagores;
	Jogador jogadorNaVEZ;
	Jogador jogador;
	Scanner entrada = new Scanner(System.in);
	boolean executando = true;
	CasaDoTabuleiro destino;
	ExecutaComportamentoDaCasa verif;

	public Controlador_Banco_Imobiliario() {
		tabuleiroJogo = new Tabuleiro();
		jodagores = new ArrayList<Jogador>();
		criarJogadores();
		verif = new ExecutaComportamentoDaCasa();
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
	public void moverJogador(Jogador jogador, CasaDoTabuleiro casa){
		tabuleiroJogo.moverJogador(jogador, casa);
	}
	
	public void inserirJogadorNaCasa(int posicao, Jogador jogador) {
		tabuleiroJogo.adiconarJogadoresACasa(posicao, jogador);
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
		InserindoJogadores(new Jogador("marcio", new ContaBancaria(1000)));
		InserindoJogadores(new Jogador("marcio", new ContaBancaria(1000)));
		InserindoJogadores(new Jogador("nobre", new ContaBancaria(1000)));
		InserindoJogadores(new Jogador("edu", new ContaBancaria(1000)));
		InserindoJogadores(new Jogador("dudu", new ContaBancaria(1000)));
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
			setJogadorNaVEZ(tabuleiroJogo.getJogadorByID(indiceProx));
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
					destino = tabuleiroJogo.getCasaByIndice(indiceCasaDestino);
					
					System.out.println("\t Nome da casa destino: "+ destino.getNome());
					System.out.println("\t O indice da casa destino é: "+ tabuleiroJogo.getIndiceByCasa(destino));
					System.out.println("\t Possui: "+ destino.getNumJogadoresCasa()	+ " jogadores na casa");

					moverJogador(jogador,destino);
				}
				
				verif.executarComportamento(jogador,destino);
				
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
