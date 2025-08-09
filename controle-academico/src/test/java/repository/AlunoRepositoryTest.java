package repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Aluno;
import model.Endereco;

public class AlunoRepositoryTest {
    private static Path tempDir;
    private static Path txtFile;
    private static Path csvFile;

    @BeforeAll
    static void setupDir() throws IOException {
        tempDir = Files.createTempDirectory("aluno");
        txtFile = tempDir.resolve("alunos.txt");
        csvFile = tempDir.resolve("alunos.csv");

        //redefinir caminhos para arquivos temporarios
        try {
            var txtField = AlunoRepository.class.getDeclaredField("ARQUIVO_TXT");
            txtField.setAccessible(true);
            // txtField.set(null, txtFile);
        } catch (Exception e) {
            throw new RuntimeException("Falha ao redefinir caminho de arquivo", e);
        }
    }

    @BeforeEach
    void limparLista() {
        AlunoRepository.getList().clear();
    }

    @Test
    public void testSetNoArrayList() {
        List<Aluno> list = AlunoRepository.getList();

        // Aluno 1
        Endereco endereco = new Endereco("01001-000", "1", "apto");
        Aluno aluno = new Aluno("Gabriel", endereco, 16);
        AlunoRepository.setAlunoArrayList(aluno);

        assertEquals(1, list.size());
        assertEquals("Gabriel", list.get(0).getName());
        assertEquals(endereco.getCep(), list.get(0).getAddress().getCep());
        assertEquals(endereco.getNumero(), list.get(0).getAddress().getNumero());
        assertEquals(endereco.getComplemento(), list.get(0).getAddress().getComplemento());
        assertEquals(16, list.get(0).getAge());

        // Aluno 2
        
        Endereco endereco2 = new Endereco("18601-120", "100", "casa");
        Aluno aluno2 = new Aluno("Matheus", endereco2, 17);
        AlunoRepository.setAlunoArrayList(aluno2);

        assertEquals(2, list.size());
        assertEquals("Gabriel", list.get(0).getName());
        assertEquals(endereco.getCep(), list.get(0).getAddress().getCep());
        assertEquals(endereco.getNumero(), list.get(0).getAddress().getNumero());
        assertEquals(endereco.getComplemento(), list.get(0).getAddress().getComplemento());
        assertEquals(16, list.get(0).getAge());
    }
}
