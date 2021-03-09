package controler;

import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

import model.Tabuleiro;
import view.JTabuleiro;

public class ControlaTempo implements Runnable {

    private JTabuleiro jTabuleiro;
    private int tempoGasto = 0;

    private JProgressBar barraPregresso;

    public ControlaTempo(JProgressBar pbTempo) {
        super();
        this.barraPregresso = pbTempo;
    }
    public void setJTabuleiro(JTabuleiro jTabuleiro){
        this.jTabuleiro = jTabuleiro;
    }

    public void zeraTempo(){
        this.tempoGasto = 0;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1);
                tempoGasto += 1;
                barraPregresso.setValue(tempoGasto);

                if(tempoGasto <= 4999){
                    barraPregresso.setForeground(Color.GREEN);
                } else if(tempoGasto >= 5000 && tempoGasto <= 7500){
                    barraPregresso.setForeground(Color.ORANGE);
                } else if (tempoGasto >= 7500){
                    barraPregresso.setForeground(Color.RED);
                }

                if (tempoGasto >= Tabuleiro.TEMPO_JOGADA) {
                    JOptionPane.showMessageDialog(null,
                            "O jogador " + jTabuleiro.getTabuleiro().getVez() + " perdeu a vez.");

                    if (jTabuleiro.getTabuleiro().getPecaSelecionada() != null) {
                        jTabuleiro.getTabuleiro().getPecaSelecionada().setSelecionada(false);
                        jTabuleiro.getTabuleiro().setPecaSelecionada(null);
                    }
                    jTabuleiro.getTabuleiro().inveterVez();
                    jTabuleiro.desenhaTabuleiro();

                }
            } catch (InterruptedException sleepTime) {
                sleepTime.printStackTrace();
            }
        }
    }

}
