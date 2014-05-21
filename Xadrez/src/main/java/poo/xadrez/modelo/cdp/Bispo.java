package poo.xadrez.modelo.cdp;

import poo.xadrez.modelo.cdp.movimento.AndarDiagonais;

public class Bispo extends Peca {

    public Bispo(int linha, int coluna, CorPeca cor) {
        this.tipoPeca = tipoPeca.BISPO;
        this.posicao = new Posicao(linha, coluna);
        this.cor = cor;
        this.movimentos.add(new AndarDiagonais());
        this.valorEmPontos = 3;
    }
}
