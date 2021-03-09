package model;

public abstract class Peca {
    // Não gera objetos, feita só para definiçoes.

    private EnumCor cor;
    private int linha, coluna;
    private String image;
    private boolean eliminada = false;
    private boolean selecionada = false;
    private Tabuleiro tabuleiro;

 
    public Peca(EnumCor cor, int linha, int coluna, String image){
        this.cor = cor;
        this.linha = linha;
        this.coluna = coluna;
        this.image = image;
    }

    public abstract boolean validaMovimento(int linhaDestino, int colunaDestino); 


    public EnumCor getCor() {
        return this.cor;
    }

    public void setCor(EnumCor cor) {
        this.cor = cor;
    }


    public void setLinha(int linha) {
        this.linha = linha;
	}


    public int getLinha(){
		return this.linha;
	}

    public void setColuna(int coluna){
		this.coluna = coluna;
    }
    public int getColuna(){
		return this.coluna;
	}

    public void setcoluna(int coluna)
    {
		this.coluna = coluna;
	}

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isEliminada() {
        return this.eliminada;
    }

    public void setEliminada(boolean eliminada) {
        this.eliminada = eliminada;
    }

    public boolean isSelecionada() {
        return this.selecionada;
    }

    public void setSelecionada(boolean selecionada) {
        this.selecionada = selecionada;
    }

    public Tabuleiro getTabuleiro() {
        return this.tabuleiro;
    }

    public void setTabuleiro(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
    }


}
