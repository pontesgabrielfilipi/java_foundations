package model;

public class Aluno extends Pessoa {

    //  Constructors

    public Aluno() {
    }

    public Aluno(String name, Endereco address, int age) {
        super(name, address, age);
    }

    // ToString

    @Override
    public String toString() {
        return "nome, endereco, idade, matricula \n" + super.toString();
    }

}