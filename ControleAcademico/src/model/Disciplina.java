package model;

public class Disciplina {
    private long id;
    private String nome;
    private String categoria;

    // Constructors methods

    public Disciplina() {
    }
    public Disciplina(long id, String nome, String categoria) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
    }
    
    // To String method
    @Override
    public String toString() {
        return "Disciplina [id=" + id + ", nome=" + nome + ", categoria=" + categoria + "]";
    }

    // Gets and Sets methods

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    
}
