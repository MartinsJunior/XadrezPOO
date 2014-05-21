/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.xadrez.bd.cgd;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import poo.xadrez.modelo.cdp.JogoCompleto;
import poo.xadrez.modelo.cdp.Tabuleiro;

/**
 *
 * @author Junior
 */
public class RegistraEmArquivo {
    
    
    
    private boolean escreveJogoNoArquivo(ArrayList<JogoCompleto> listaJogo, JogoCompleto jogoCompleto) {
        try {
            listaJogo.add(jogoCompleto);
            FileOutputStream out = new FileOutputStream("BD");
            ObjectOutputStream objOut = new ObjectOutputStream(out);
            objOut.writeObject(listaJogo);
            return true;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RegistraEmArquivo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RegistraEmArquivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    private boolean deletaJogoNoArquivo(String nomeJogo) {
        try {
            int contador = 0;
            ArrayList<JogoCompleto> listaJogoAtt = lerArquivo();
            for (JogoCompleto jogoCompletoAux : listaJogoAtt) {
                if (jogoCompletoAux.getNomeJogo().equals(nomeJogo)) {
                    break;
                }
                contador++;
            }
            listaJogoAtt.remove(contador);
            FileOutputStream out = new FileOutputStream("BD");
            ObjectOutputStream objOut = new ObjectOutputStream(out);
            objOut.writeObject(listaJogoAtt);
            return true;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RegistraEmArquivo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RegistraEmArquivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    private ArrayList<JogoCompleto> lerArquivo() {
        
        ArrayList<JogoCompleto> listaJogoCompleto = new ArrayList<JogoCompleto>();

        if (new File("BD").exists() == true) {
            try {
                FileInputStream inJogoCompleto = new FileInputStream("BD");
                ObjectInputStream objInJogoCompleto = new ObjectInputStream(inJogoCompleto);
                listaJogoCompleto = (ArrayList<JogoCompleto>) objInJogoCompleto.readObject();
                return listaJogoCompleto;
            } catch (FileNotFoundException ex) {
                Logger.getLogger(RegistraEmArquivo.class
                        .getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(RegistraEmArquivo.class
                        .getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(RegistraEmArquivo.class
                        .getName()).log(Level.SEVERE, null, ex);
            }

        }
        return listaJogoCompleto;
    }

    public boolean saveTabuleiro(JogoCompleto jogoCompleto){
        ArrayList<JogoCompleto> listaJogoAtt = lerArquivo();
        return escreveJogoNoArquivo(listaJogoAtt, jogoCompleto);
    }
    public ArrayList<JogoCompleto> buscaPartida(){
        return lerArquivo();
    }

    public boolean deletaJogo(String nomeJogoAtual) {
        return deletaJogoNoArquivo(nomeJogoAtual);
       
    }

}
