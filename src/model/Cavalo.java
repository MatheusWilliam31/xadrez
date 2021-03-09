package model;

public class Cavalo extends Peca{

    public Cavalo (EnumCor cor, int linha, int coluna){
        super(cor, linha, coluna, "./figs/CAVALO"+ cor + ".gif");
    }

    public Cavalo(EnumCor cor, int linha, int coluna, String image) {
        super(cor, linha, coluna, image);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean validaMovimento(int linhaDestino, int colunaDestino) {
        // TODO Auto-generated method stub
        return true;
    }
    
}
