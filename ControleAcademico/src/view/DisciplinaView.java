package view;

import javax.swing.JOptionPane;

import model.Disciplina;
import repository.DisciplinaRepository;

public class DisciplinaView {
    public static void executar() throws Exception {
        boolean valid = true;

        // nome

        String nome = JOptionPane.showInputDialog(null, "Insira o nome da Disciplina: ", "Nome da Disciplina",
                JOptionPane.QUESTION_MESSAGE);

        // categoria

        String categoria = JOptionPane.showInputDialog(null, "Insira a categoria da Disciplina: ",
                "Categoria da Disciplina", JOptionPane.QUESTION_MESSAGE);

        // duracao

        int duracao = 0;
        do {

            String duracaoString = JOptionPane.showInputDialog(null,
                    "Insira o número de duração da Disciplina em horas: ",
                    "duração da Disciplina", JOptionPane.QUESTION_MESSAGE);
            valid = true;

            try {
                duracao = Integer.parseInt(duracaoString);
            } catch (NumberFormatException e) {
                System.err.println(e.getMessage());
                JOptionPane.showMessageDialog(null, "Número de duração da Disciplina INVALIDO!\n" + e.getMessage(),
                        "Número de duração da Disciplina INVALIDO", JOptionPane.ERROR_MESSAGE);
                valid = false;
                duracaoString = "";
            }

        } while (!valid);

        Disciplina disciplina = new Disciplina(nome, categoria, duracao);

        DisciplinaRepository.salvar(disciplina);

    }
}
