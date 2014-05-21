package poo.xadrez.modelo.cdp;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Tabuleiro implements Serializable {

    protected Map<String, Casa> tabuleiro = new HashMap<String, Casa>();

    public Tabuleiro() {
        String id = "";
        // colocando os espa�os em branco de tabuleiro
        for (int linha = 3; linha < 7; linha++) {
            for (int coluna = 1; coluna < 9; coluna++) {
                Casa ct = new Casa(linha, coluna);
                id = "" + linha + "" + coluna;
                tabuleiro.put(id, ct);
            }
        }
        // iniciando os peoes brancos
        InserePeao(7, CorPeca.BRANCO);
        // iniciando os peoes pretos
        InserePeao(2, CorPeca.PRETO);
        // iniciando time branco;
        InsereTime(8, CorPeca.BRANCO);
        // iniciando time preto;
        InsereTime(1, CorPeca.PRETO);
    }

    private void InserePeao(int linha, CorPeca cor) {
        for (int i = 1; i < 9; i++) {
            Casa ct = new Casa(linha, i, new Peao(linha, i, cor));
            tabuleiro.put("" + linha + "" + i, ct);
        }
    }

    private void InsereTorre(int linha, CorPeca cor) {
        tabuleiro.put("" + linha + "" + 1, new Casa(linha, 1, new Torre(linha, 1,
                cor)));
        tabuleiro.put("" + linha + "" + 8, new Casa(linha, 8, new Torre(linha, 8,
                cor)));
    }

    private void InsereCavalo(int linha, CorPeca cor) {
        tabuleiro.put("" + linha + "" + 2, new Casa(linha, 2, new Cavalo(linha, 2,
                cor)));
        tabuleiro.put("" + linha + "" + 7, new Casa(linha, 7, new Cavalo(linha, 7,
                cor)));
    }

    private void InsereBispo(int linha, CorPeca cor) {
        tabuleiro.put("" + linha + "" + 3, new Casa(linha, 3, new Bispo(linha, 3,
                cor)));
        tabuleiro.put("" + linha + "" + 6, new Casa(linha, 6, new Bispo(linha, 6,
                cor)));
    }

    private void InsereRainha(int linha, CorPeca cor) {
        tabuleiro.put("" + linha + "" + 4, new Casa(linha, 4, new Rainha(linha, 4,
                cor)));
    }

    private void InsereRei(int linha, CorPeca cor) {
        tabuleiro.put("" + linha + "" + 5,
                new Casa(linha, 5, new Rei(linha, 5, cor)));
    }

    private void InsereTime(int linha, CorPeca cor) {
        InsereTorre(linha, cor);
        InsereCavalo(linha, cor);
        InsereBispo(linha, cor);
        InsereRainha(linha, cor);
        InsereRei(linha, cor);
    }

    public Peca getPeca(Posicao posicao) {
        Casa casa = tabuleiro.get("" + posicao.getLinha() + "" + posicao.getColuna());
        return casa.getPeca();
    }

    public void setPeca(Peca peca, Posicao posicao) {
        Casa casa = tabuleiro.get("" + posicao.getLinha() + "" + posicao.getColuna());
        casa.setPeca(peca);
        tabuleiro.put("" + posicao.getLinha() + "" + posicao.getColuna(), casa);
    }

    public boolean existePeca(int linha, int coluna) {
        Casa casa = tabuleiro.get("" + linha + "" + coluna);
        if (casa.getPeca() == null) {
            return false;
        }
        return true;
    }

    public void movimentapeca(Posicao posicaoInicial, Posicao posicaoFinal, Jogador jogadorAtual) {
        Casa casaFinal = tabuleiro.get("" + posicaoFinal.getLinha() + "" + posicaoFinal.getColuna());

        Casa casaInicial = tabuleiro.get("" + posicaoInicial.getLinha() + "" + posicaoInicial.getColuna());
        Peca pecaFinal = casaFinal.getPeca();
        if (pecaFinal != null) {
            int pontuacao = jogadorAtual.getPontuacao();
            int pontuacaoDaPeca = pecaFinal.getValorEmPontos();
            jogadorAtual.setPontuacao(pontuacao + pontuacaoDaPeca);
        }
        Peca pecaInicial = casaInicial.getPeca();
        pecaInicial.setJaMovimentou(1);
        pecaInicial.setPosicao(posicaoFinal);
        casaFinal.setPeca(pecaInicial);
        casaInicial.setPeca(null);
    }

    public CorPeca getCor(Posicao posicaoAtual) {
        Casa casa = tabuleiro.get("" + posicaoAtual.getLinha() + "" + posicaoAtual.getColuna());
        return (casa.getPeca().getCor());
    }

    public boolean verificaCheque(Posicao posicaoCasa, CorPeca cor) {

        for (int contadorLinha = 1; contadorLinha < 9; contadorLinha++) {
            for (int contadorColuna = 1; contadorColuna < 9; contadorColuna++) {
                Casa casa = tabuleiro.get("" + contadorLinha + "" + contadorColuna);
                Peca pecaAtual = casa.getPeca();
                if (pecaAtual != null && pecaAtual.getCor().equals(cor)) {
                    Posicao posicaopecaAtual = pecaAtual.getPosicao();
                    boolean resposta = pecaAtual.verificaMovimentoValido(this, posicaopecaAtual, posicaoCasa);
                    if (resposta) {
                        return true;
                    }

                }

            }
        }
        return false;
    }

    public Posicao getRei(CorPeca cor) {
        for (int contadorLinha = 1; contadorLinha < 9; contadorLinha++) {
            for (int contadorColuna = 1; contadorColuna < 9; contadorColuna++) {
                Casa casa = tabuleiro.get("" + contadorLinha + "" + contadorColuna);
                Peca pecaAtual = casa.getPeca();
                if (pecaAtual != null && pecaAtual.getTipoPeca().equals(TipoPeca.REI) && !pecaAtual.getCor().equals(cor)) {
                    Posicao posicaoRei = new Posicao(contadorLinha, contadorColuna);
                    return posicaoRei;
                }
            }
        }
        return null;
    }

    public void imprime() {
        for (int contadorLinha = 1; contadorLinha < 9; contadorLinha++) {
            for (int contadorColuna = 1; contadorColuna < 9; contadorColuna++) {
                Casa casa = tabuleiro.get("" + contadorLinha + "" + contadorColuna);
                Peca pecaAtual = casa.getPeca();
                if (pecaAtual != null) {
                    System.out.print(pecaAtual.getTipoPeca());
                } else {
                    System.out.print("VAZIO");
                }
            }
            System.out.println("");
        }
    }

    public Casa getCasa(String string) {
        return tabuleiro.get(string);
    }
}
