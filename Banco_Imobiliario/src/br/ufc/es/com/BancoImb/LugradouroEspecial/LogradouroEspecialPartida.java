package br.ufc.es.com.BancoImb.LugradouroEspecial;

import java.awt.Point;

import br.ufc.es.com.BancoImb.interfaces.IEfeitoCasa;
import br.ufc.es.com.BancoImb.model.Jogador;
import br.ufc.es.com.BancoImb.model.LogradouroEspecial;
import br.ufc.es.com.BancoImb.utils.Constantes;
import br.ufc.es.com.BancoImb.view.DesenhaComponentesGraficos;

public class LogradouroEspecialPartida extends LogradouroEspecial implements IEfeitoCasa{
	private DesenhaComponentesGraficos desenha;
	private Constantes constante;

	public LogradouroEspecialPartida(String nome, Point posicao) {
		super(nome, posicao);
		desenha = new DesenhaComponentesGraficos();
		constante = new Constantes();
	}

	@Override
	public void ativarEfeito(Jogador jogador) {
		jogador.receberTaxa(200);
		desenha.messageCasaDePartida(jogador, constante.BONUS_CADA_DE_PARTIDA);
	}

}
