package repository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import interfaces.RepositoryInterface;
import model.Aluno;

public class AlunoRepository implements RepositoryInterface{

    // Criando a constante ARQUIVO_TXT que recebe o nome do arquivo manipulado
    // Creating the constant ARQIVO_TXT that recives the name of the manipulated file

    private static String ARQUIVO_TXT = "alunos.txt";
    private static String ARQUIVO_CSV = "alunos.csv";

    // Exemplo de Array fixo
    // Fixed Array exemple

    private static Aluno[] alunosArray = new Aluno[5];
    private static int contadorArray = 0;

    // Exemplo de Array dinâmico

    private static ArrayList<Aluno> alunosArrayList = new ArrayList<>();

    // Adicionar Alunos usando Array fixo
    public static void setAlunos(Aluno aluno) {
        if (contadorArray < alunosArray.length) {
            alunosArray[contadorArray] = aluno;
            contadorArray++;
        }else{
            System.err.println("Arquivo Cheio!");
        }
    }

    // Adicionar Alunos usando Array Dinâmico
    public static void setAlunoArrayList(Aluno aluno) {
        alunosArrayList.add(aluno);
    }
    public static ArrayList<Aluno> getList() {
        return alunosArrayList;
    }

    // Metodo de salvar
    // Save method

    public static void salvar(Aluno aluno) throws Exception {
        try (PrintWriter out = new PrintWriter(new FileWriter(ARQUIVO_TXT, true))) {
            
            if (new File(ARQUIVO_TXT).length() == 0) {
                out.println("name, address, age, registrationNumer");
            }

            out.printf(
                "%s,%s,%d,%d%n",
                    aluno.getName(),
                    aluno.getAddress(),
                    aluno.getAge(),
                    aluno.getRegistrationNumber());
        } catch (IOException e) {
            System.err.println("Erro ao salvar em TXT" + e.getMessage());
        }
    }

    public static void exportarParaCSV() throws Exception{

        try (
            BufferedReader in = new BufferedReader(new FileReader(ARQUIVO_TXT));
            PrintWriter out = new PrintWriter(new FileWriter(ARQUIVO_CSV));
        ){
            String linha;

            while ((linha = in.readLine()) != null) {
                out.println(linha);
            }

        } catch (Exception e) {
            System.err.println("Erro ao exportar para CSV " + e.getMessage());
        }

    }
}
