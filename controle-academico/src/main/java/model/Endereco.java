package model;

public class Endereco {
    // Campos preenchidos pelo usuário
    private String cep;
    private String numero;
    private String complemento;

    // Campos preenchidos pela API ViaCep
    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;

    public Endereco() {
    }

    public Endereco(String cep, String numero, String complemento) {
        this.cep = cep;
        this.numero = numero;
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @Override
    public String toString() {
        return "Endereco [cep=" + cep + ", numero=" + numero + ", complemento=" + complemento + ", logradouro="
                + logradouro + ", bairro=" + bairro + ", localidade=" + localidade + ", uf=" + uf + "]";
    }

    

}
