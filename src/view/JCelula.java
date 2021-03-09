package view;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

import model.Peca;

public class JCelula extends JPanel{
    
    private JPeca jPeca;
    
    private int linha, coluna;

    public JCelula(int linha, int coluna){
        this.linha = linha;
        this.coluna = coluna;
    }

    public JCelula(JPeca peca){
        this.jPeca = peca;
        this.linha = peca.getPeca().getLinha();
        this.coluna = peca.getPeca().getColuna();
        this.add(peca);

        if ((peca.getPeca() != null) && peca.getPeca().isSelecionada()){
            this.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
        }
        
    }

    public int getLinha()
    {
		return this.linha;
    }
    public int getColuna()
    {
		return this.coluna;
	}
    
}
