package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class DisciplinaTest {
    @Test
    public void testConstrutorComParametros(){
        Disciplina disciplina = new Disciplina(
            "JAVA",
            "TI",
            40
        );
        
        assertEquals("JAVA", disciplina.getNome());
        assertEquals("TI", disciplina.getCategoria());
        assertEquals(40, disciplina.getDuracao());
        assertTrue(disciplina.getId() > 0 && disciplina.getId() < 10000);
    }

    @Test
    public void testConstrutorSemParametros(){
        Disciplina disciplina = new Disciplina();
        
        disciplina.setNome("JAVA");
        disciplina.setCategoria("TI");
        disciplina.setDuracao(40);
        int id = disciplina.gerarId();
        disciplina.setId(id);

        assertEquals("JAVA", disciplina.getNome());
        assertEquals("TI", disciplina.getCategoria());
        assertEquals(40, disciplina.getDuracao());
        assertTrue(disciplina.getId() > 0 && disciplina.getId() < 10000);
    }
}
