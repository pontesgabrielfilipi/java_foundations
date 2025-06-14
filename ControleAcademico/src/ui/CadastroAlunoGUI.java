package ui;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

import model.Aluno;

public class CadastroAlunoGUI {
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
                // TODO: handle exception
                System.out.println(e);
                JOptionPane.showMessageDialog(null, "Idade invalida!!! Tente novamente.", "Idade invalida",
                        JOptionPane.ERROR_MESSAGE);
                valid = false;
                ageString = "";
            }
        } while (!valid);
        valid = false;
        int registrationNumber = 0;
        do {
            String registrationNumberString = JOptionPane.showInputDialog("Digite o número de matricula do Aluno: ");
            valid = true;

            try {
                registrationNumber = Integer.parseInt(registrationNumberString);
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println(e);
                JOptionPane.showMessageDialog(null, "Número de matricula invalida!!! Tente novamente.",
                        "Matricula invalida", JOptionPane.ERROR_MESSAGE);
                valid = false;
                registrationNumberString = "";
            }
        } while (!valid);

        // Criando o objeto aluno
        // Creating the aluno object

        Aluno aluno = new Aluno(name, address, age, registrationNumber);
        // aluno.visualizar();

        // Persistencia de dados em arquivos .txt
        // Data percistence with .txt file

        File arquivoAlunos = new File("alunos.txt");
        try (FileWriter fw = new FileWriter(arquivoAlunos, true)) {
            PrintWriter pw = new PrintWriter(fw);
            
            if (!arquivoAlunos.exists()) {
                pw.println("name, address, age, registrationNumer");
            }

            pw.println(
                    aluno.getName() + "," +
                            aluno.getAddress() + "," +
                            aluno.getAge() + "," +
                            aluno.getRegistrationNumber());
        } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        // Código original

        /*
        PrintWriter out = new PrintWriter("alunos.txt");
        out.println("name, address, age, registrationNumer");
        out.println(
                aluno.getName() + "," +
                        aluno.getAddress() + "," +
                        aluno.getAge() + "," +
                        aluno.getRegistrationNumber());
        out.close();
        */
    }
}
