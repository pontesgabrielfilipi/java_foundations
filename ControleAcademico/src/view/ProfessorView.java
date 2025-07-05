package view;

import javax.swing.JOptionPane;

import model.Professor;
import repository.ProfessorRepository;

public class ProfessorView {
        public static void executar() throws Exception {

                // Inserção de dados
                // Data insertion

                boolean valid = false;

                String name = JOptionPane.showInputDialog(null, "Insira o nome do Professor: ", "Insira o Nome",
                                JOptionPane.QUESTION_MESSAGE);

                String address = JOptionPane.showInputDialog(null, "Insira o endereço do Professor: ",
                                "Insira o Endereço",
                                JOptionPane.QUESTION_MESSAGE);

                int age = 0;
                do {
                        String ageString = JOptionPane.showInputDialog(null, "Insira a idade do Professor: ",
                                        "Insira a Idade",
                                        JOptionPane.QUESTION_MESSAGE);
                        valid = true;
                        try {
                                age = Integer.parseInt(ageString);
                        } catch (NumberFormatException e) {
                                System.out.println(e);
                                JOptionPane.showMessageDialog(null, "Idade Invalido!!! Tente novamente.",
                                                "Idade invalida",
                                                JOptionPane.ERROR_MESSAGE);
                                valid = false;
                                ageString = "";
                        }
                } while (!valid);

                String cpf = JOptionPane.showInputDialog(null, "Insira o CPF do Professor: ", "Insira o CPF",
                                JOptionPane.QUESTION_MESSAGE);

                String acting = JOptionPane.showInputDialog(null, "Insira o função do Professor: ", "Insira a função",
                                JOptionPane.QUESTION_MESSAGE);

                // Criando o objeto professor
                // Creating the professor object

                Professor professor = new Professor(name, address, age, cpf, acting);

                // Persistencia de dados em arquivos .txt pelo repositorio
                // Data percistence with .txt file with repository

                ProfessorRepository.salvar(professor);
        }
}
