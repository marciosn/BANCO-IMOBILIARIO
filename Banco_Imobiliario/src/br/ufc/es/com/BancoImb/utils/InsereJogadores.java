package br.ufc.es.com.BancoImb.utils;

import java.awt.image.ReplicateScaleFilter;
import java.util.List;

import br.ufc.es.com.BancoImb.model.CasaDoTabuleiro;
import br.ufc.es.com.BancoImb.model.ContaBancaria;
import br.ufc.es.com.BancoImb.model.Jogador;
import br.ufc.es.com.BancoImb.model.PecaJogador;
import br.ufc.es.com.BancoImb.repositorios.Repositorio;
import br.ufc.es.com.BancoImb.tabuleiro.Tabuleiro;
import br.ufc.es.com.BancoImb.view.DesenhaComponentesGraficos;

public class InsereJogadores {
	private Constantes constante;
	private DesenhaComponentesGraficos desenha;
	private VerificacoesDeLogicaDoJogo verifica;
	private Repositorio repo;
	private List<CasaDoTabuleiro> tabuleiro;
	
	public InsereJogadores(Repositorio repositorio) {
		constante = new Constantes();
		desenha = new DesenhaComponentesGraficos();
		verifica = new VerificacoesDeLogicaDoJogo();
		tabuleiro = repositorio.getTabuleiro();
		repo = repositorio;
	}
	
	public void inserirJogador() {
		for (int i = 0; i < constante.QUANTIDADE_jOGADORES;) {
			String nomeJogador = desenha.inputDigiteONomeDoJogador(i);
			if(verifica.verificaNomeIsValido(nomeJogador)){
				String peca = constante.PECA + repo.getJogadores().size() + constante.FORMATO_IMAGEM;
				repo.adicionaJogador(new Jogador(nomeJogador,
						new ContaBancaria(500), 
						new PecaJogador(constante.PATH_IMAGE + peca)));
		i++;
			}else
			desenha.messageNomeInvalido();
		}
		repo.adicionaListaDeJogadoresNaCasaDePartida();
	}
}
