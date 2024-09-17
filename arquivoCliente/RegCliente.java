public class RegCliente {
    private String cliente;
    private String diaSemana;
    private String horario;
    private String tipoServico;
    private String valor;

    public RegCliente(String cliente, String diaSemana, String horario, String tipoServico, String valor) {
        this.cliente = cliente;
        this.diaSemana = diaSemana;
        this.horario = horario;
        this.tipoServico = tipoServico;
        this.valor = valor;
    }

    public String mostraCliente() {
        return cliente;
    }

    public String mostraDiaSemana() {
        return diaSemana;
    }

    public String mostraHorario() {
        return horario;
    }

    public String mostraTipoServico() {
        return tipoServico;
    }

    public String mostraValor() {
        return valor;
    }

    public void alteraDiaSemana(String novoDia) {
        this.diaSemana = novoDia;
    }

    public void alteraHorario(String novoHorario) {
        this.horario = novoHorario;
    }

    public void alteraTipoServico(String novoServico) {
        this.tipoServico = novoServico;
    }

    public void alteraValor(String novoValor) {
        this.valor = novoValor;
    }
}
