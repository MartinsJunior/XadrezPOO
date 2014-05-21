/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.xadrez.cci;

import poo.xadrez.modelo.cdp.CorPeca;
import poo.xadrez.modelo.cdp.Jogador;
import poo.xadrez.modelo.cdp.Jogo;
import poo.xadrez.tela.cih.TelaJogadores;
import poo.xadrez.tela.cih.TelaPrincialTabuleiro;

/**
 *
 * @author Junior
 */
public class CtrlTelaJogadores {
    
    private TelaJogadores telaJogadores; 
    private CtrlPainelPrincipal ctrlPainelPrincipal;
    public void start(){
        telaJogadores = new TelaJogadores(this);
        telaJogadores.setVisible(true);
    }
    
    public void iniciarJogo (String nomePrimeiroJogador, String nomeSegundoJogador)
    {
        Jogador jogadorBranco = new Jogador(nomePrimeiroJogador, CorPeca.BRANCO);
        Jogador jogadorPreto = new Jogador(nomeSegundoJogador, CorPeca.PRETO);
        
        Jogo novojogo = new Jogo(jogadorBranco, jogadorPreto);
        
        telaJogadores.dispose();
        
        ctrlPainelPrincipal = new CtrlPainelPrincipal(novojogo);
        ctrlPainelPrincipal.iniciarJogo();
        
    }

    
    
    public void buscaPartida() {
        ctrlPainelPrincipal = new CtrlPainelPrincipal(null);
        
        ctrlPainelPrincipal.buscaPartida();
    }
    
}
