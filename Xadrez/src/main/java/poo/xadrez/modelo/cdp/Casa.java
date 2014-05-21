package poo.xadrez.modelo.cdp;

import java.io.Serializable;

public class Casa implements Serializable{

    private Posicao posicao;
    private Peca peca = null;

    public Casa(int linha, int coluna, Peca p) {
        this.posicao = new Posicao(linha, coluna);
        this.peca = p;
    }
    public Casa(int linha, int coluna) {
        this.posicao = new Posicao(linha, coluna);
    }
    public Posicao getPosicao() {
        return posicao;
    }
    public void setPosicao(Posicao posicao) {
        this.posicao = posicao;
    }
    public Peca getPeca() {
        return peca;
    }
    public void setPeca(Peca peca) {
        this.peca = peca;
    }
}
