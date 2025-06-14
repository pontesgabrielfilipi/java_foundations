package main;

import model.Aluno;

public class App {
    public static void main(String[] args) throws Exception {
        
        Aluno aluno = new Aluno();
        aluno.setName("Pedro Henrique");
        aluno.setAddress("Convivio");
        aluno.setAge(17);
        aluno.setRegistrationNumber(1);
        // System.out.println(aluno);
        aluno.visualizar();

        Aluno aluno2 = new Aluno("Peterson Alves", "cohab 2", 30, 2);
        System.out.println();
        aluno2.visualizar();
        

        // JOptionPane.showMessageDialog(null, aluno, null, 0);
    }
}
