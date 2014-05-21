/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.xadrez.modelo.cdp.movimento;

import java.util.ArrayList;
import poo.xadrez.modelo.cdp.CorPeca;
import poo.xadrez.modelo.cdp.Peca;
import poo.xadrez.modelo.cdp.Posicao;
import poo.xadrez.modelo.cdp.Tabuleiro;

/**
 *
 * @author Junior
 */
public class AndarPeao implements Movimento {

    public ArrayList<Posicao> validarMovimento(Tabuleiro tabuleiro, Posicao posicaoInicial, Posicao posicaoFinal, Peca peca) {
        ArrayList<Posicao> validos = new ArrayList<Posicao>();
        int linhaInicial = posicaoInicial.getLinha();
        int colunaInicial = posicaoInicial.getColuna();


        if (peca.getCor().equals(CorPeca.BRANCO)) {
            validos.add(new Posicao((linhaInicial - 1), colunaInicial));
            if (posicaoInicial.getLinha() == 7) {
                validos.add(new Posicao((linhaInicial - 2), colunaInicial));
            }
            Posicao diagonalDireitaSuperior = new Posicao(linhaInicial - 1, colunaInicial + 1);
            if (colunaInicial < 8 && linhaInicial > 1 && tabuleiro.getPeca(diagonalDireitaSuperior) != null) {
                if (tabuleiro.getPeca(diagonalDireitaSuperior).getCor().equals(CorPeca.PRETO)) {
                    validos.add(diagonalDireitaSuperior);
                }
            }
            Posicao diagonalEsquerdaSuperior = new Posicao(linhaInicial - 1, colunaInicial - 1);
            if (linhaInicial > 1 && colunaInicial > 1 && tabuleiro.getPeca(diagonalEsquerdaSuperior) != null) {
                if (tabuleiro.getPeca(diagonalEsquerdaSuperior).getCor().equals(CorPeca.PRETO)) {
                    validos.add(diagonalEsquerdaSuperior);
                }
            }

        }
        if (peca.getCor().equals(CorPeca.PRETO)) {
            validos.add(new Posicao((linhaInicial + 1), colunaInicial));
            if (posicaoInicial.getLinha() == 2) {
                validos.add(new Posicao((linhaInicial + 2), colunaInicial));
            }
            Posicao diagonalInferiorDireita = new Posicao(linhaInicial + 1, colunaInicial + 1);
            if (linhaInicial < 8 && colunaInicial < 8 && tabuleiro.getPeca(diagonalInferiorDireita) != null) {
                if (tabuleiro.getPeca(diagonalInferiorDireita).getCor().equals(CorPeca.BRANCO)) {
                    validos.add(diagonalInferiorDireita);
                }
            }
            Posicao diagonalInferiorEsquerda = new Posicao(linhaInicial + 1, colunaInicial - 1);
            if (linhaInicial < 8 && colunaInicial > 1 && tabuleiro.getPeca(diagonalInferiorEsquerda) != null) {
                if (tabuleiro.getPeca(diagonalInferiorEsquerda).getCor().equals(CorPeca.BRANCO)) {
                    validos.add(diagonalInferiorEsquerda);
                }
            }


        }

        return validos;
    }
}
