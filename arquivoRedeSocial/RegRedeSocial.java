public class RegRedeSocial {
    private String redeSocial;
    private String nome;
    private String quantSeguidores;
    private String assunto;

    public RegRedeSocial(String redeSocial, String nome, String quantSeguidores, String assunto) {
        this.redeSocial = redeSocial;
        this.nome = nome;
        this.quantSeguidores = quantSeguidores;
        this.assunto = assunto;
    }

    public String mostraRedeSocial() {
        return redeSocial;
    }

    public String mostraNome() {
        return nome;
    }

    public String mostraQuantSeguidores() {
        return quantSeguidores;
    }

    public String mostraAssunto() {
        return assunto;
    }

    public void alteraNome(String novoNome) {
        this.nome = novoNome;
    }

    public void alteraQuantSeguidores(String novaQuantSeguidores) {
        this.quantSeguidores = novaQuantSeguidores;
    }

    public void alteraAssunto(String novoAssunto) {
        this.assunto = novoAssunto;
    }
}
