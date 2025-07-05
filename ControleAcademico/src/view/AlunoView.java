package view;

import javax.swing.JOptionPane;

import model.Aluno;
import repository.AlunoRepository;

public class AlunoView {
    public static void executar() throws Exception {

        // Inserção de dados
        // Data insertion

        boolean valid = false;
        String name = JOptionPane.showInputDialog("digite o nome do Aluno: ");
        String address = JOptionPane.showInputDialog("Digite o endereço do Aluno: ");
        int age = 0;
        do {
            String ageString = JOptionPane.showInputDialog("Digite a idade do Aluno: ");
            valid = true;

            try {
                age = Integer.parseInt(ageString);
            } catch (NumberFormatException e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(null, "Idade invalida!!! Tente novamente.", "Idade invalida",
                        JOptionPane.ERROR_MESSAGE);
                valid = false;
                ageString = "";
            }
        } while (!valid);
        valid = false;

        // Criando o objeto aluno
        // Creating the aluno object

        Aluno aluno = new Aluno(name, address, age);

        // Persistencia de dados em arquivos .txt pelo repositorio
        // Data percistence with .txt file with repository
        AlunoRepository.salvar(aluno);
        AlunoRepository.exportarParaCSV();
        
    }
}
