package view;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import model.Peca;

public class JPeca extends JLabel{

    private Peca peca;

    public JPeca(Peca peca){
        this.peca = peca;
        this.setIcon(new ImageIcon(peca.getImage()));// Para settar a imagem da peça
    }
    
    public Peca getPeca(){
        return this.peca;
    }
}
