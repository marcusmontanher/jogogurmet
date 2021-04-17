/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 *
 * @author marcu
 */
@ExtendWith(MockitoExtension.class) 
public class PerguntaTestTrue {
    
    Pergunta perguntaPrincipalMock = Mockito.mock(Pergunta.class);

    @org.junit.jupiter.api.Test
    public void testSomeMethod() {
        perguntarTrue();
    }
    
    public void perguntarTrue(){
        JogoGurmet jg = new JogoGurmet();
        jg.setPerguntaPrincipal(perguntaPrincipalMock);
        when(perguntaPrincipalMock.isPerguntaSim()).thenReturn(true);
    }
}
