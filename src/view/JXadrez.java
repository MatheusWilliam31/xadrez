package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import controler.ControlaTempo;
import java.awt.*;
import java.awt.event.*;
import model.EnumCor;
import model.Tabuleiro;

public class JXadrez extends JFrame {

    private static JLabel lbVez;
    protected Tabuleiro tabuleiro;
    private final JTabuleiro jTabuleiro;
    private final ControlaTempo controlaTempo;

    private final JButton btReiniciarJogo;
    private final JButton btPassarVez;
    public static final JPanel pnCemiterio = new JPanel();
    public JProgressBar pbTempo;

    public JXadrez() {
        setTitle("Jogo de Xadrez");
        this.setLayout(new BorderLayout());
        pbTempo = new JProgressBar();
        pbTempo.setMinimum(0);
        pbTempo.setMaximum(10000);

        this.controlaTempo = new ControlaTempo(pbTempo);
        this.tabuleiro = new Tabuleiro(controlaTempo);

        this.jTabuleiro = new JTabuleiro(tabuleiro);
        controlaTempo.setJTabuleiro(jTabuleiro);
        this.add(jTabuleiro, BorderLayout.CENTER);

        JPanel pnTopo = new JPanel();
        lbVez = new JLabel("O jogador BRANCO começa!");
        pnTopo.add(lbVez);
        this.add(pnTopo, BorderLayout.NORTH);

        JPanel pnLateral = new JPanel();
        pnLateral.setLayout(new GridLayout(10, 2));
        btReiniciarJogo = new JButton("Reiniciar Jogo");

        btReiniciarJogo.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                reiniciarJogo();
            }
        });

        // pnCemiterio.setLayout(new FlowLayout());
        this.add(pnCemiterio, BorderLayout.SOUTH);

        btPassarVez = new JButton("Passar a Vez");
        pnLateral.add(btReiniciarJogo);
        pnLateral.add(btPassarVez);
        this.add(pnLateral, BorderLayout.EAST);
        this.add(pbTempo, BorderLayout.NORTH);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Controlar tempo de jogada
        Thread threadTempo = new Thread(controlaTempo);
        threadTempo.start();

        this.pack();
        this.setVisible(true);
    }

    private void reiniciarJogo() {
        controlaTempo.zeraTempo();
        this.tabuleiro = new Tabuleiro(controlaTempo);
        this.jTabuleiro.setTabuleiro(this.tabuleiro);
        this.jTabuleiro.desenhaTabuleiro();
        setVez(tabuleiro.getVez());
    }

    public static void setVez(EnumCor corVez) {
        lbVez.setText("Vez do jogador " + corVez + "!");
    }

    public static void main(String[] args) {
        new JXadrez();

    }
}
