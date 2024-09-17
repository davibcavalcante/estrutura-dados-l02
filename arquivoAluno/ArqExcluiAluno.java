import java.io.*;

public class ArqExcluiAluno {
    static StringBuffer memoria = new StringBuffer();

    public static void main(String[] args) {
        try {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader arqentrada = new BufferedReader(new FileReader("C:/Users/davib/Desktop/DEV/Aluno.txt"));

            System.out.println("Digite o nome do aluno");
            String nome = entrada.readLine();
            String linha = "";

            while ((linha = arqentrada.readLine()) != null) {
                memoria.append(linha + "\n");
            }

            int inicio = -1;
            inicio = memoria.indexOf(nome);

            if (inicio != -1) {
                int fim = memoria.indexOf("\n", inicio);
                linha = ler(inicio, fim);
                System.out.println("Deseja excluir o aluno? (S/N)");
                System.out.println(linha);
                String resposta = entrada.readLine();

                if (resposta.equalsIgnoreCase("S")) {
                    memoria.delete(inicio, fim + 1);
                    System.out.println("Aluno excluído");
                }

                gravar();
            } else {
                System.out.println("Aluno não encontrado");
            }

            arqentrada.close();
        } catch (Exception e) {
            System.out.println("Erro na exclusão");
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
