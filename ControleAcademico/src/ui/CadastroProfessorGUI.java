package ui;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

import model.Professor;

public class CadastroProfessorGUI {
    public static void executar() throws Exception {
        boolean valid = false;
        String name = JOptionPane.showInputDialog(null, "Insira o nome do Professor: ", "Insira o Nome",
                JOptionPane.QUESTION_MESSAGE);
        String address = JOptionPane.showInputDialog(null, "Insira o endereço do Professor: ", "Insira o Endereço",
                JOptionPane.QUESTION_MESSAGE);
        int age = 0;
        do {
            String ageString = JOptionPane.showInputDialog(null, "Insira a idade do Professor: ", "Insira a Idade",
                    JOptionPane.QUESTION_MESSAGE);
            valid = true;
            try {
                age = Integer.parseInt(ageString);
            } catch (NumberFormatException e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(null, "Idade Invalido!!! Tente novamente.", "Idade invalida",
                        JOptionPane.ERROR_MESSAGE);
                valid = false;
                ageString = "";
            }
        } while (!true);
        valid = false;
        int registrationNumber = 0;
        do {
            String registrationNumberString = JOptionPane.showInputDialog(null,
                    "Insira o número de registro do Professor: ", "Insira o Número de registro",
                    JOptionPane.QUESTION_MESSAGE);
            valid = true;
            try {
                registrationNumber = Integer.parseInt(registrationNumberString);
            } catch (NumberFormatException e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(null, e, "Número de registro invalido", JOptionPane.ERROR_MESSAGE);
                valid = false;
                registrationNumberString = "";
            }
        } while (!valid);
        valid = false;
        String cpf = JOptionPane.showInputDialog(null, "Insira o CPF do Professor: ", "Insira o CPF",
                JOptionPane.QUESTION_MESSAGE);
        String acting = JOptionPane.showInputDialog(null, "Insira o função do Professor: ", "Insira a função",
                JOptionPane.QUESTION_MESSAGE);

        Professor professor = new Professor(name, address, age, registrationNumber, cpf, acting);

        File arquivoProfessores = new File("professores.txt");
        boolean arquivoProfessoresExiste = arquivoProfessores.exists();
        try (FileWriter fw = new FileWriter(arquivoProfessores, true)) {
            PrintWriter pw = new PrintWriter(fw);

            if (!arquivoProfessoresExiste) {
                pw.println("name, address, age, registrationNumer, cpf, acting");
            }

            pw.println(
                    professor.getName() + "," +
                            professor.getAddress() + "," +
                            professor.getAge() + "," +
                            professor.getRegistrationNumber() + "," +
                            professor.getCPF() + "," +
                            professor.getActing());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
