public class regAgenda {
    private String nome;
    private String end;
    private String tel;

    public regAgenda(String nom, String ender, String telef) {
        nome = nom;
        end = ender;
        tel = telef;
    }

    public void alteraEnd(String endereco) {
        end = endereco;
    }

    public void alteraTel(String numero) {
        tel = numero;
    }

    public String mostraNome() {
        return nome;
    }

    public String mostraEnd() {
        return end;
    }

    public String mostraTel() {
        return tel;
    }
}
