package model;

public class Peao extends Peca {

    private boolean primeiroMovimento = true;

    public Peao(EnumCor cor, int linha, int coluna) {
        super(cor, linha, coluna, "./figs/PEAO" + cor + ".gif");
    }

    public Peao(EnumCor cor, int linha, int coluna, String image) {
        super(cor, linha, coluna, image);

    }

    @Override
    public boolean validaMovimento(int linhaDestino, int colunaDestino) {
        Peca pecaDestino = getTabuleiro().getPeca(linhaDestino, colunaDestino);
        if (pecaDestino == null && colunaDestino != getColuna()) {
            return false;
        }
        return true;
    }

    public void setPrimeiroMovimento(boolean primeiroMovimento){
        this.primeiroMovimento = primeiroMovimento;
    }

}
