/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.xadrez.tela.cih;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import poo.xadrez.cci.CtrlJogosSalvos;
import poo.xadrez.modelo.cdp.Jogador;
import poo.xadrez.modelo.cdp.JogoCompleto;
import poo.xadrez.rn.cgt.AplPrincipal;

public class TelaJogosSalvos extends javax.swing.JFrame {

    CtrlJogosSalvos ctrlJogosSalvos = new CtrlJogosSalvos();

    public TelaJogosSalvos() {
        initComponents();
        this.setVisible(true);
        preencheTabela();
    }

    private void preencheTabela() {
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        dtm.setNumRows(0);
        Object[] vetor = new Object[6];
        ArrayList<JogoCompleto> listaJogosAtuais = ctrlJogosSalvos.busca();
        for (JogoCompleto jogoCompleto : listaJogosAtuais) {
            Jogador branco = jogoCompleto.getJogo().getJogador(0);
            Jogador preto = jogoCompleto.getJogo().getJogador(1);
            vetor[0] = jogoCompleto.getNomeJogo();
            vetor[1] = jogoCompleto.getData();
            vetor[2] = branco.getNome();
            vetor[3] = branco.getPontuacao();
            vetor[4] = preto.getNome();
            vetor[5] = preto.getPontuacao();

            dtm.addRow(vetor);
        }
    }

    private void preencheTabelaPorNome() {
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        dtm.setNumRows(0);
        Object[] vetor = new Object[6];
        ArrayList<JogoCompleto> listaJogosAtuais = ctrlJogosSalvos.busca();
        for (JogoCompleto jogoCompleto : listaJogosAtuais) {
            Jogador branco = jogoCompleto.getJogo().getJogador(0);
            Jogador preto = jogoCompleto.getJogo().getJogador(1);
            vetor[0] = jogoCompleto.getNomeJogo();
            vetor[1] = jogoCompleto.getData();
            vetor[2] = branco.getNome();
            vetor[3] = branco.getPontuacao();
            vetor[4] = preto.getNome();
            vetor[5] = preto.getPontuacao();
            if (jogoCompleto.getNomeJogo().indexOf(jNome.getText()) >= 0) {
                dtm.addRow(vetor);
            }
        }

    }

    private String getNomeDaTabela() {
        TableModel mode = jTable1.getModel();
        int i = jTable1.getSelectedRow();
        String nome = (String) mode.getValueAt(i, 0);
        return nome;
    }

    private void recomecarJogo() {
        String nome = getNomeDaTabela();
        ctrlJogosSalvos.recomecaJogo(nome);

    }

    private boolean deletaJogo() {
        String nomeJogoAtual = getNomeDaTabela();
        return ctrlJogosSalvos.deletaJogo(nomeJogoAtual);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jNome = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jNome.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jNomeCaretUpdate(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome do Jogo", "Data/Hora do Jogo", "Nome Jogador Branco", "Pontos", "Nome Jogador Preto", "Pontos"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Deletar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Sair");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Jogar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 712, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jNome))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2, jButton3});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(jNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jNomeCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jNomeCaretUpdate
        preencheTabelaPorNome();
    }//GEN-LAST:event_jNomeCaretUpdate

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
    }//GEN-LAST:event_jTable1KeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        boolean resposta = deletaJogo();
        if (resposta) {
            JOptionPane.showMessageDialog(this, "Jogo " + getNomeDaTabela() + " deletado com sucesso");
            ((DefaultTableModel) jTable1.getModel()).removeRow(jTable1.getSelectedRow());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        recomecarJogo();
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JTextField jNome;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
