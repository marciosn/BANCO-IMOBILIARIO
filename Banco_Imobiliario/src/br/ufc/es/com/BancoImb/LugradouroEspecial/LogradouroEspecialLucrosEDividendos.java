package br.ufc.es.com.BancoImb.LugradouroEspecial;

import java.awt.Point;

import javax.swing.JOptionPane;

import br.ufc.es.com.BancoImb.constantes.Constantes;
import br.ufc.es.com.BancoImb.interfaces.IEfeitoCasa;
import br.ufc.es.com.BancoImb.model.Jogador;
import br.ufc.es.com.BancoImb.model.LogradouroEspecial;
import br.ufc.es.com.BancoImb.view.DesenhaComponentesGraficos;

public class LogradouroEspecialLucrosEDividendos extends LogradouroEspecial implements IEfeitoCasa{
	private DesenhaComponentesGraficos desenha;
	private Constantes constante;

	public LogradouroEspecialLucrosEDividendos(String nome, Point posicao) {
		super(nome, posicao);
		desenha = new DesenhaComponentesGraficos();
		constante = new Constantes();
	}

	@Override
	public void ativarEfeito(Jogador jogador) {
		jogador.receberTaxa(constante.LUCROS_DIVIDENDOS);
		desenha.messageLucrosDividendos(jogador, constante.LUCROS_DIVIDENDOS);		
	}

}
