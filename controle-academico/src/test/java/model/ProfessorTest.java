package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ProfessorTest {
    @Test
    public void testContrutorComParametros(){
        Professor professor = new Professor("Paulo", "Rua 1", 38, "123.123.123-12", "TI");

        assertEquals("Paulo", professor.getName());
        assertEquals("Rua 1", professor.getAddress());
        assertEquals(38, professor.getAge());
        assertEquals("123.123.123-12", professor.getCPF());
        assertEquals("TI", professor.getActing());
        assertTrue(professor.getRegistrationNumber() > 0 && professor.getRegistrationNumber() < 10000);
    }

    @Test
    public void testCostrutorSemParametros(){
        Professor professor = new Professor();

        professor.setName("Paulo");
        professor.setAddress("Rua 1");
        professor.setAge(38);
        professor.setCPF("123.123.123-12");
        professor.setActing("TI");
        int registrationNumber = professor.generateRegistrationNumber();
        professor.setRegistrationNumber(registrationNumber);

        assertEquals("Paulo", professor.getName());
        assertEquals("Rua 1", professor.getAddress());
        assertEquals(38, professor.getAge());
        assertEquals("123.123.123-12", professor.getCPF());
        assertEquals("TI", professor.getActing());
        assertTrue(professor.getRegistrationNumber() > 0 && professor.getRegistrationNumber() < 10000);
    }
}
