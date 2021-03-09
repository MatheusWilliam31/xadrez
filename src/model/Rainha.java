package model;

public class Rainha extends Peca{

    public Rainha (EnumCor cor, int linha, int coluna){
        super(cor, linha, coluna, "./figs/RAINHA"+ cor + ".gif");
    }

    public Rainha(EnumCor cor, int linha, int coluna, String image) {
        super(cor, linha, coluna, image);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean validaMovimento(int linhaDestino, int colunaDestino) {
        // TODO Auto-generated method stub
        return true;
    }
    
}
