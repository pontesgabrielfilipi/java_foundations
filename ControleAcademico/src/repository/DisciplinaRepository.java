package repository;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import model.Disciplina;

public class DisciplinaRepository {
    private static final String ARQUIVO_TXT = "disciplinas.txt";


    public static void salvar(Disciplina disciplina) throws Exception {
        try (PrintWriter out = new PrintWriter(new FileWriter(ARQUIVO_TXT, true))){
            
            if (new File(ARQUIVO_TXT).length() == 0) {
                out.println("id,nome,categoria,duracao");
            }

            out.printf(
                "%d,%s,%s,%d%n",
                disciplina.getId(),
                disciplina.getNome(),
                disciplina.getCategoria(),
                disciplina.getDuracao()
            );
        } catch (IOException e) {
            System.err.println("Erro ao salvar em TXT" + e.getMessage());
        }
    }
}
