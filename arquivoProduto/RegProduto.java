public class RegProduto {
    private String nome;
    private String marca;
    private String unidade;
    private String valor;
    private String quantidade;

    public RegProduto(String nome, String marca, String unidade, String valor, String quantidade) {
        this.nome = nome;
        this.marca = marca;
        this.unidade = unidade;
        this.valor = valor;
        this.quantidade = quantidade;
    }

    public String mostraNome() {
        return nome;
    }

    public String mostraMarca() {
        return marca;
    }

    public String mostraUnidade() {
        return unidade;
    }

    public String mostraValor() {
        return valor;
    }

    public String mostraQuantidade() {
        return quantidade;
    }

    public void alteraMarca(String novaMarca) {
        this.marca = novaMarca;
    }

    public void alteraValor(String novoValor) {
        this.valor = novoValor;
    }

    public void alteraQuantidade(String novaQuantidade) {
        this.quantidade = novaQuantidade;
    }
}
