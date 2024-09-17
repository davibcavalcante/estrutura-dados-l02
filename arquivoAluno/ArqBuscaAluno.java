import java.io.*;

public class ArqBuscaAluno {
    static StringBuffer memoria = new StringBuffer();

    public static void main(String[] args) {
        try {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader arqentrada = new BufferedReader(new FileReader("C:/Users/davib/Desktop/DEV/Aluno.txt"));

            System.out.println("Digite o nome do aluno");
            String nome = entrada.readLine();
            String linha = "";
            String curso = "", turma = "", periodo = "";

            while ((linha = arqentrada.readLine()) != null) {
                memoria.append(linha + "\n");
            }

            int inicio = -1;
            inicio = memoria.indexOf(nome);

            if (inicio != -1) {
                int ultimo = memoria.indexOf("\t", inicio);
                String alunoNome = ler(inicio, ultimo);
                int primeiro = ultimo + 1;
                ultimo = memoria.indexOf("\t", primeiro);
                curso = ler(primeiro, ultimo);
                primeiro = ultimo + 1;
                ultimo = memoria.indexOf("\t", primeiro);
                turma = ler(primeiro, ultimo);
                primeiro = ultimo + 1;
                int fim = memoria.indexOf("\n", primeiro);
                periodo = ler(primeiro, fim);

                RegAluno aluno = new RegAluno(alunoNome, curso, turma, periodo);
                System.out.println("Aluno encontrado: " + alunoNome + ", Curso: " + curso + ", Período: " + periodo);

                System.out.println("Deseja alterar o curso? (S/N)");
                String resp = entrada.readLine();
                if (resp.equalsIgnoreCase("S")) {
                    System.out.println("Digite o novo curso:");
                    curso = entrada.readLine();
                    aluno.alteraCurso(curso);
                }

                memoria.replace(inicio, fim, aluno.mostraNome() + "\t" + aluno.mostraCurso() + "\t" + aluno.mostraTurma() + "\t" + aluno.mostraPeriodo());
                gravar();
            } else {
                System.out.println("Aluno não encontrado");
            }

            arqentrada.close();
        } catch (Exception e) {
            System.out.println("Erro na busca");
        }
    }

    public static String ler(int inicio, int fim) {
        return memoria.substring(inicio, fim);
    }

    public static void gravar() {
        try {
            BufferedWriter saida = new BufferedWriter(new FileWriter("C:/Users/davib/Desktop/DEV/Aluno.txt"));
            saida.write(memoria.toString());
            saida.flush();
            saida.close();
        } catch (Exception e) {
            System.out.println("Erro ao gravar");
        }
    }
}
