public class RegRoupa {
    private String roupa;
    private String tamanho;
    private String cor;
    private String modelo;

    public RegRoupa(String roupa, String tamanho, String cor, String modelo) {
        this.roupa = roupa;
        this.tamanho = tamanho;
        this.cor = cor;
        this.modelo = modelo;
    }

    public String mostraRoupa() {
        return roupa;
    }

    public String mostraTamanho() {
        return tamanho;
    }

    public String mostraCor() {
        return cor;
    }

    public String mostraModelo() {
        return modelo;
    }

    public void alteraTamanho(String novoTamanho) {
        this.tamanho = novoTamanho;
    }

    public void alteraCor(String novaCor) {
        this.cor = novaCor;
    }

    public void alteraModelo(String novoModelo) {
        this.modelo = novoModelo;
    }
}
