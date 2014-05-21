/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.xadrez.modelo.cdp.movimento;

import java.io.Serializable;
import java.util.ArrayList;
import poo.xadrez.modelo.cdp.Peca;
import poo.xadrez.modelo.cdp.Posicao;
import poo.xadrez.modelo.cdp.Tabuleiro;

/**
 *
 * @author Junior
 */
public interface Movimento extends Serializable {
    
    public ArrayList<Posicao> validarMovimento(Tabuleiro tabuleiro,Posicao posicaoInicial, Posicao posicaoFinal, Peca peca);
}
