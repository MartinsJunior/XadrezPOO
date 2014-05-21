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
public class AndarVertical implements Movimento {

    public ArrayList<Posicao> validarMovimento(Tabuleiro tabuleiro, Posicao posicaoInicial, Posicao posicaoFinal, Peca peca) {

        int linhaInicial = posicaoInicial.getLinha();
        int colunaInicial = posicaoInicial.getColuna();
        ArrayList<Posicao> posicoesValidas = new ArrayList<Posicao>();
         // andar para baixo
        for (int contadorLinha = linhaInicial + 1; contadorLinha < 9; contadorLinha++) {
            Posicao pAtual = new Posicao(contadorLinha, colunaInicial);
            if (tabuleiro.getPeca(pAtual) == null) {
                posicoesValidas.add(pAtual);
            } else {
                if (peca.verificaCapitura(tabuleiro, posicaoInicial, posicaoFinal, pAtual)) {
                    posicoesValidas.add(posicaoFinal);
                } else {
                    break;
                }
            }
        }
        // andar para cima
        for (int contadorLinha = linhaInicial - 1; contadorLinha > 0; contadorLinha--) {
            Posicao posicaoAtual = new Posicao(contadorLinha, colunaInicial);
            if (tabuleiro.getPeca(posicaoAtual) == null) {
//                System.out.print("PraCima----->>");
//                posicaoAtual.imprime();
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
