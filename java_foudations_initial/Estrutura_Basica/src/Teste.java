import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String nome, email, senha;
        int idade;
        char confimacao;

        do {
            do {
                System.out.println("Insira o seu Nome: \n");
                nome = input.nextLine();

                do {
                    System.out.println("\nInsira o seu E-mail: \n");
                    email = input.nextLine();

                    if (!emailValido(email)) {
                        System.out.println("E-mail invalido! Tente novamente.");
                    }
                } while (!emailValido(email));

                System.out.println("\nInsira a sua Idade: \n");
                while (!input.hasNextInt()) {
                    System.out.println("Idade invalida, insira um número inteiro!!!");
                    input.next();
                }
                idade = input.nextInt();
                input.nextLine();

                do {
                    System.out.println(
                            "Insira a sua senha (mínimo 6 caracteres, 1 número, 1 maiúscula e 1 caractere especial): ");
                    senha = input.nextLine();

                    if (!senhaValida(senha)) {
                        System.out.println("Senha invalida! Tente novamente.");
                    }
                } while (!senhaValida(senha));

            } while (
                    (nome == null || nome.trim().isEmpty()) ||
                    (email == null || email.trim().isEmpty()) ||
                    (senha == null || senha.trim().isEmpty())
                    );

            System.out.printf("O usuario é: \n Nome: %s \n E-mail: %s \n Idade: %d \n", nome, email, idade);
            System.out.println("Responda com 'YES' ou 'NOT'");
            confimacao = input.next().trim().toLowerCase().charAt(0);
            input.nextLine();
        } while (!(confimacao == 'y'));

        System.out.println("\n \n -------------------------------------------------------- \nCódigo finalizado!!!");

        input.close();
    }

    public static boolean emailValido(String email) {
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email.matches(regex);
    }

    public static boolean senhaValida(String senha) {
        String regex = "^(?=.*[!@#$%^&*()_+\\-=[\\]{};':\"\\\\|,.<>/?])(?=.*\\d)(?=.*[A-Z]).{6,}$";
        return senha.matches(regex);
    }
}