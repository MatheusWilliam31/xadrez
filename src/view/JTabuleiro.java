package view;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.GridLayout;
import model.Peca;
import model.Tabuleiro;
import java.awt.event.*;

public class JTabuleiro extends JPanel implements MouseListener {

    private Tabuleiro tabuleiro;
	public Object getTabuleiro;

    public JTabuleiro(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
        this.desenhaTabuleiro();
    }

    public void desenhaTabuleiro() { // Para redesenhar o tabuleiro sempre que ouver alguma mudança
        JXadrez.pnCemiterio.removeAll();
        this.removeAll();
        this.setLayout(new GridLayout(8, 8));
        for (int l = 0; l < 8; l++) {
            for (int c = 0; c < 8; c++) {
                JCelula jCelula;
                Peca peca = this.tabuleiro.getPeca(l, c);

                if (peca == null) {
                    jCelula = new JCelula(l, c);
                } else {
                    jCelula = new JCelula(new JPeca(peca));
                }

                if ((l + c) % 2 == 0) { // Para alternar a cor do tabuleiro
                    jCelula.setBackground(Color.WHITE);
                } else {
                    jCelula.setBackground(Color.BLACK);
                }

                this.add(jCelula);
                jCelula.addMouseListener(this);
            }

        }
        for(Peca pecaRemovida : this.tabuleiro.getPecasForaDeJogo()){
        
            JXadrez.pnCemiterio.add(new JPeca(pecaRemovida));

        }
        this.revalidate();

    }

    public Tabuleiro getTabuleiro() {
        return this.tabuleiro;
    }

    public void setTabuleiro(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
    }
    @Override
    public void mouseClicked(MouseEvent click) {
        JCelula jCelula = (JCelula) click.getSource();
        this.tabuleiro.realizarJogada(jCelula.getLinha(), jCelula.getColuna());
        this.desenhaTabuleiro();
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

}
