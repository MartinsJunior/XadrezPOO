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
public class AndarHorizontal implements Movimento {

    public ArrayList<Posicao> validarMovimento(Tabuleiro tabuleiro, Posicao posicaoInicial, Posicao posicaoFinal, Peca peca) {

        int linhaInicial = posicaoInicial.getLinha();
        int colunaInicial = posicaoInicial.getColuna();
        ArrayList<Posicao> posicoesValidas = new ArrayList<Posicao>();
        // andar para direita
        for (int contadorColuna = colunaInicial + 1; contadorColuna < 9; contadorColuna++) {
            Posicao posicaoAtual = new Posicao(linhaInicial, contadorColuna);
            if (tabuleiro.getPeca(posicaoAtual) == null) {
                posicoesValidas.add(posicaoAtual);
            } else {
                if (peca.verificaCapitura(tabuleiro, posicaoInicial, posicaoFinal, posicaoAtual)) {
                    posicoesValidas.add(posicaoFinal);
                } else {
                    break;
                }
            }
        }
        // andar para esquerda
        for (int contadorColuna = colunaInicial - 1; contadorColuna > 0; contadorColuna--) {
            Posicao posicaoAtual = new Posicao(linhaInicial, contadorColuna);
//            posicaoAtual.imprime();
            if (tabuleiro.getPeca(posicaoAtual) == null) {
                posicoesValidas.add(posicaoAtual);
            } else {
                if (peca.verificaCapitura(tabuleiro, posicaoInicial, posicaoFinal, posicaoAtual)) {

                    posicoesValidas.add(posicaoFinal);
                } else {
                    break;
                }
            }
        }
        return posicoesValidas;
    }
}
