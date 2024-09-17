import java.io.*;

public class ArqExcluiRedeSocial {
    static StringBuffer memoria = new StringBuffer();

    public static void main(String[] args) {
        try {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader arqentrada = new BufferedReader(new FileReader("c:/RedeSocial.txt"));

            System.out.println("Digite o nome da rede social");
            String redeSocial = entrada.readLine();
            String linha = "";

            while ((linha = arqentrada.readLine()) != null) {
                memoria.append(linha + "\n");
            }

            int inicio = -1;
            inicio = memoria.indexOf(redeSocial);

            if (inicio != -1) {
                int fim = memoria.indexOf("\n", inicio);
                linha = ler(inicio, fim);
                System.out.println("Deseja excluir a rede social? (S/N)");
                System.out.println(linha);
                String resposta = entrada.readLine();

                if (resposta.equalsIgnoreCase("S")) {
                    memoria.delete(inicio, fim + 1);
                    System.out.println("Rede Social excluída");
                }

                gravar();
            } else {
                System.out.println("Rede Social não encontrada");
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
            BufferedWriter saida = new BufferedWriter(new FileWriter("c:/RedeSocial.txt"));
            saida.write(memoria.toString());
            saida.flush();
            saida.close();
        } catch (Exception e) {
            System.out.println("Erro ao gravar");
        }
    }
}