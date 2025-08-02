package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AlunoTest {
    @Test
    public void testConstructorComParametros() {

        Endereco endereco = new Endereco("18600000", "001", "Apto.");

        Aluno aluno = new Aluno(
                "pedro",
                endereco,
                29);

        assertEquals("pedro", aluno.getName());
        assertEquals(endereco, aluno.getAddress());
        assertEquals(29, aluno.getAge());
        assertTrue(aluno.getRegistrationNumber() > 0 && aluno.getRegistrationNumber() < 10000);

    }

    @Test
    public void testConstrutorSemParametros() {

        Endereco endereco = new Endereco("18600000", "001", "Apto.");

        Aluno aluno = new Aluno();

        aluno.setName("Pedro");
        aluno.setAddress(endereco);
        aluno.setAge(29);
        // int registrationNumber = aluno.generateRegistrationNumber();
        // aluno.setRegistrationNumber(registrationNumber);
        // aluno.setRegistrationNumber(aluno.generateRegistrationNumber());

        assertEquals("Pedro", aluno.getName());
        assertEquals(endereco, aluno.getAddress());
        assertEquals(29, aluno.getAge());
        assertTrue(aluno.getRegistrationNumber() > 0 && aluno.getRegistrationNumber() < 10000);

    }

}
