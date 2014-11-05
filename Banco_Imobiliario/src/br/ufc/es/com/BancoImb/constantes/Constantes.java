package br.ufc.es.com.BancoImb.constantes;

import java.io.File;

import br.ufc.es.com.BancoImb.tabuleiro.Tabuleiro;

public class Constantes {
	//cenario
	public final String CENARIO = "resources" + File.separator + "cenario" + File.separator + "scene2.scn";
	
	//imagens
	public final String TRISTE = "resources" + File.separator + "img" + File.separator + "sad.png";
	public final String TROFEU = "resources" + File.separator + "img" + File.separator + "win.png";
	public final String FORA_DO_JOGO = "resources" + File.separator + "img" + File.separator + "dead.png";
	public final String PORTFOLIO = "resources" + File.separator + "img" + File.separator + "portfolio.png";
	public final String DADOS = "resources" + File.separator + "img" + File.separator + "dado.png";
	public final String MOUSE = "resources" + File.separator + "img" + File.separator + "mouse.png";
	public final String FELIZ = "resources" + File.separator + "img" + File.separator + "happy.png";	
	public final String PATH_IMAGE = "resources" + File.separator + "img" + File.separator;
	
	//audio
	public final String CHAMPIONS = "resources" + File.separator + "audio" + File.separator + "champions.wav";
	public final String CAIXINHA = "resources" + File.separator + "audio" + File.separator + "caixinha.wav";

	//utils
	public final int QUANTIDADE_jOGADORES = 2;
	public final int INDICE_DA_CASA_DE_PARTIDA = 0;
	public final int JOGADOR_NA_PRIMEIRA_POSICAO_DA_LISTA = 0;
	public final int QUANTIDADE_DE_CASAS_DO_TABULEIRO = 40;
	public final String PECA = "peca";
	public final String FORMATO_IMAGEM = ".png";
	public final int ESPACAMENTO_HORIZONTAL = 20;
	
	//instancias
	private Tabuleiro tabuleiro;

	public Tabuleiro getTabuleiro() {
		return tabuleiro;
	}

	public void setTabuleiro(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
	}
	
	

}
