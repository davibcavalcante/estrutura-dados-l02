import java.io.*;

public class ArqBuscaRoupa {
    static StringBuffer memoria = new StringBuffer();

    public static void main(String[] args) {
        try {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader arqentrada = new BufferedReader(new FileReader("c:/Roupa.txt"));

            System.out.println("Digite o tipo de roupa");
            String roupa = entrada.readLine();
            String tamanho = "", cor = "", modelo = "", linha = "";

            while ((linha = arqentrada.readLine()) != null) {
                memoria.append(linha + "\n");
            }

            int inicio = -1;
            inicio = memoria.indexOf(roupa);

            if (inicio != -1) {
                int ultimo = memoria.indexOf("\t", inicio);
                String tipoRoupa = ler(inicio, ultimo);
                int primeiro = ultimo + 1;
                ultimo = memoria.indexOf("\t", primeiro);
                tamanho = ler(primeiro, ultimo);
                primeiro = ultimo + 1;
                ultimo = memoria.indexOf("\t", primeiro);
                cor = ler(primeiro, ultimo);
                primeiro = ultimo + 1;
                int fim = memoria.indexOf("\n", primeiro);
                modelo = ler(primeiro, fim);

                RegRoupa roupaEncontrada = new RegRoupa(tipoRoupa, tamanho, cor, modelo);
                System.out.println("Roupa encontrada: " + tipoRoupa + ", Tamanho: " + tamanho + ", Cor: " + cor + ", Modelo: " + modelo);

                System.out.println("Deseja alterar o tamanho? (S/N)");
                String resp = entrada.readLine();
                if (resp.equalsIgnoreCase("S")) {
                    System.out.println("Digite o novo tamanho:");
                    tamanho = entrada.readLine();
                    roupaEncontrada.alteraTamanho(tamanho);
                }

                System.out.println("Deseja alterar a cor? (S/N)");
                resp = entrada.readLine();
                if (resp.equalsIgnoreCase("S")) {
                    System.out.println("Digite a nova cor:");
                    cor = entrada.readLine();
                    roupaEncontrada.alteraCor(cor);
                }

                memoria.replace(inicio, fim, roupaEncontrada.mostraRoupa() + "\t" + roupaEncontrada.mostraTamanho() + "\t" + roupaEncontrada.mostraCor() + "\t" + roupaEncontrada.mostraModelo());
                gravar();
            } else {
                System.out.println("Roupa não encontrada");
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
            BufferedWriter saida = new BufferedWriter(new FileWriter("c:/Roupa.txt"));
            saida.write(memoria.toString());
            saida.flush();
            saida.close();
        } catch (Exception e) {
            System.out.println("Erro ao gravar");
        }
    }
}
