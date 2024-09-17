public class RegVeiculo {
    private String nome;
    private String marca;
    private String ano;
    private String cor;

    public RegVeiculo(String nome, String marca, String ano, String cor) {
        this.nome = nome;
        this.marca = marca;
        this.ano = ano;
        this.cor = cor;
    }

    public String mostraNome() {
        return nome;
    }

    public String mostraMarca() {
        return marca;
    }

    public String mostraAno() {
        return ano;
    }

    public String mostraCor() {
        return cor;
    }

    public void alteraMarca(String novaMarca) {
        this.marca = novaMarca;
    }

    public void alteraAno(String novoAno) {
        this.ano = novoAno;
    }

    public void alteraCor(String novaCor) {
        this.cor = novaCor;
    }
}
