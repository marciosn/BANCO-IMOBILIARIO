package br.ufc.es.com.BancoImb.interfaces;

import java.util.List;

import jplay.Mouse;
import br.ufc.es.com.BancoImb.model.CasaDoTabuleiro;
import br.ufc.es.com.BancoImb.model.Jogador;

public interface IDesenhaComponentes {
	public void instanciaObjetos();
	public void desenhaPecasNoTabuleiro(List<CasaDoTabuleiro> tabuleiro);
	public void atualizaTabuleiro();
	public void exibeLogradourosDoJogador(Jogador jogador);
	public void desenhaBotaoDados();
	public void moverPecaJogador(Jogador jogador);
	public void ativaBotaoPortifolio(Mouse mouse, List<Jogador> jogadores);
	public void desenhaBotaoPortifolio();
	public String inputDigiteONomeDoJogador(int id);
	public String inputEntradaDados(Jogador jogador);
	public int inputRepostaDoJogadorSobreCompraLogradouro(String nomeLogradouro);
	public void messageJogadorNaoPossuiSaldo(Jogador jogador, List<Jogador> jogadoresAindaJogando);
	public void messageExisteUmCampeao(List<Jogador> jogadoresAindaJogando);
	public void messageNumeroDeEntradaDadosInvalido();
	public void messageNomeInvalido();
	public void messageInputVazio();
	public void messageJogadorEstaPreso(Jogador jogador);
	public void messageJogadorDaVez(Jogador jogador);
	public void messageLucrosDividendos(Jogador jogador, float lucrosDividendos);
	public void messageImpostoDeRenda(Jogador jogador, float imposto);
	public void messageParadaLivre(Jogador jogador);
	public void messageCasaDePartida(Jogador jogador, float bonus);
	public void messageJogadorComprouLogradouro(Jogador jogador, String nomeLogradouro);
	public void messageJogadorPagouTaxa(Jogador jogador, Jogador proprietario);
	public void messageSorte(Jogador jogador, float sorteValor);
	public void messageReves(Jogador jogador, float revesValor);
	public void messageNaoPossuiSaldoParaComprar();
	public void messageACasaJaESua();
	public void messageCasaVaParaPrisa(Jogador jogador);
	public void messageVoceParouNaPrisao(Jogador jogador);
	public void messageVaPara(CasaDoTabuleiro destino);

}
