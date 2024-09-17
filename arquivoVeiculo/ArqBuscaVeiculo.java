import java.io.*;

public class ArqBuscaVeiculo {
    static StringBuffer memoria = new StringBuffer();

    public static void main(String[] args) {
        try {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader arqentrada = new BufferedReader(new FileReader("C:/Users/davib/Desktop/DEV/Veiculo.txt"));

            System.out.println("Digite o nome do veículo");
            String nome = entrada.readLine();
            String linha = "";
            String marca = "", ano = "", cor = "";

            while ((linha = arqentrada.readLine()) != null) {
                memoria.append(linha + "\n");
            }

            int inicio = -1;
            inicio = memoria.indexOf(nome);

            if (inicio != -1) {
                int ultimo = memoria.indexOf("\t", inicio);
                String veiculoNome = ler(inicio, ultimo);
                int primeiro = ultimo + 1;
                ultimo = memoria.indexOf("\t", primeiro);
                marca = ler(primeiro, ultimo);
                primeiro = ultimo + 1;
                ultimo = memoria.indexOf("\t", primeiro);
                ano = ler(primeiro, ultimo);
                primeiro = ultimo + 1;
                int fim = memoria.indexOf("\n", primeiro);
                cor = ler(primeiro, fim);

                RegVeiculo veiculo = new RegVeiculo(veiculoNome, marca, ano, cor);
                System.out.println("Veículo encontrado: " + veiculoNome + ", Marca: " + marca + ", Ano: " + ano + ", Cor: " + cor);

                System.out.println("Deseja alterar a cor? (S/N)");
                String resp = entrada.readLine();
                if (resp.equalsIgnoreCase("S")) {
                    System.out.println("Digite a nova cor:");
                    cor = entrada.readLine();
                    veiculo.alteraCor(cor);
                }

                memoria.replace(inicio, fim, veiculo.mostraNome() + "\t" + veiculo.mostraMarca() + "\t" + veiculo.mostraAno() + "\t" + veiculo.mostraCor());
                gravar();
            } else {
                System.out.println("Veículo não encontrado");
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
            BufferedWriter saida = new BufferedWriter(new FileWriter("C:/Users/davib/Desktop/DEV/Veiculo.txt"));
            saida.write(memoria.toString());
            saida.flush();
            saida.close();
        } catch (Exception e) {
            System.out.println("Erro ao gravar");
        }
    }
}
