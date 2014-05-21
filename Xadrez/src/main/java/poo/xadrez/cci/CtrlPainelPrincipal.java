/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.xadrez.cci;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import poo.xadrez.modelo.cdp.Casa;
import poo.xadrez.modelo.cdp.CorPeca;
import poo.xadrez.modelo.cdp.Jogador;
import poo.xadrez.modelo.cdp.Jogo;
import poo.xadrez.modelo.cdp.Peca;
import poo.xadrez.modelo.cdp.Posicao;
import poo.xadrez.modelo.cdp.Tabuleiro;
import poo.xadrez.modelo.cdp.TipoPeca;
import poo.xadrez.rn.cgt.AplPrincipal;
import poo.xadrez.tela.cih.TelaPrincialTabuleiro;


/**
 *
 * @author Junior
 */
public class CtrlPainelPrincipal extends Imagens {
    
    
    private AplPrincipal aplPrincipal;
    private TelaPrincialTabuleiro telaPrincialTabuleiro;
    private CorPeca corAtual;

    public CtrlPainelPrincipal(Jogo jogo) {
        this.aplPrincipal = new AplPrincipal(jogo);
    
    }
    public CtrlPainelPrincipal(Jogo jogo,Tabuleiro tabuleiro,int vezJogador) {
        this.aplPrincipal = new AplPrincipal(jogo);
        aplPrincipal.setTabuleiro(tabuleiro);
        aplPrincipal.setContadorJogada(vezJogador);
        
    }
    
    
    public void iniciarJogo() {
        telaPrincialTabuleiro = new TelaPrincialTabuleiro(this);

    }

    public boolean verificaCheque() {
        return aplPrincipal.verificaCheque();

    }

    public boolean moverPeca(Posicao posicaoIniPosicao, Posicao posicaoFinal) {


        return aplPrincipal.validarJogada(posicaoIniPosicao, posicaoFinal);
    }

    public void trocaImagemMouse(JFrame janela, JLabel label) {
        Toolkit kit = Toolkit.getDefaultToolkit();
        if (!(janela.getCursor().getName()).equals("Cursor Default")) {
            janela.setCursor(Cursor.DEFAULT_CURSOR);
        } else {
            ImageIcon imagemLabel = (ImageIcon) label.getIcon();
            Point point = new Point(16, 16); // Coordenada do clique em relação à imagem  
            String name = "Cursor de carinha";
            Cursor cursor = kit.createCustomCursor(imagemLabel.getImage(), point, name);
            janela.setCursor(cursor);
        }
    }

    private int nomeToIndice(String nome) {
        int linha;
        int coluna;
        int num = Integer.valueOf(nome);
        linha = num / 10;
        coluna = num % 10;
        return (linha * 8) + coluna - 9;
    }

    private Posicao nomeToPosicao(String nome) {
        int linha;
        int coluna;
        int num = Integer.valueOf(nome);
        linha = num / 10;
        coluna = num % 10;
        Posicao pos = new Posicao(linha, coluna);
        return pos;
    }

    private void movimentaImagem(JPanel painel, int indice_inicial, int indice_final) {
        JLabel inicial = (JLabel) painel.getComponent(indice_inicial);
        Icon auxIcon = inicial.getIcon();
        JLabel destino = (JLabel) painel.getComponent(indice_final);
        destino.setIcon(auxIcon);
        inicial.setIcon(null);
    }

    public void movePeca(JPanel meuPainel, JFrame janela, JLabel lb, ArrayList<Integer> indiceDaJogada, ArrayList<Posicao> posicaoDaJogada) {
        indiceDaJogada.add(nomeToIndice(lb.getName()));
        posicaoDaJogada.add(nomeToPosicao(lb.getName()));
        if (indiceDaJogada.size() >= 2) {
            boolean resposta = moverPeca(posicaoDaJogada.get(0), posicaoDaJogada.get(1));
            if (resposta) {
                movimentaImagem(meuPainel, indiceDaJogada.get(0), indiceDaJogada.get(1));
                indiceDaJogada.removeAll(indiceDaJogada);
                posicaoDaJogada.removeAll(posicaoDaJogada);
                if (aplPrincipal.getRei() == null) {
                    mostraVencedorXequeMate(janela);
                    janela.dispose();
                } else {
                    if (verificaCheque()) {
                        JOptionPane.showMessageDialog(janela, "Xeque!");
                    }
                }
            } else {

                boolean verificaRoqueMenor = false;
                if (indiceDaJogada.get(0) == 60 && indiceDaJogada.get(1) == 62) {
                    System.out.println(indiceDaJogada.get(0));
                    verificaRoqueMenor = aplPrincipal.verificaRoqueMenor(posicaoDaJogada.get(0), posicaoDaJogada.get(1), 8);
                    corAtual = CorPeca.BRANCO;
                } else {
                    if (indiceDaJogada.get(0) == 4 && indiceDaJogada.get(1) == 6) {
                        verificaRoqueMenor = aplPrincipal.verificaRoqueMenor(posicaoDaJogada.get(0), posicaoDaJogada.get(1), 1);
                        corAtual = CorPeca.PRETO;
                    }
                }
                if (verificaRoqueMenor) {
                    if (corAtual.equals(CorPeca.BRANCO)) {
                        movimentaImagem(meuPainel, indiceDaJogada.get(0), indiceDaJogada.get(1));
                        movimentaImagem(meuPainel, 63, 61);
                        indiceDaJogada.removeAll(indiceDaJogada);
                        posicaoDaJogada.removeAll(posicaoDaJogada);
                    } else {
                        movimentaImagem(meuPainel, indiceDaJogada.get(0), indiceDaJogada.get(1));
                        movimentaImagem(meuPainel, 7, 5);
                        indiceDaJogada.removeAll(indiceDaJogada);
                        posicaoDaJogada.removeAll(posicaoDaJogada);
                    }

                } else {
                    boolean verificaRoqueMaior = false;
                    if (indiceDaJogada.get(0) == 60 && indiceDaJogada.get(1) == 57) {
                        System.out.println(indiceDaJogada.get(0));
                        verificaRoqueMaior = aplPrincipal.verificaRoqueMaior(posicaoDaJogada.get(0), posicaoDaJogada.get(1), 8);
                        corAtual = CorPeca.BRANCO;
                    } else {
                        if (indiceDaJogada.get(0) == 4 && indiceDaJogada.get(1) == 1) {
                            verificaRoqueMaior = aplPrincipal.verificaRoqueMaior(posicaoDaJogada.get(0), posicaoDaJogada.get(1), 1);
                            corAtual = CorPeca.PRETO;
                        }
                    }
                    if (verificaRoqueMaior) {
                        if (corAtual.equals(CorPeca.BRANCO)) {
                            movimentaImagem(meuPainel, indiceDaJogada.get(0), indiceDaJogada.get(1));
                            movimentaImagem(meuPainel, 56, 58);
                            indiceDaJogada.removeAll(indiceDaJogada);
                            posicaoDaJogada.removeAll(posicaoDaJogada);
                        } else {
                            movimentaImagem(meuPainel, indiceDaJogada.get(0), indiceDaJogada.get(1));
                            movimentaImagem(meuPainel, 0, 2);
                            indiceDaJogada.removeAll(indiceDaJogada);
                            posicaoDaJogada.removeAll(posicaoDaJogada);
                        }
                    } else {


                        JOptionPane.showMessageDialog(janela, " Você está tentando realizar uma jogada errada\n ou não é a sua vez =D");
                        indiceDaJogada.removeAll(indiceDaJogada);
                        posicaoDaJogada.removeAll(posicaoDaJogada);
                    }
                }
            }
        }
    }

    public void mostraVencedor(JFrame janela) {
        Jogador vencedor = aplPrincipal.getVencedor();
        if (vencedor == null) {
            JOptionPane.showMessageDialog(janela, "O Jogo empatou!");
            janela.dispose();

        } else {
            JOptionPane.showMessageDialog(janela, "O vencedor é " + vencedor.getNome() + " com " + vencedor.getPontuacao() + " pontos");
            janela.dispose();
        }
    }

    private void mostraVencedorXequeMate(JFrame janela) {
        JOptionPane.showMessageDialog(janela, "Parabéns você ganhou!");
        janela.dispose();
    }

    public void ofereceEmpate(JFrame janela) {
        if (JOptionPane.showConfirmDialog(janela, "Deseja acabar o jogo em empate?") == 0) {
            JOptionPane.showMessageDialog(janela, "O Jogo empatou!");
            janela.dispose();
        };

    }

    public boolean salvaJogo(String nomeJogo) {
        return aplPrincipal.salvarJogo(nomeJogo);
    }

    public void buscaPartida() {
        aplPrincipal.buscaPartida();
        iniciarJogo();
    }

    public void preencheTabuleiro(JPanel painel) {
        Tabuleiro tabuleiro = aplPrincipal.getTabuleiro();
        int contadorComponent = 0;
        for (int contadorLinha = 1; contadorLinha < 9; contadorLinha++) {
            for (int contadorColuna = 1; contadorColuna < 9; contadorColuna++) {
                Casa casa = tabuleiro.getCasa("" + contadorLinha + "" + contadorColuna);

                Peca pecaAtual = casa.getPeca();
                JLabel destino = (JLabel) painel.getComponent(contadorComponent);
                if(pecaAtual!=null){
                    if(pecaAtual.getTipoPeca().equals(TipoPeca.TORRE) && pecaAtual.getCor().equals(CorPeca.BRANCO)){
                       destino.setIcon(TORRE_BRANCO); 
                    }else if(pecaAtual.getTipoPeca().equals(TipoPeca.CAVALO) && pecaAtual.getCor().equals(CorPeca.BRANCO)){
                         destino.setIcon(CAVALO_BRANCO);   
                    }else if(pecaAtual.getTipoPeca().equals(TipoPeca.BISPO) && pecaAtual.getCor().equals(CorPeca.BRANCO)){
                         destino.setIcon(BISPO_BRANCO);
                    }else if(pecaAtual.getTipoPeca().equals(TipoPeca.RAINHA) && pecaAtual.getCor().equals(CorPeca.BRANCO)){
                         destino.setIcon(RAINHA_BRANCO);
                    }else if(pecaAtual.getTipoPeca().equals(TipoPeca.REI) && pecaAtual.getCor().equals(CorPeca.BRANCO)){
                         destino.setIcon(REI_BRANCO);
                    }else if(pecaAtual.getTipoPeca().equals(TipoPeca.PEAO) && pecaAtual.getCor().equals(CorPeca.BRANCO)){
                         destino.setIcon(PEAO_BRANCO);
                    }else if(pecaAtual.getTipoPeca().equals(TipoPeca.TORRE) && pecaAtual.getCor().equals(CorPeca.PRETO)){
                         destino.setIcon(TORRE_PRETO);
                    }else if(pecaAtual.getTipoPeca().equals(TipoPeca.CAVALO) && pecaAtual.getCor().equals(CorPeca.PRETO)){
                         destino.setIcon(CAVALO_PRETO);
                    }else if(pecaAtual.getTipoPeca().equals(TipoPeca.BISPO) && pecaAtual.getCor().equals(CorPeca.PRETO)){
                         destino.setIcon(BISPO_PRETO);
                    }else if(pecaAtual.getTipoPeca().equals(TipoPeca.RAINHA) && pecaAtual.getCor().equals(CorPeca.PRETO)){
                         destino.setIcon(RAINHA_PRETO);
                    }else if(pecaAtual.getTipoPeca().equals(TipoPeca.REI) && pecaAtual.getCor().equals(CorPeca.PRETO)){
                         destino.setIcon(REI_PRETO);
                    }else if(pecaAtual.getTipoPeca().equals(TipoPeca.PEAO) && pecaAtual.getCor().equals(CorPeca.PRETO)){
                         destino.setIcon(PEAO_PRETO);
                    }
                }
                contadorComponent++;
            }

        }
    }
}
