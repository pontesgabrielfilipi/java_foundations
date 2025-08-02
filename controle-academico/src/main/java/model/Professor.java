package model;

public class Professor extends Pessoa{
    private String cpf;
    private String acting;

    // Constructors

    public Professor() {
    }

    public Professor(String name, Endereco address, int age, String cpf, String acting) {
        super(name, address, age);
        this.cpf = cpf;
        this.acting = acting;
    }

    // Gets and Sets

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getActing() {
        return acting;
    }

    public void setActing(String acting) {
        this.acting = acting;
    }

    @Override
    public String toString() {
        return "Professor [cpf=" + cpf + ", acting=" + acting + "]"+ ", " + super.toString();
    }
    

}
