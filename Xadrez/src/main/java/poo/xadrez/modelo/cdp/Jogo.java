package poo.xadrez.modelo.cdp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Jogo implements Serializable{
    private List<Jogador> jogador = new ArrayList<Jogador>();
    public Jogo(Jogador jogadorBranco ,Jogador jogadorPreto) {
        this.jogador.add(jogadorBranco);
        this.jogador.add(jogadorPreto);
        
    }
    public Jogador getJogador(int indice) {
        return jogador.get(indice);
    }
    public void setJogador(List<Jogador> jogador) {
        this.jogador = jogador;
    }
}
