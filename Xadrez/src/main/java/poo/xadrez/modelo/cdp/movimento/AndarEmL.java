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
public class AndarEmL implements Movimento {

    public ArrayList<Posicao> validarMovimento(Tabuleiro tabuleiro, Posicao posicaoInicial, Posicao posicaoFinal, Peca peca) {

        int linhaInicial = posicaoInicial.getLinha();
        int colunaInicial = posicaoInicial.getColuna();
        ArrayList<Posicao> validos = new ArrayList<Posicao>();

        //diagonal direita superior
//        adicionaValidostabuleiro, p_inicial, p_final, 2, 8);
        Posicao diagonalDireitaSuperior = new Posicao(linhaInicial - 2, colunaInicial + 1);
        if (linhaInicial > 2 && colunaInicial < 8 && tabuleiro.getPeca(diagonalDireitaSuperior) == null) {
            validos.add(diagonalDireitaSuperior);
        } else {
            if (peca.verificaCapitura(tabuleiro, posicaoInicial, posicaoFinal, diagonalDireitaSuperior)) {
                validos.add(diagonalDireitaSuperior);
            }
        }
        //diagonal direita superior inferior
        Posicao diagonalDireitaSuperiorInferior = new Posicao(linhaInicial - 1, colunaInicial + 2);
        if (linhaInicial > 2 && colunaInicial < 7 && tabuleiro.getPeca(diagonalDireitaSuperiorInferior) == null) {
            validos.add(diagonalDireitaSuperiorInferior);
        } else {
            if (peca.verificaCapitura(tabuleiro, posicaoInicial, posicaoFinal, diagonalDireitaSuperiorInferior)) {
                validos.add(posicaoFinal);
            }
        }
        //diagonal esquerda superior
        Posicao diagonalEsquerdaSuperior = new Posicao(linhaInicial - 2, colunaInicial - 1);
        if (linhaInicial > 2 && colunaInicial > 1 && tabuleiro.getPeca(diagonalEsquerdaSuperior) == null) {
            validos.add(diagonalEsquerdaSuperior);
        } else {
            if (peca.verificaCapitura(tabuleiro, posicaoInicial, posicaoFinal, diagonalEsquerdaSuperior)) {
                validos.add(posicaoFinal);
            }
        }
        //diagonal esquerda superior inferior
        Posicao diagonalEsquerdaSuperiorInferior = new Posicao(linhaInicial - 1, colunaInicial - 2);
        if (linhaInicial > 1 && colunaInicial > 2 && tabuleiro.getPeca(diagonalEsquerdaSuperiorInferior) == null) {
            validos.add(diagonalEsquerdaSuperiorInferior);
        } else {
            if (peca.verificaCapitura(tabuleiro, posicaoInicial, posicaoFinal, diagonalEsquerdaSuperiorInferior)) {
                validos.add(posicaoFinal);
            }
        }
        //diagonal direita inferior superior
        Posicao diagonalDireitaInferiorSuperior = new Posicao(linhaInicial + 1, colunaInicial + 2);
        if (linhaInicial < 8 && colunaInicial < 7 && tabuleiro.getPeca(diagonalDireitaInferiorSuperior) == null) {
            validos.add(diagonalDireitaInferiorSuperior);
        } else {
            if (peca.verificaCapitura(tabuleiro, posicaoInicial, posicaoFinal, diagonalDireitaInferiorSuperior)) {
                validos.add(posicaoFinal);
            }
        }
        //diagonal direita inferior
        Posicao diagonalDireitaInferior = new Posicao(linhaInicial + 2, colunaInicial + 1);
        if (linhaInicial < 7 && colunaInicial < 8 && tabuleiro.getPeca(diagonalDireitaInferior) == null) {
            validos.add(diagonalDireitaInferior);
        } else {
            if (peca.verificaCapitura(tabuleiro, posicaoInicial, posicaoFinal, diagonalDireitaInferior)) {
                validos.add(posicaoFinal);
            }
        }
        //diagonal esquerda inferior 
        Posicao diagonalEsquerdaInferior = new Posicao(linhaInicial + 2, colunaInicial - 1);
        if (linhaInicial < 7 && colunaInicial > 1 && tabuleiro.getPeca(diagonalEsquerdaInferior) == null) {
            validos.add(diagonalEsquerdaInferior);
        } else {
            if (peca.verificaCapitura(tabuleiro, posicaoInicial, posicaoFinal, diagonalEsquerdaInferior)) {
                validos.add(posicaoFinal);
            }
        }
        //diagonal esquerda inferior superior
        Posicao diagonalEsquerdaInferiorSuperior = new Posicao(linhaInicial + 1, colunaInicial - 2);
        if (linhaInicial < 8 && colunaInicial > 2 && tabuleiro.getPeca(diagonalEsquerdaInferiorSuperior) == null) {
            validos.add(diagonalEsquerdaInferiorSuperior);
        } else {
            if (peca.verificaCapitura(tabuleiro, posicaoInicial, posicaoFinal, diagonalEsquerdaInferiorSuperior)) {
                validos.add(posicaoFinal);
            }
        }
        return validos;
    }
}
