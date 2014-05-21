package poo.xadrez.modelo.cdp;

import poo.xadrez.modelo.cdp.movimento.AndarDiagonais;
import poo.xadrez.modelo.cdp.movimento.AndarHorizontal;
import poo.xadrez.modelo.cdp.movimento.AndarVertical;

public class Rainha extends Peca {

    public Rainha(int linha, int coluna, CorPeca cor) {
        this.tipoPeca = TipoPeca.RAINHA;
        this.posicao = new Posicao(linha, coluna);
        this.cor = cor;
        this.movimentos.add(new AndarDiagonais());
        this.movimentos.add(new AndarVertical());
        this.movimentos.add(new AndarHorizontal());
        this.valorEmPontos = 9;
    }
}
