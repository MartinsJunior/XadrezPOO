/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.xadrez.modelo.cdp.movimento;

import java.util.ArrayList;
import poo.xadrez.modelo.cdp.Peca;
import poo.xadrez.modelo.cdp.Posicao;
import poo.xadrez.modelo.cdp.Tabuleiro;

/**
 *
 * @author Junior
 */
public class AndarDoRei implements Movimento {

    public ArrayList<Posicao> validarMovimento(Tabuleiro tabuleiro, Posicao posicaoInicial, Posicao posicaoFinal, Peca peca) {
        int linhaInicial = posicaoInicial.getLinha();
        int colunaInicial = posicaoInicial.getColuna();
        ArrayList<Posicao> validos = new ArrayList<Posicao>();



        //uma posiçao pra direita
        Posicao direita = new Posicao(linhaInicial, colunaInicial + 1);
        if (colunaInicial < 8 && tabuleiro.getPeca(direita) == null) {
            validos.add(direita);
        } else {
            if (peca.verificaCapitura(tabuleiro, posicaoInicial, posicaoFinal, direita)) {
                validos.add(posicaoFinal);
            }
        }
        //uma posição pra esquerda
        Posicao esquerda = new Posicao(linhaInicial, colunaInicial - 1);
        if (colunaInicial > 1 && tabuleiro.getPeca(esquerda) == null) {
            validos.add(esquerda);
        } else {
            if (peca.verificaCapitura(tabuleiro, posicaoInicial, posicaoFinal, esquerda)) {
                validos.add(posicaoFinal);
            }
        }
        //uma posição pra cima
        Posicao top = new Posicao(linhaInicial - 1, colunaInicial);
        if (linhaInicial > 1 && tabuleiro.getPeca(top) == null) {
            validos.add(top);
        } else {
            if (peca.verificaCapitura(tabuleiro, posicaoInicial, posicaoFinal, top)) {
                validos.add(posicaoFinal);
            }
        }
        //uma posição pra baixo
        Posicao down = new Posicao(linhaInicial + 1, colunaInicial);
        if (linhaInicial < 8 && tabuleiro.getPeca(down) == null) {
            validos.add(down);
        } else {
            if (peca.verificaCapitura(tabuleiro, posicaoInicial, posicaoFinal, down)) {
                validos.add(posicaoFinal);
            }
        }
        //diagonal direita superior
        Posicao diagonalDireitaSuperior = new Posicao(linhaInicial - 1, colunaInicial + 1);
        if (colunaInicial < 8 && linhaInicial > 1 && tabuleiro.getPeca(diagonalDireitaSuperior) == null) {
            validos.add(diagonalDireitaSuperior);
        } else {
            if (peca.verificaCapitura(tabuleiro, posicaoInicial, posicaoFinal, diagonalDireitaSuperior)) {
                validos.add(posicaoFinal);
            }
        }
        //diagonal esquerda superior
        Posicao diagonalEsquerdaSuperior = new Posicao(linhaInicial - 1, colunaInicial - 1);
        if (linhaInicial > 1 && colunaInicial > 1 && tabuleiro.getPeca(diagonalEsquerdaSuperior) == null) {
            validos.add(diagonalEsquerdaSuperior);
        } else {
            if (peca.verificaCapitura(tabuleiro, posicaoInicial, posicaoFinal, diagonalEsquerdaSuperior)) {
                validos.add(posicaoFinal);
            }
        }
        //diagonal inferior direita
        Posicao diagonalInferiorDireita = new Posicao(linhaInicial + 1, colunaInicial + 1);
        if (linhaInicial < 8 && colunaInicial < 8 && tabuleiro.getPeca(diagonalInferiorDireita) == null) {
            validos.add(diagonalInferiorDireita);
        } else {
            if (peca.verificaCapitura(tabuleiro, posicaoInicial, posicaoFinal, diagonalInferiorDireita)) {
                validos.add(posicaoFinal);
            }
        }
        //diagonal inferior esquerda
        Posicao diagonalInferiorEsquerda = new Posicao(linhaInicial + 1, colunaInicial - 1);
        if (linhaInicial < 8 && colunaInicial > 1 && tabuleiro.getPeca(diagonalInferiorEsquerda) == null) {
            validos.add(diagonalInferiorEsquerda);
        } else {
            if (peca.verificaCapitura(tabuleiro, posicaoInicial, posicaoFinal, diagonalInferiorEsquerda)) {
                validos.add(posicaoFinal);
            }
        }

        return validos;
    }
}
