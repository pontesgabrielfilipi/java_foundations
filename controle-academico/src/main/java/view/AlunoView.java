package view;

import javax.swing.JOptionPane;

import model.Aluno;
import model.Endereco;
import repository.AlunoRepository;
import service.EnderecoService;

public class AlunoView {
    public static void executar() throws Exception {

        // Inserção de dados
        // Data insertion

        boolean valid = false;
        String name = JOptionPane.showInputDialog("digite o nome do Aluno: ");
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
        
        // Endereco address = new Endereco();
        // address.setCep(JOptionPane.showInputDialog("Digite o CEP do Aluno (8 digitos e sem -): "));
        // address.setNumero(JOptionPane.showInputDialog("Digite o número da casa do Aluno: "));
        // address.setComplemento(JOptionPane.showInputDialog("Digite o complemento do endereço do Aluno: "));
        Endereco address = new Endereco(
            JOptionPane.showInputDialog(null, "Digite o CEP do Aluno (8 digitos e sem -): ", "CEP", JOptionPane.QUESTION_MESSAGE),
            JOptionPane.showInputDialog(null, "Digite o número da casa do Aluno: ", "Número da Casa", JOptionPane.QUESTION_MESSAGE),
            JOptionPane.showInputDialog(null, "Digite o complemento do endereço do Aluno: ", "Complemento do Endereço", JOptionPane.QUESTION_MESSAGE)
        );

        // Retornar os dados do adrress obtidos pela API viaCep
        EnderecoService.completarEnderecoViaCep(address);

        // Criando o objeto aluno
        // Creating the aluno object

        Aluno aluno = new Aluno(name, address, age);

        // Persistencia de dados em arquivos .txt pelo repositorio
        // Data percistence with .txt file with repository
        AlunoRepository.salvar(aluno);
        AlunoRepository.exportarParaCSV();
        
    }
}
