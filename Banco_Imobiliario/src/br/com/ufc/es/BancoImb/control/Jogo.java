package br.com.ufc.es.BancoImb.control;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Scanner;

import javax.swing.JFrame;

import br.com.ufc.es.BancoImb.model.Casa;
import br.com.ufc.es.BancoImb.model.ContaBancaria;
import br.com.ufc.es.BancoImb.model.Jogador;
import br.com.ufc.es.BancoImb.model.Tabuleiro;

public class Jogo extends JFrame{
	public static void main(String[] args) {
		boolean executando = true;
		Scanner entrada = new Scanner(System.in); 
		Casa origem = null, destino = null;
		Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();  
		
		BancoImobiliario bancoImobiliario = new BancoImobiliario();
		
		Jogador marcio = new Jogador("marcio", new ContaBancaria(10000));
		Jogador souza = new Jogador("souza", new ContaBancaria(10000));
		Jogador nobre = new Jogador("nobre", new ContaBancaria(10000));
		Jogador edu = new Jogador("edu", new ContaBancaria(10000));
		Jogador dudu = new Jogador("dudu", new ContaBancaria(10000));
		
		bancoImobiliario.InserindoJogadores(marcio);
		bancoImobiliario.InserindoJogadores(souza);
		bancoImobiliario.InserindoJogadores(nobre);
		bancoImobiliario.InserindoJogadores(edu);
		bancoImobiliario.InserindoJogadores(dudu);
		
		
		bancoImobiliario.adicionarJogadoresNaCasaDePartida(bancoImobiliario.getJodagores());

		//bancoImobiliario.tabuleiroJogo.imprimiTabuleiro();
		
		Casa casa = bancoImobiliario.tabuleiroJogo.getCasaPeloIndice(0);
		System.out.println("A casa " + casa.getNome()+ " possui " +casa.getJogadoresNaCasa().size() + " joagdores");
		for(Jogador j : casa.getJogadoresNaCasa()){
			System.out.println("Nome: " + j.getNome() + " ID: " +j.getID());
		}
		/*for(int i =0; i < 5 ; i++){
			System.out.println("Indice: " + i);
			bancoImobiliario.tabuleiroJogo.imprimirJogadoresNaCasa(i);
			System.out.println("===================================");
		}*/
		
		System.out.println("BANCO IMOBILIÁRIO");
		
		
		System.out.println("Digite 1 para mover o usuario");
		System.out.println("Digite 2 para mover o usuario usando um metodo diferente");
		int opcao = entrada.nextInt();
		while(executando){
			switch (opcao) {
			case 1:
				
				System.out.println("Digite o indice da casa de origem do jogador");
				int indiceOrigem = entrada.nextInt();
				if(indiceOrigem < 40){
					origem = bancoImobiliario.tabuleiroJogo.getCasaPeloIndice(indiceOrigem);
					System.out.println("---------> Nome da casa origem: " + origem.getNome());
					System.out.println("---------> Possui: " + origem.getNumJogadoresCasa() + " jogadores na casa");
				}
				
				System.out.println("Digite o indice da casa de destino do jogador");
				int indiceDestino = entrada.nextInt();
				if(indiceDestino < 40){
					destino = bancoImobiliario.tabuleiroJogo.getCasaPeloIndice(indiceDestino);
					System.out.println("---------> Nome da casa origem: " + destino.getNome());
					System.out.println("---------> Possui: " + destino.getNumJogadoresCasa() + " jogadores na casa");
				}
				
				System.out.println("Digite o id do jogador que vai se mover");
				int id = entrada.nextInt();
							
				Jogador jogador = bancoImobiliario.tabuleiroJogo.getJogadorASerMovido(id, origem);
				System.out.println(jogador.getNome());
				System.out.println(jogador.getSaldo());
				
				bancoImobiliario.tabuleiroJogo.moverJogador(jogador, origem, destino);
				System.out.println("=============================================");
				break;
				case 2:
					/*System.out.println("Digite o indice da casa de origem do jogador");
					int indiceOrigem = entrada.nextInt();
					if(indiceOrigem < 40){
						origem = bancoImobiliario.tabuleiroJogo.getCasaPeloIndice(indiceOrigem);
						System.out.println("---------> Nome da casa origem: " + origem.getNome());
						System.out.println("---------> Possui: " + origem.getNumJogadoresCasa() + " jogadores na casa");
					}*/
					
					System.out.println("Digite o indice da casa de destino do jogador");
					int indiceDestino2 = entrada.nextInt();
					if(indiceDestino2 < 40){
						destino = bancoImobiliario.tabuleiroJogo.getCasaPeloIndice(indiceDestino2);
						System.out.println("---------> Nome da casa origem: " + destino.getNome());
						System.out.println("---------> Possui: " + destino.getNumJogadoresCasa() + " jogadores na casa");
					}
					
					System.out.println("Digite o id do jogador que vai se mover");
					int id2 = entrada.nextInt();
					
					if(id2 < 5){
						System.out.println("passou no if");
						Jogador jogador2 = bancoImobiliario.tabuleiroJogo.getJogadorASerMovido(id2);
						Casa origem2 = bancoImobiliario.tabuleiroJogo.getCasaPeloIndice(jogador2.getPosicaoJogador());
						System.out.println(jogador2.getNome());
						System.out.println(jogador2.getSaldo());
					
					bancoImobiliario.tabuleiroJogo.moverJogador(jogador2, 10);
					}
					System.out.println("=============================================");
					
					break;

			default:
				break;
			}
			
		}
		
		
		/*new CriarTabuleiro(10, 10);*/
		
	}

}























