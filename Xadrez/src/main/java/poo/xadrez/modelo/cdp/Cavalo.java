package poo.xadrez.modelo.cdp;

import poo.xadrez.modelo.cdp.movimento.AndarEmL;

public class Cavalo extends Peca {

    public Cavalo(int linha, int coluna, CorPeca cor) {
        this.tipoPeca = TipoPeca.CAVALO;
        this.posicao = new Posicao(linha, coluna);
        this.cor = cor;
        this.movimentos.add(new AndarEmL());
        this.valorEmPontos = 3;
    }

}
