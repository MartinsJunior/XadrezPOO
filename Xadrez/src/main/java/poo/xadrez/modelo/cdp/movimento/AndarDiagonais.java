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
public class AndarDiagonais implements Movimento {

    public ArrayList<Posicao> validarMovimento(Tabuleiro tabuleiro, Posicao posicaoInicial, Posicao posicaoFinal, Peca peca) {

        int linhaInicial = posicaoInicial.getLinha();
        int colunaInicial = posicaoInicial.getColuna();
        ArrayList<Posicao> posicoesValidas = new ArrayList<Posicao>();
        // diagonal pra baixo direita
        for (int contadorColuna = colunaInicial + 1, contadorLinha = linhaInicial + 1; contadorColuna < 9 && contadorLinha < 9; contadorColuna++, contadorLinha++) {
            Posicao pAtual = new Posicao(contadorLinha, contadorColuna);
            if (tabuleiro.getPeca(pAtual) == null) {
                posicoesValidas.add(new Posicao(contadorLinha, contadorColuna));
            } else {
                if (peca.verificaCapitura(tabuleiro, posicaoInicial, posicaoFinal, pAtual)) {
                    posicoesValidas.add(posicaoFinal);
                } else {
                    break;
                }
            }
        }
        // diagonal pra baixo esquerda
        for (int contadorColuna = colunaInicial - 1, contadorLinha = linhaInicial + 1; contadorColuna > 0 && contadorLinha < 9; contadorColuna--, contadorLinha++) {
            Posicao pAtual = new Posicao(contadorLinha, contadorColuna);
            if (tabuleiro.getPeca(pAtual) == null) {
                posicoesValidas.add(new Posicao(contadorLinha, contadorColuna));
            } else {
                if (peca.verificaCapitura(tabuleiro, posicaoInicial, posicaoFinal, pAtual)) {
                    posicoesValidas.add(posicaoFinal);
                } else {
                    break;
                }
            }
        }
        //diagonal pra cima direita
        for (int contadorColuna = colunaInicial + 1, contadorLinha = linhaInicial - 1; contadorColuna < 9 && contadorLinha > 0; contadorColuna++, contadorLinha--) {
            Posicao pAtual = new Posicao(contadorLinha, contadorColuna);
            if (tabuleiro.getPeca(pAtual) == null) {
                posicoesValidas.add(new Posicao(contadorLinha, contadorColuna));
            } else {
                if (peca.verificaCapitura(tabuleiro, posicaoInicial, posicaoFinal, pAtual)) {
                    posicoesValidas.add(posicaoFinal);
                } else {
                    break;
                }
            }
        }
        //diagonal pra cima esquerda
        for (int contadorColuna = colunaInicial - 1, contadorLinha = linhaInicial - 1; contadorColuna > 0 && contadorLinha > 0; contadorColuna--, contadorLinha--) {
            Posicao pAtual = new Posicao(contadorLinha, contadorColuna);
            if (tabuleiro.getPeca(pAtual) == null) {
                posicoesValidas.add(new Posicao(contadorLinha, contadorColuna));
            } else {
                if (peca.verificaCapitura(tabuleiro, posicaoInicial, posicaoFinal, pAtual)) {
                    posicoesValidas.add(posicaoFinal);
                } else {
                    break;
                }
            }
        }
        return posicoesValidas;
    }
}
