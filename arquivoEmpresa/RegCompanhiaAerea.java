public class RegCompanhiaAerea {
    private String companhiaAerea;
    private String numeroVoo;
    private String trechoVoo;
    private String horarioSaida;
    private String horarioChegada;

    public RegCompanhiaAerea(String companhiaAerea, String numeroVoo, String trechoVoo, String horarioSaida, String horarioChegada) {
        this.companhiaAerea = companhiaAerea;
        this.numeroVoo = numeroVoo;
        this.trechoVoo = trechoVoo;
        this.horarioSaida = horarioSaida;
        this.horarioChegada = horarioChegada;
    }

    public String mostraCompanhiaAerea() {
        return companhiaAerea;
    }

    public String mostraNumeroVoo() {
        return numeroVoo;
    }

    public String mostraTrechoVoo() {
        return trechoVoo;
    }

    public String mostraHorarioSaida() {
        return horarioSaida;
    }

    public String mostraHorarioChegada() {
        return horarioChegada;
    }

    public void alteraTrechoVoo(String novoTrecho) {
        this.trechoVoo = novoTrecho;
    }

    public void alteraHorarioSaida(String novoHorarioSaida) {
        this.horarioSaida = novoHorarioSaida;
    }

    public void alteraHorarioChegada(String novoHorarioChegada) {
        this.horarioChegada = novoHorarioChegada;
    }
}
