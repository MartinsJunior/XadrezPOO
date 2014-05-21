/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.xadrez.modelo.cdp;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Junior
 */
public interface PecaInterface extends Serializable {
    public boolean verificaMovimentoValido(Tabuleiro tabuleiro, Posicao p_inicial, Posicao p_final);
    public ArrayList<Posicao> movimentosValidos(Tabuleiro tabuleiro, Posicao p_inicial, Posicao p_final);
    public boolean contemPosicao(ArrayList<Posicao> validos, Posicao posicao);
    public void imprime(ArrayList<Posicao> movimentosValidos);
    public boolean verificaCapitura(Tabuleiro tabuleiro, Posicao posicaoInicial, Posicao posicaoFinal, Posicao pAtual);
}
