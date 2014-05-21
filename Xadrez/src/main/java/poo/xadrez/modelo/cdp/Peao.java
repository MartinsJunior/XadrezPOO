package poo.xadrez.modelo.cdp;

import poo.xadrez.modelo.cdp.movimento.AndarPeao;
public class Peao extends Peca {
    public Peao(int linha, int coluna, CorPeca cor) {
        this.tipoPeca = TipoPeca.PEAO;
        this.posicao = new Posicao(linha, coluna);
        this.cor = cor;
        this.movimentos.add(new AndarPeao());
        this.valorEmPontos = 1;
    }
}
