package model;

import java.util.Random;

public class Disciplina {
    private long id;
    private String nome;
    private String categoria;
    // TODO: mudar para horas
    private int duracao;

    // Constructors methods

    public Disciplina() {
    }

    public Disciplina(String nome, String categoria, int duracao) {
        this.id = this.gerarId();
        this.nome = nome;
        this.duracao = duracao;
        this.categoria = categoria;
    }

    // To String method

    @Override
    public String toString() {
        return "Disciplina [id=" + id + ", nome=" + nome + ", duracao=" + duracao + ", categoria=" + categoria + "]";
    }

    // Gets and Sets methods

    public long getId() {
        return id;
    }

    public int gerarId() {
        Random rand = new Random();
        int id = rand.nextInt(9999) + 1; // 1 até 9999
        return id;
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

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

}
