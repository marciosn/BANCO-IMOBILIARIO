package br.com.testandoAPLICACAO;

import br.com.ufc.es.BancoImb.control.BancoImobiliario;
import br.com.ufc.es.BancoImb.model.ContaBancaria;
import br.com.ufc.es.BancoImb.model.Jogador;
import br.com.ufc.es.BancoImb.model.Tabuleiro;

public class TestandoTabuleiro {
	public static void main(String[] args) {
		
		int id = 3;
		Jogador jogador = null;

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

		bancoImobiliario.adicionarJogadoresNaCasaDePartida(bancoImobiliario
				.getJodagores());

		for (int i = 0; i < bancoImobiliario.getTabuleiroJogo().getTabuleiro()
				.size(); i++) {

			System.out.println(bancoImobiliario.getTabuleiroJogo()
					.getTabuleiro().get(i).getNome()
					+ " | "
					+ i
					+ " | "
					+ "jogadores na casa: "
					+ bancoImobiliario.getTabuleiroJogo().getTabuleiro().get(i)
							.getNumJogadoresCasa());
			for (Jogador jog : bancoImobiliario.getTabuleiroJogo()
					.getTabuleiro().get(i).getJogadoresNaCasa()) {

				if (jog.getID() == id) {

					jogador = jog;

					System.out.println("o jogador na com id " + jog.getID()
							+ " é o jogador de nome " + jog.getNome());

				}

			}
		}
		
		
		System.out.println(bancoImobiliario.getTabuleiroJogo().calculaIndiceProximaCasa(34, 12));
		
	}

}
