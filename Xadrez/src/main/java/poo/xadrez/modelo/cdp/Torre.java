package poo.xadrez.modelo.cdp;

import poo.xadrez.modelo.cdp.movimento.AndarVertical;
import poo.xadrez.modelo.cdp.movimento.AndarHorizontal;

public class Torre extends Peca {

    public Torre(int linha, int coluna, CorPeca cor) {
        this.tipoPeca = TipoPeca.TORRE;
        this.posicao = new Posicao(linha, coluna);
        this.cor = cor;
        this.movimentos.add(new AndarVertical());
        this.movimentos.add(new AndarHorizontal());
        this.valorEmPontos = 5;

    }
}
