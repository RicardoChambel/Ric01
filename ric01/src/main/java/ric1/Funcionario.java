package ric1;

public class Funcionario {
    private String sexo;
    private String nome;
    private int idade;
    private String cidade;
    private String cargo;

    public Funcionario(String sexo, String nome, int idade, String cidade, String cargo) {
        this.sexo = sexo;
        this.nome = nome;
        this.idade = idade;
        this.cidade = cidade;
        this.cargo = cargo;
    }

    public String getSexo() { return sexo; }
    public void setSexo(String sexo) { this.sexo = sexo; } // Correção aqui

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public int getIdade() { return idade; }
    public void setIdade(int idade) { this.idade = idade; }

    public String getCidade() { return cidade; }
    public void setCidade(String cidade) { this.cidade = cidade; }

    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }
}
