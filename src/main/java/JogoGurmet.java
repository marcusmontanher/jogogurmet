
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author marcu
 */
public class JogoGurmet extends JFrame{
    
    private Pergunta perguntaPrincipal;
    
    public static void main(String[] args) {
        new JogoGurmet();
    }
        
    public JogoGurmet(){
        final JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, 3));
        final Border padding = BorderFactory.createEmptyBorder(20, 50, 20, 50);
        panel.setBorder(padding);
        final JButton button = new JButton("OK");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                JogoGurmet.this.confirmar();
            }
        });
        button.setAlignmentX(0.5f);
        final JLabel label = new JLabel("Pense em um prato que gosta");
        label.setAlignmentX(0.5f);
        panel.add(label);
        panel.add(button);
        this.setContentPane(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        UltimaPergunta perguntaSim = new UltimaPergunta(this);
        perguntaSim.setPrato("lasanha");
        UltimaPergunta perguntaNao = new UltimaPergunta(this);
        perguntaNao.setPrato("bolo de chocolate");
        this.perguntaPrincipal = new Pergunta(this);
        this.perguntaPrincipal.setPergunta("O prato que você pensou é massa?");
        this.perguntaPrincipal.setSim(perguntaSim);
        this.perguntaPrincipal.setNao(perguntaNao);
        
        this.setTitle("Jogo Gurmet");
        this.setDefaultCloseOperation(3);
    }
    
    private void confirmar(){
        this.perguntaPrincipal.perguntar();
    }

    public Pergunta getPerguntaPrincipal() {
        return perguntaPrincipal;
    }

    public void setPerguntaPrincipal(Pergunta perguntaPrincipal) {
        this.perguntaPrincipal = perguntaPrincipal;
    }
}
