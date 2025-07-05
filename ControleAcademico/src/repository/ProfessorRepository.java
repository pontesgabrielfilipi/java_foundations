package repository;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import model.Professor;

public class ProfessorRepository {

    // Criando a constante ARQUIVO_TXT que recebe o nome do arquivo manipulado
    // Creating the constant ARQIVO_TXT that recives the name of the manipulated file

    private static final String ARQUIVO_TXT = "professores.txt";

    // Metodo de salvar
    // Save method

    public static void salvar(Professor professor) throws Exception {
        try (PrintWriter out = new PrintWriter(new FileWriter(ARQUIVO_TXT, true))){

            if (new File(ARQUIVO_TXT).length() == 0){
                out.println("name, address, age, registrationNumer, cpf, acting");
            }

            out.printf(
                "%s,%s,%d,%d,%s,%s%n",
                professor.getName(),
                professor.getAddress(),
                professor.getAge(),
                professor.getRegistrationNumber(),
                professor.getCPF(),
                professor.getActing()
            );
        } catch (IOException e) {
            System.err.println("Erro ao salvar em TXT" + e.getMessage());
        }
    }
}
