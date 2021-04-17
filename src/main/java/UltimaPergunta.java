
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author marcu
 */
public class UltimaPergunta extends Pergunta{
    
    private String prato;
    
    public UltimaPergunta(JFrame pai) {
        super(pai);
    }

    @Override
    public void perguntar() {        
        boolean resp = JOptionPane.showConfirmDialog(this.getPai(), String.format("O prato que você pensou é %s ?", prato), "Confirm", 0) == 0;
        if(resp){
            JOptionPane.showMessageDialog(this.getPai(), "Acertei de novo!", "Jogo Gurmet", 1);
        }else{
            //Guarda as respostas da ultima pergunta
            Pergunta novaPergunta = new Pergunta(this.getPai());
            String pratoDigitado = JOptionPane.showInputDialog(this.getPai(), "Qual prato você pensou?", "Cancelar", 3);
            String pergunta = JOptionPane.showInputDialog(this.getPai(), String.format("%s é ________ mas %s não.", pratoDigitado, prato), "Complete", 3);
            //usado para a segunda resposta caso seja sim
            pergunta = String.format("O prato que você pensou é %s ?", pergunta);
            UltimaPergunta ultimaPergunta = new UltimaPergunta(this.getPai());
            ultimaPergunta.setPrato(pratoDigitado);
            
            if(this.isPerguntaSim()){
                this.getPerguntaPai().setSim(novaPergunta);
            }else{
                this.getPerguntaPai().setNao(novaPergunta);
            }
            
            novaPergunta.setPergunta(pergunta);
            novaPergunta.setSim(ultimaPergunta);
            novaPergunta.setNao(this);
        }
    }

    public String getPrato() {
        return this.prato;
    }

    public void setPrato(String prato) {
        this.prato = prato;
    }
    
}
