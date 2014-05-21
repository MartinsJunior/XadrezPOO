/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.xadrez.cci;

import poo.xadrez.tela.cih.TelaPrincipal;

/**
 *
 * @author Junior
 */
public class CTRLTelaPrincipal {
    
    private TelaPrincipal telaPrincipal;
    private CtrlTelaJogadores ctrlTelaJogadores = new CtrlTelaJogadores();
    private CtrlJogosSalvos ctrlJogosSalvos = new CtrlJogosSalvos();
    public void iniciarPrograma() {
        
        telaPrincipal = new TelaPrincipal(this);
        telaPrincipal.setVisible(true);
    }
    
    public void inicarTelaJogadores()
    {
        telaPrincipal.dispose();
        ctrlTelaJogadores.start();
        
    }

    public void BuscaPartida() {
        ctrlJogosSalvos.start();
//        ctrlTelaJogadores.buscaPartida();
    }
    
}
