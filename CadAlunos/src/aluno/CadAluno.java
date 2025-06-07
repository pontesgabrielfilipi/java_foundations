package aluno;

import java.util.Scanner;

public class CadAluno {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Aluno aluno = new Aluno();
        Aluno aluno2 = new Aluno();

        aluno.setNome(scanner.nextLine());
        aluno2.setNome(scanner.nextLine());

        System.out.println(aluno.getNome());
        aluno2.displayAluno();

        scanner.close();
    }
}
