import java.io.*;

public class ArqBuscaAcademia {
    static StringBuffer memoria = new StringBuffer();

    public static void main(String[] args) {
        try {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader arqentrada = new BufferedReader(new FileReader("c:/Academia.txt"));

            System.out.println("Digite o nome da academia");
            String academia = entrada.readLine();
            String linha = "";
            String atividadeFisica = "", aparelho = "", horario = "", diaTreino = "";

            while ((linha = arqentrada.readLine()) != null) {
                memoria.append(linha + "\n");
            }

            int inicio = -1;
            inicio = memoria.indexOf(academia);

            if (inicio != -1) {
                int ultimo = memoria.indexOf("\t", inicio);
                String academiaNome = ler(inicio, ultimo);
                int primeiro = ultimo + 1;
                ultimo = memoria.indexOf("\t", primeiro);
                atividadeFisica = ler(primeiro, ultimo);
                primeiro = ultimo + 1;
                ultimo = memoria.indexOf("\t", primeiro);
                aparelho = ler(primeiro, ultimo);
                primeiro = ultimo + 1;
                ultimo = memoria.indexOf("\t", primeiro);
                horario = ler(primeiro, ultimo);
                primeiro = ultimo + 1;
                int fim = memoria.indexOf("\n", primeiro);
                diaTreino = ler(primeiro, fim);

                RegAcademia academiaObj = new RegAcademia(academiaNome, atividadeFisica, aparelho, horario, diaTreino);
                System.out.println("Academia encontrada: " + academiaNome + ", Atividade Física: " + atividadeFisica + ", Aparelho: " + aparelho + ", Horário: " + horario + ", Dia de Treino: " + diaTreino);

                System.out.println("Deseja alterar o horário? (S/N)");
                String resp = entrada.readLine();
                if (resp.equalsIgnoreCase("S")) {
                    System.out.println("Digite o novo horário:");
                    horario = entrada.readLine();
                    academiaObj.alteraHorario(horario);
                }

                memoria.replace(inicio, fim, academiaObj.mostraAcademia() + "\t" + academiaObj.mostraAtividadeFisica() + "\t" + academiaObj.mostraAparelho() + "\t" + academiaObj.mostraHorario() + "\t" + academiaObj.mostraDiaTreino());
                gravar();
            } else {
                System.out.println("Academia não encontrada");
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
            BufferedWriter saida = new BufferedWriter(new FileWriter("c:/Academia.txt"));
            saida.write(memoria.toString());
            saida.flush();
            saida.close();
        } catch (Exception e) {
            System.out.println("Erro ao gravar");
        }
    }
}
