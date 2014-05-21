package poo.xadrez.modelo.cdp;

import java.util.ArrayList;
import poo.xadrez.modelo.cdp.movimento.AndarDoRei;
import poo.xadrez.modelo.cdp.movimento.Movimento;

public class Rei extends Peca {

    public Rei(int linha, int coluna, CorPeca cor) {
        this.tipoPeca = TipoPeca.REI;
        this.posicao = new Posicao(linha, coluna);
        this.cor = cor;
        this.movimentos.add(new AndarDoRei());
        this.valorEmPontos = 0;
    }

    @Override
    public boolean verificaMovimentoValido(Tabuleiro tabuleiro, Posicao p_inicial, Posicao p_final) {
        ArrayList<Posicao> validos = new ArrayList<Posicao>();
        validos = movimentosValidos(tabuleiro, p_inicial, p_final);
        return (contemPosicao(validos, p_final));
    }

    @Override
    public ArrayList<Posicao> movimentosValidos(Tabuleiro tabuleiro, Posicao p_inicial, Posicao p_final) {
        ArrayList<Posicao> posicoesValidas = new ArrayList<Posicao>();
        for (Movimento movimento : movimentos) {
            posicoesValidas.addAll(movimento.validarMovimento(tabuleiro, p_inicial, p_final, this));
        }
        return posicoesValidas;
    }
}
