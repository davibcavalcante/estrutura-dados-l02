public class RegAluno {
    private String nome;
    private String curso;
    private String turma;
    private String periodo;

    public RegAluno(String nome, String curso, String turma, String periodo) {
        this.nome = nome;
        this.curso = curso;
        this.turma = turma;
        this.periodo = periodo;
    }

    public String mostraNome() {
        return nome;
    }

    public String mostraCurso() {
        return curso;
    }

    public String mostraTurma() {
        return turma;
    }

    public String mostraPeriodo() {
        return periodo;
    }

    public void alteraCurso(String novoCurso) {
        this.curso = novoCurso;
    }

    public void alteraTurma(String novaTurma) {
        this.turma = novaTurma;
    }

    public void alteraPeriodo(String novoPeriodo) {
        this.periodo = novoPeriodo;
    }
}
