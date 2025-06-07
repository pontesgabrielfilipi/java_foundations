package aluno;
public class Aluno {
    private String nome;
    private String endereco;
    private int idade;
    private int numero_da_matricula;

    // -------------------------------------

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getNumero_da_matricula() {
        return numero_da_matricula;
    }

    public void setNumero_da_matricula(int numero_da_matricula) {
        this.numero_da_matricula = numero_da_matricula;
    }

    public Aluno(String nome, String endereco, int idade, int numero_da_matricula) {
        this.nome = nome;
        this.endereco = endereco;
        this.idade = idade;
        this.numero_da_matricula = numero_da_matricula;
    }

    public Aluno() {
    }

    // -------------------------------------

    public void displayAluno() {
        System.out.printf("Name: %s", nome);
    }

}
