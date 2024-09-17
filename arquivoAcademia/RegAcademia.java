public class RegAcademia {
    private String academia;
    private String atividadeFisica;
    private String aparelho;
    private String horario;
    private String diaTreino;

    public RegAcademia(String academia, String atividadeFisica, String aparelho, String horario, String diaTreino) {
        this.academia = academia;
        this.atividadeFisica = atividadeFisica;
        this.aparelho = aparelho;
        this.horario = horario;
        this.diaTreino = diaTreino;
    }

    public String mostraAcademia() {
        return academia;
    }

    public String mostraAtividadeFisica() {
        return atividadeFisica;
    }

    public String mostraAparelho() {
        return aparelho;
    }

    public String mostraHorario() {
        return horario;
    }

    public String mostraDiaTreino() {
        return diaTreino;
    }

    public void alteraAtividadeFisica(String novaAtividadeFisica) {
        this.atividadeFisica = novaAtividadeFisica;
    }

    public void alteraAparelho(String novoAparelho) {
        this.aparelho = novoAparelho;
    }

    public void alteraHorario(String novoHorario) {
        this.horario = novoHorario;
    }

    public void alteraDiaTreino(String novoDiaTreino) {
        this.diaTreino = novoDiaTreino;
    }
}
