/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.xadrez.tela.cih;

/**
 *
 * @author Junior
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.JPanel;
import poo.xadrez.cci.CtrlPainelPrincipal;
import poo.xadrez.modelo.cdp.Casa;
import poo.xadrez.modelo.cdp.Peca;
import poo.xadrez.modelo.cdp.Posicao;
import poo.xadrez.modelo.cdp.Tabuleiro;
import poo.xadrez.rn.cgt.AplPrincipal;

public class TelaPrincialTabuleiro extends JFrame {

    public CtrlPainelPrincipal ctrlPainelPrincipal;

    public TelaPrincialTabuleiro(CtrlPainelPrincipal ctrlPainelPrincipal) {

        this.ctrlPainelPrincipal = ctrlPainelPrincipal;
        initComponents();
        
    }

    private boolean salvaJogo(String nomeJogo) {
        return ctrlPainelPrincipal.salvaJogo(nomeJogo);
    }

         

    private void initComponents() {
        final ArrayList<Integer> indiceDaJogada = new ArrayList<Integer>();
        final ArrayList<Posicao> posicaoDaJogada = new ArrayList<Posicao>();
        final JFrame janela = new JFrame("Tabuleiro Xadrez");

        janela.addKeyListener(
                new KeyListener() {
            public void keyTyped(KeyEvent ke) {
            }

            public void keyPressed(KeyEvent ke) {
                if (ke.getKeyCode() == KeyEvent.VK_F1) {
                    ctrlPainelPrincipal.mostraVencedor(janela);
                } else {
                    if (ke.getKeyCode() == KeyEvent.VK_F2) {
                        ctrlPainelPrincipal.ofereceEmpate(janela);
                    } else {

                        if (ke.getKeyCode() == KeyEvent.VK_F3) {
                            
                                String nomeJogo = JOptionPane.showInputDialog("Digite um nome para a partida!");
                                if (salvaJogo(nomeJogo)) {
                                JOptionPane.showMessageDialog(janela, "Jogo "+nomeJogo+" Salvo Com Sucesso");
                                janela.dispose();
                            }
                        }
                    }
                }
            }

            public void keyReleased(KeyEvent ke) {
            }
        });

        janela.setBounds(0, 0, 660, 680);
        janela.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        janela.setLayout(null);
        janela.setLocationRelativeTo(null);
        final ImageIcon image = new ImageIcon("./Xadrez/fx.png");
        final JPanel meuPainel = new JPanel() {
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (image != null) {
                    g.drawImage(image.getImage(), 0, 0, null);
                }
            }
        };
        meuPainel.setBounds(0, 0, 680, 680);
        meuPainel.setLayout(null);
        janela.getContentPane().add(meuPainel);
        // Posicionamento dos labels  
        int boundX = 0;
        int boundY = 0;

        int contadorColuna = 1;
        int contadorLinha = 1;
        for (int x = 1; x <= 64; x++) {
            JLabel lbImagem = new JLabel();
//            if (x == 1 || x == 8) {
//                lbImagem.setIcon(TORRE_PRETO);
//            } else if (x == 2 || x == 7) {
//                lbImagem.setIcon(CAVALO_PRETO);
//            } else if (x == 3 || x == 6) {
//                lbImagem.setIcon(BISPO_PRETO);
//            } else if (x == 4) {
//                lbImagem.setIcon(RAINHA_PRETO);
//            } else if (x == 5) {
//                lbImagem.setIcon(REI_PRETO);
//            } else if (x > 8 && x < 17) {
//                lbImagem.setIcon(PEAO_PRETO);
//            } else if (x > 48 && x < 57) {
//                lbImagem.setIcon(PEAO_BRANCO);
//            } else if (x == 57 || x == 64) {
//                lbImagem.setIcon(TORRE_BRANCO);
//            } else if (x == 58 || x == 63) {
//                lbImagem.setIcon(CAVALO_BRANCO);
//            } else if (x == 59 || x == 62) {
//                lbImagem.setIcon(BISPO_BRANCO);
//            } else if (x == 60) {
//                lbImagem.setIcon(RAINHA_BRANCO);
//            } else if (x == 61) {
//                lbImagem.setIcon(REI_BRANCO);
//            } else {
//                lbImagem.setIcon(null);
//            }
            // Posiciona a imagem  
            lbImagem.setBounds(boundX, boundY, 80, 80);
            lbImagem.setName(contadorColuna + "" + contadorLinha);
            lbImagem.addMouseListener(
                    new MouseListener() {
                public void mouseReleased(MouseEvent arg0) {
                }

                public void mousePressed(MouseEvent arg0) {
                }

                public void mouseExited(MouseEvent arg0) {
                    JLabel lb = (JLabel) arg0.getSource();
                    lb.setBorder(null);
                }

                public void mouseEntered(MouseEvent arg0) {
                    JLabel lb = (JLabel) arg0.getSource();
                    lb.setBorder(BorderFactory.createLineBorder(Color.black, 1));
                }

                public void mouseClicked(MouseEvent arg0) {
                    JLabel lb = (JLabel) arg0.getSource();
                    if (!(lb.getIcon() == null && (janela.getCursor().getName()).equals("Cursor Default"))) {
                        ctrlPainelPrincipal.trocaImagemMouse(janela, lb);
                        ctrlPainelPrincipal.movePeca(meuPainel, janela, lb, indiceDaJogada, posicaoDaJogada);
                    }

                }
            });
            // Prepara a posição x do próximo label  
            boundX += 80;
            // Verifica se estourou o limite  
            if (boundX >= meuPainel.getWidth() - 80) {
                // Desce uma fila  
                boundY += 80;
                boundX = 0;
                contadorColuna++;
                contadorLinha = 0;
            }
            contadorLinha++;
            //Adiciona o label  
            meuPainel.add(lbImagem);
        }

        janela.setVisible(true);
        ctrlPainelPrincipal.preencheTabuleiro(meuPainel);
        
    }
}
