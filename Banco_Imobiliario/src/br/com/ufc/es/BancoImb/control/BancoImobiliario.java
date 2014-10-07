package br.com.ufc.es.BancoImb.control;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import br.com.ufc.es.BancoImb.model.Casa;
import br.com.ufc.es.BancoImb.model.ContaBancaria;
import br.com.ufc.es.BancoImb.model.Jogador;
import br.com.ufc.es.BancoImb.model.Tabuleiro;

public class BancoImobiliario {

	Tabuleiro tabuleiroJogo;
	List<Jogador> jodagores;

	public BancoImobiliario() {
		tabuleiroJogo = new Tabuleiro();
		jodagores = new ArrayList<Jogador>();
	}

	public void criarGrid() {

		JFrame janela = new JFrame("Banco Imobiliario");
		janela.setSize(800, 600);
		janela.setVisible(true);
		janela.getContentPane().setBackground(Color.DARK_GRAY);

		String[] colunas = new String[] { "Nome", "Idade", "Sexo" };

		String[][] dados = new String[][] { { "Rodrigo", "28", "Masculino" },
				{ "Maria", "30", "Feminino" } };

		JTable tabela = new JTable(dados, colunas);
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(tabela);
		janela.add(scroll);
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

}
