package poo.xadrez.rn.cgt;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import poo.xadrez.bd.cgd.RegistraEmArquivo;
import poo.xadrez.modelo.cdp.CorPeca;
import poo.xadrez.modelo.cdp.Jogador;
import poo.xadrez.modelo.cdp.Peca;
import poo.xadrez.modelo.cdp.Posicao;
import poo.xadrez.modelo.cdp.Tabuleiro;
import poo.xadrez.modelo.cdp.Jogo;
import poo.xadrez.modelo.cdp.JogoCompleto;
import poo.xadrez.modelo.cdp.TipoPeca;

public class AplPrincipal {

    private int ContadorJogada = 1;
    private Tabuleiro tabuleiro = new Tabuleiro();
    private CorPeca corAtual = CorPeca.BRANCO;
    private Jogo jogo;

    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }

    public void setTabuleiro(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    public AplPrincipal(Jogo jogo) {
        this.jogo = jogo;
    }

    public int getContadorJogada() {
        return ContadorJogada;
    }

    public void setContadorJogada(int ContadorJogada) {
        this.ContadorJogada = ContadorJogada;
    }

    public boolean validarJogada(Posicao posicaoInicial, Posicao posicaoFinal) {
        //Pegou a peca
        Peca peca = tabuleiro.getPeca(posicaoInicial);
        boolean resposta = peca.verificaMovimentoValido(tabuleiro, posicaoInicial, posicaoFinal);
        boolean verificaJogadaBranca = tabuleiro.getCor(posicaoInicial).equals(CorPeca.BRANCO);
        boolean verificaJogadaPreta = tabuleiro.getCor(posicaoInicial).equals(CorPeca.PRETO);
        if (resposta && verificaJogadaBranca && ContadorJogada == 1) {
            this.corAtual = CorPeca.BRANCO;

            tabuleiro.movimentapeca(posicaoInicial, posicaoFinal, jogo.getJogador(0));
            ContadorJogada = 2;
            return true;
        }
        if (resposta && verificaJogadaPreta && ContadorJogada == 2) {
            this.corAtual = CorPeca.PRETO;
            tabuleiro.movimentapeca(posicaoInicial, posicaoFinal, jogo.getJogador(1));
            ContadorJogada = 1;
            return true;
        }
        return false;
    }

    public Posicao getRei() {
        return tabuleiro.getRei(corAtual);
    }

    public boolean verificaCheque() {
        Posicao posicaorei = tabuleiro.getRei(corAtual);
        boolean resposta = tabuleiro.verificaCheque(posicaorei, corAtual);
        return resposta;
    }

    public boolean verificaRoqueMenor(Posicao posicaoInicial, Posicao posicaoFinal, int indice) {
        Peca pecaInicial = tabuleiro.getPeca(posicaoInicial);
        Posicao posicaoCavalo = new Posicao(indice, 7);
        Peca possivelCavalo = tabuleiro.getPeca(posicaoCavalo);
        Posicao posicaoBispo = new Posicao(indice, 6);
        Peca possivelBispo = tabuleiro.getPeca(posicaoBispo);
        Posicao posicaoTorre = new Posicao(indice, 8);
        Peca possivelTorre = tabuleiro.getPeca(posicaoTorre);
        boolean casaCavalo;
        boolean casaBispo;
        boolean resposta;
        casaCavalo = tabuleiro.verificaCheque(posicaoCavalo, corAtual);
        casaBispo = tabuleiro.verificaCheque(posicaoBispo, corAtual);
        resposta = posicaoFinal.compara(posicaoCavalo);
        if (pecaInicial != null && possivelTorre != null) {
            if (pecaInicial.getTipoPeca().equals(TipoPeca.REI) && pecaInicial.getJaMovimentou() == 0) {
                if (possivelTorre.getTipoPeca().equals(TipoPeca.TORRE) && pecaInicial.getJaMovimentou() == 0) {
                    if (!casaCavalo && !casaBispo) {
                        if (possivelCavalo == null && possivelBispo == null) {
                            if (resposta) {
                                tabuleiro.movimentapeca(posicaoInicial, posicaoFinal, null);
                                tabuleiro.movimentapeca(posicaoTorre, posicaoBispo, null);
                                if (indice == 8) {
                                    ContadorJogada = 2;
                                    this.corAtual = CorPeca.BRANCO;
                                    return true;
                                }
                                if (indice == 1) {
                                    ContadorJogada = 1;
                                    this.corAtual = CorPeca.PRETO;
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean verificaRoqueMaior(Posicao posicaoInicial, Posicao posicaoFinal, int indice) {
        Peca pecaInicial = tabuleiro.getPeca(posicaoInicial);
        Posicao posicaoCavalo = new Posicao(indice, 2);
        Peca possivelCavalo = tabuleiro.getPeca(posicaoCavalo);
        Posicao posicaoBispo = new Posicao(indice, 3);
        Peca possivelBispo = tabuleiro.getPeca(posicaoBispo);
        Posicao posicaoTorre = new Posicao(indice, 1);
        Peca possivelTorre = tabuleiro.getPeca(posicaoTorre);
        Posicao posicaoRainha = new Posicao(indice, 4);
        Peca possivelRainha = tabuleiro.getPeca(posicaoRainha);
        boolean casaCavalo;
        boolean casaBispo;
        boolean resposta;
        boolean casaRainha;
        casaCavalo = tabuleiro.verificaCheque(posicaoCavalo, corAtual);
        casaBispo = tabuleiro.verificaCheque(posicaoBispo, corAtual);
        casaRainha = tabuleiro.verificaCheque(posicaoRainha, corAtual);
        resposta = posicaoFinal.compara(posicaoCavalo);
        if (pecaInicial != null && possivelTorre != null) {
            if (pecaInicial.getTipoPeca().equals(TipoPeca.REI) && pecaInicial.getJaMovimentou() == 0) {
                if (possivelTorre.getTipoPeca().equals(TipoPeca.TORRE) && pecaInicial.getJaMovimentou() == 0) {
                    if (!casaCavalo && !casaBispo && !casaRainha) {
                        if (possivelCavalo == null && possivelBispo == null && possivelRainha == null) {
                            if (resposta) {
                                tabuleiro.movimentapeca(posicaoInicial, posicaoFinal, null);
                                tabuleiro.movimentapeca(posicaoTorre, posicaoBispo, null);
                                if (indice == 8) {
                                    ContadorJogada = 2;
                                    this.corAtual = CorPeca.BRANCO;
                                    return true;
                                }
                                if (indice == 1) {
                                    ContadorJogada = 1;
                                    this.corAtual = CorPeca.PRETO;
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public Jogador getVencedor() {
        int pontuacaoPrimeiroJogador = jogo.getJogador(0).getPontuacao();
        int pontuacaoSegundoJogador = jogo.getJogador(1).getPontuacao();
        if (pontuacaoPrimeiroJogador == pontuacaoSegundoJogador) {
            return null;
        }
        if (pontuacaoPrimeiroJogador > pontuacaoSegundoJogador) {
            return jogo.getJogador(0);
        } else {
            return jogo.getJogador(1);
        }
    }
    RegistraEmArquivo ctrlRegistraEmArquivo = new RegistraEmArquivo();

    private String getData() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date date = new Date();
        return dateFormat.format(date);
    }
    
    
    
    public boolean salvarJogo(String nomeJogo) {
        String data = getData();
        JogoCompleto jogoCompleto = new JogoCompleto(tabuleiro, jogo, nomeJogo, ContadorJogada, data);
        return ctrlRegistraEmArquivo.saveTabuleiro(jogoCompleto);
    }

    public ArrayList<JogoCompleto> buscaPartida() {
        return ctrlRegistraEmArquivo.buscaPartida();
    }
}