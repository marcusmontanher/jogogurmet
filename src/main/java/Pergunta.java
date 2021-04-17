/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author marcu
 */
public class Pergunta {

    private JFrame pai;
    private String pergunta;
    private Pergunta perguntaPai;
    private Pergunta sim;
    private Pergunta nao;
    private boolean perguntaSim;

    public Pergunta(JFrame pai) {
        this.pai = pai;
    }

    public Pergunta() {
    }
    
    public void perguntar() {
        boolean resp = JOptionPane.showConfirmDialog(this.pai, this.pergunta, "Confirm", 0) == 0;
        if (resp) {
            this.sim.perguntar();
        } else {
            this.nao.perguntar();
        }
    }
    
    public void perguntar(boolean resposta) {
        boolean resp = resposta;
        if (resp) {
            this.sim.perguntar();
        } else {
            this.nao.perguntar();
        }
    }

    public JFrame getPai() {
        return pai;
    }

    public void setPai(JFrame pai) {
        this.pai = pai;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    protected Pergunta getPerguntaPai() {
        return this.perguntaPai;
    }

    private void setPerguntaPai(Pergunta perguntaPai, boolean perguntaSim) {
        this.perguntaPai = perguntaPai;
        this.perguntaSim = perguntaSim;
    }

    public Pergunta getSim() {
        return sim;
    }

    public void setSim(Pergunta sim) {
        (this.sim = sim).setPerguntaPai(this, true);
    }

    public Pergunta getNao() {
        return nao;
    }

    public void setNao(Pergunta nao) {
        (this.nao = nao).setPerguntaPai(this, false);
    }

    protected boolean isPerguntaSim() {
        return this.perguntaSim;
    }
}
