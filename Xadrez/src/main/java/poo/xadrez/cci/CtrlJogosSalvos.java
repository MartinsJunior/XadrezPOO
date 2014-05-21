/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.xadrez.cci;

import java.util.ArrayList;
import poo.xadrez.modelo.cdp.Jogo;
import poo.xadrez.modelo.cdp.JogoCompleto;
import poo.xadrez.modelo.cdp.Tabuleiro;
import poo.xadrez.rn.cgt.AplPrincipal;
import poo.xadrez.rn.cgt.BuscaInfoEmArquivo;
import poo.xadrez.tela.cih.TelaJogosSalvos;

/**
 *
 * @author 20102bsi0138
 */
public class CtrlJogosSalvos {

    BuscaInfoEmArquivo ctrlBusca = new BuscaInfoEmArquivo();
    ArrayList<JogoCompleto> jogosAtuais;

    public void start() {
        TelaJogosSalvos telaJogosSalvos = new TelaJogosSalvos();
    }

    public ArrayList<JogoCompleto> busca() {
        this.jogosAtuais = ctrlBusca.buscaJogos();
        return ctrlBusca.buscaJogos();
    }

    private int indiceJogoAtual(String nomeJogo) {

        int indice=0;
        for (JogoCompleto jogoCompleto : jogosAtuais) {
            if (jogoCompleto.getNomeJogo().equals(nomeJogo)) {
                return indice;
            }
            indice++;
        }

        return 0;
    }

    public void recomecaJogo(String nomeJogo) {
        int indiceJogoAtual = indiceJogoAtual(nomeJogo);
        Jogo jogoAtual = jogosAtuais.get(indiceJogoAtual).getJogo();
        Tabuleiro tabuleiro = jogosAtuais.get(indiceJogoAtual).getTabuleiro();
        int vezJogador = jogosAtuais.get(indiceJogoAtual).getVezJogador();
        CtrlPainelPrincipal ctrlPainelPrincipal = new CtrlPainelPrincipal(jogoAtual,tabuleiro,vezJogador);
        ctrlPainelPrincipal.iniciarJogo();
    }

    public boolean deletaJogo(String nomeJogoAtual) {
       return ctrlBusca.deletaJogo(nomeJogoAtual);
    }
}
