import java.io.*;

public class ArqExcluiProduto {
    static StringBuffer memoria = new StringBuffer();

    public static void main(String[] args) {
        try {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader arqentrada = new BufferedReader(new FileReader("C:/Users/davib/Desktop/DEV/Produto.txt"));

            System.out.println("Digite o nome do produto");
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
                System.out.println("Deseja excluir o produto? (S/N)");
                System.out.println(linha);
                String resposta = entrada.readLine();

                if (resposta.equalsIgnoreCase("S")) {
                    memoria.delete(inicio, fim + 1);
                    System.out.println("Produto excluído");
                }

                gravar();
            } else {
                System.out.println("Produto não encontrado");
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
            BufferedWriter saida = new BufferedWriter(new FileWriter("C:/Users/davib/Desktop/DEV/Produto.txt"));
            saida.write(memoria.toString());
            saida.flush();
            saida.close();
        } catch (Exception e) {
            System.out.println("Erro ao gravar");
        }
    }
}
