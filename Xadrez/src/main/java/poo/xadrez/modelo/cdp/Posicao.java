package poo.xadrez.modelo.cdp;

import java.io.Serializable;

public class Posicao implements Serializable{

    protected int linha;
    protected int coluna;

    public Posicao(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
    }

    public Posicao getPos() {
        return this;
    }

    public int getLinha() {
        return linha;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }

    public int getColuna() {
        return coluna;
    }

    public void setColuna(int coluna) {
        this.coluna = coluna;
    }

    public void imprime() {
        System.out.println("Linha-> " + this.linha + " Coluna -> " + this.coluna);
    }

    public boolean compara(Posicao pInicial) {
        return (pInicial.getLinha() == this.getLinha() && pInicial.getColuna() == this.getColuna());
    }
}
