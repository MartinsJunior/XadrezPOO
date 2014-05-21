/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.xadrez.rn.cgt;

import java.util.ArrayList;
import poo.xadrez.bd.cgd.RegistraEmArquivo;
import poo.xadrez.modelo.cdp.JogoCompleto;

/**
 *
 * @author 20102bsi0138
 */
public class BuscaInfoEmArquivo {
 
    RegistraEmArquivo ctrlRegistro = new RegistraEmArquivo();
    
    public ArrayList<JogoCompleto> buscaJogos(){
         return ctrlRegistro.buscaPartida();
    }

    public boolean deletaJogo(String nomeJogoAtual) {
        System.out.println(nomeJogoAtual);
        return ctrlRegistro.deletaJogo(nomeJogoAtual);
    }
    
}
