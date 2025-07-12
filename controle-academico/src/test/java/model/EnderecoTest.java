package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class EnderecoTest {
    @Test
    public void testConstrutorComParametros(){
        Endereco endereco = new Endereco("18600000", "500", "Casa");

        assertEquals("18600000", endereco.getCep());
        assertEquals("500", endereco.getNumero());
        assertEquals("Casa", endereco.getComplemento());
    }

    @Test
    public void testConstrutorSemParametros(){
        Endereco endereco = new Endereco();
        
        endereco.setCep("18600000");
        endereco.setNumero("500");
        endereco.setComplemento("Casa");

        assertEquals("18600000", endereco.getCep());
        assertEquals("500", endereco.getNumero());
        assertEquals("Casa", endereco.getComplemento());
    }
}
