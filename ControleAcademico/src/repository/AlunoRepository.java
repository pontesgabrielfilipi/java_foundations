package repository;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import model.Aluno;

public class AlunoRepository {

    // Criando a constante ARQUIVO_TXT que recebe o nome do arquivo manipulado
    // Creating the constant ARQIVO_TXT that recives the name of the manipulated file

    private static final String ARQUIVO_TXT = "alunos.txt";

    // Metodo de salvar
    // Save method

    public static void salvar(Aluno aluno) throws Exception {
        try (PrintWriter out = new PrintWriter(new FileWriter(ARQUIVO_TXT, true))) {
            
            if (new File(ARQUIVO_TXT).length() == 0) {
                out.println("name, address, age, registrationNumer");
            }

            out.printf(
                "%s,%s,%d,%d%n",
                    aluno.getName(),
                    aluno.getAddress(),
                    aluno.getAge(),
                    aluno.getRegistrationNumber());
        } catch (IOException e) {
            System.err.println("Erro ao salvar em TXT" + e.getMessage());
        }
    }
}
