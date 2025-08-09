package service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import model.Endereco;

public class EnderecoServiceTest {
    @Test
    public void testCompletarEnderecoViaCepValido() throws IOException, InterruptedException{
        Endereco endereco = new Endereco("01001-000", "100", "Bloco A");
        EnderecoService.completarEnderecoViaCep(endereco);
        
        assertEquals("01001-000", endereco.getCep());
        assertNotNull(endereco.getLogradouro());
        assertEquals("São Paulo", endereco.getLocalidade());
        assertEquals("SP", endereco.getUf());
    }

    @Test
    public void testCompletarEnderecoViaCepInvalido(){
        Endereco endereco = new Endereco("00000-000", "100", "Bloco A");
        assertNull(endereco.getLogradouro());
        // assertDoesNotThrow(() -> EnderecoService.completarEnderecoViaCep(endereco));
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            EnderecoService.completarEnderecoViaCep(endereco);
        });

        assertTrue(exception.getMessage().contains("Formato de CEP inválido"));

    }

    //18600-000 18600000
    @Test
    public void testFormatoCepInvalido(){
        Endereco endereco = new Endereco("123-456", "160", "Bloco A");
        Exception exception = assertThrows(
            IllegalArgumentException.class,() -> {
                EnderecoService.completarEnderecoViaCep(endereco);
            }
        );

        assertTrue(exception.getMessage().contains("Formato de CEP inválido"));
    }

    @Test
    public void testFormatoNuloCepInvalido(){
        Endereco endereco = new Endereco(null, "160", "Bloco A");
        Exception exception = assertThrows(
            IllegalArgumentException.class,() -> {
                EnderecoService.completarEnderecoViaCep(endereco);
            }
        );

        assertTrue(exception.getMessage().contains("Formato de CEP inválido"));
    }
}
