/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.xadrez.modelo.cdp;

import java.io.Serializable;
import java.util.Date;
import poo.xadrez.tela.cih.TelaPrincialTabuleiro;

/**
 *
 * @author Junior
 */
public class JogoCompleto implements Serializable{

    
    
    
    Tabuleiro tabuleiro;
    Jogo jogo;
    String nomeJogo;
    int vezJogador; //isso aqui é uma gambiarra.
    String data;

    


    public JogoCompleto(Tabuleiro tabuleiro, Jogo jogo,String nomeJogo, int vezJogador,String data) {
        this.tabuleiro = tabuleiro;
        this.jogo = jogo;
        this.nomeJogo = nomeJogo;
        this.vezJogador = vezJogador;
        this.data = data;
    }
    
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
    public int getVezJogador() {
        return vezJogador;
    }

    public void setVezJogador(int vezJogador) {
        this.vezJogador = vezJogador;
    }
    
    public String getNomeJogo() {
        return nomeJogo;
    }

    public void setNomeJogo(String nomeJogo) {
        this.nomeJogo = nomeJogo;
    }

    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }

    public void setTabuleiro(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    public Jogo getJogo() {
        return jogo;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }

    
}
