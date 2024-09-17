import java.io.*;

public class ArqBuscaProduto {
    static StringBuffer memoria = new StringBuffer();

    public static void main(String[] args) {
        try {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader arqentrada = new BufferedReader(new FileReader("C:/Users/davib/Desktop/DEV/Produto.txt"));

            System.out.println("Digite o nome do produto");
            String nome = entrada.readLine();
            String linha = "";
            String marca = "", unidade = "", valor = "", quantidade = "";

            while ((linha = arqentrada.readLine()) != null) {
                memoria.append(linha + "\n");
            }

            int inicio = -1;
            inicio = memoria.indexOf(nome);

            if (inicio != -1) {
                int ultimo = memoria.indexOf("\t", inicio);
                String produtoNome = ler(inicio, ultimo);
                int primeiro = ultimo + 1;
                ultimo = memoria.indexOf("\t", primeiro);
                marca = ler(primeiro, ultimo);
                primeiro = ultimo + 1;
                ultimo = memoria.indexOf("\t", primeiro);
                unidade = ler(primeiro, ultimo);
                primeiro = ultimo + 1;
                ultimo = memoria.indexOf("\t", primeiro);
                valor = ler(primeiro, ultimo);
                primeiro = ultimo + 1;
                int fim = memoria.indexOf("\n", primeiro);
                quantidade = ler(primeiro, fim);

                RegProduto produto = new RegProduto(produtoNome, marca, unidade, valor, quantidade);
                System.out.println("Produto encontrado: " + produtoNome + ", Marca: " + marca + ", Valor: " + valor);

                System.out.println("Deseja alterar o valor? (S/N)");
                String resp = entrada.readLine();
                if (resp.equalsIgnoreCase("S")) {
                    System.out.println("Digite o novo valor:");
                    valor = entrada.readLine();
                    produto.alteraValor(valor);
                }

                memoria.replace(inicio, fim, produto.mostraNome() + "\t" + produto.mostraMarca() + "\t" + produto.mostraUnidade() + "\t" + produto.mostraValor() + "\t" + produto.mostraQuantidade());
                gravar();
            } else {
                System.out.println("Produto não encontrado");
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
            BufferedWriter saida = new BufferedWriter(new FileWriter("C:/Users/davib/Desktop/DEV/Produto.txt"));
            saida.write(memoria.toString());
            saida.flush();
            saida.close();
        } catch (Exception e) {
            System.out.println("Erro ao gravar");
        }
    }
}
