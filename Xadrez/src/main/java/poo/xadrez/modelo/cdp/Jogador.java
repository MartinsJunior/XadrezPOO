package poo.xadrez.modelo.cdp;

import java.io.Serializable;

public class Jogador implements Serializable{

    private String nome;
    private int pontuacao;

    public Jogador(String nome, CorPeca cor) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }
}
