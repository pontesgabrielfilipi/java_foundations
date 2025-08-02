package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ProfessorTest {
    @Test
    public void testContrutorComParametros(){
        Endereco endereco = new Endereco("18600000", "001", "Apto.");
        Professor professor = new Professor("Paulo", endereco, 38, "123.123.123-12", "TI");

        assertEquals("Paulo", professor.getName());
        assertEquals(endereco, professor.getAddress());
        assertEquals(38, professor.getAge());
        assertEquals("123.123.123-12", professor.getCpf());
        assertEquals("TI", professor.getActing());
        assertTrue(professor.getRegistrationNumber() > 0 && professor.getRegistrationNumber() < 10000);
    }

    @Test
    public void testCostrutorSemParametros(){
        Professor professor = new Professor();

        professor.setName("Paulo");
        Endereco endereco = new Endereco("18600000", "001", "Apto.");
        professor.setAddress(endereco);
        professor.setAge(38);
        professor.setCpf("123.123.123-12");
        professor.setActing("TI");

        assertEquals("Paulo", professor.getName());
        assertEquals(endereco, professor.getAddress());
        assertEquals(38, professor.getAge());
        assertEquals("123.123.123-12", professor.getCpf());
        assertEquals("TI", professor.getActing());
        assertTrue(professor.getRegistrationNumber() > 0 && professor.getRegistrationNumber() < 10000);
    }
}
