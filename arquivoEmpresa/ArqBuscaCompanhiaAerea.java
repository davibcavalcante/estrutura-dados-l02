import java.io.*;

public class ArqBuscaCompanhiaAerea {
    static StringBuffer memoria = new StringBuffer();

    public static void main(String[] args) {
        try {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader arqentrada = new BufferedReader(new FileReader("c:/CompanhiaAerea.txt"));

            System.out.println("Digite o nome da companhia aérea");
            String companhiaAerea = entrada.readLine();
            String numeroVoo = "", trechoVoo = "", horarioSaida = "", horarioChegada = "", linha = "";

            while ((linha = arqentrada.readLine()) != null) {
                memoria.append(linha + "\n");
            }

            int inicio = -1;
            inicio = memoria.indexOf(companhiaAerea);

            if (inicio != -1) {
                int ultimo = memoria.indexOf("\t", inicio);
                String nomeCompanhia = ler(inicio, ultimo);
                int primeiro = ultimo + 1;
                ultimo = memoria.indexOf("\t", primeiro);
                numeroVoo = ler(primeiro, ultimo);
                primeiro = ultimo + 1;
                ultimo = memoria.indexOf("\t", primeiro);
                trechoVoo = ler(primeiro, ultimo);
                primeiro = ultimo + 1;
                ultimo = memoria.indexOf("\t", primeiro);
                horarioSaida = ler(primeiro, ultimo);
                primeiro = ultimo + 1;
                int fim = memoria.indexOf("\n", primeiro);
                horarioChegada = ler(primeiro, fim);

                RegCompanhiaAerea voo = new RegCompanhiaAerea(nomeCompanhia, numeroVoo, trechoVoo, horarioSaida, horarioChegada);
                System.out.println("Companhia encontrada: " + nomeCompanhia + ", Voo: " + numeroVoo + ", Trecho: " + trechoVoo + ", Saída: " + horarioSaida + ", Chegada: " + horarioChegada);

                System.out.println("Deseja alterar o trecho do voo? (S/N)");
                String resp = entrada.readLine();
                if (resp.equalsIgnoreCase("S")) {
                    System.out.println("Digite o novo trecho:");
                    trechoVoo = entrada.readLine();
                    voo.alteraTrechoVoo(trechoVoo);
                }

                memoria.replace(inicio, fim, voo.mostraCompanhiaAerea() + "\t" + voo.mostraNumeroVoo() + "\t" + voo.mostraTrechoVoo() + "\t" + voo.mostraHorarioSaida() + "\t" + voo.mostraHorarioChegada());
                gravar();
            } else {
                System.out.println("Companhia não encontrada");
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
            BufferedWriter saida = new BufferedWriter(new FileWriter("c:/CompanhiaAerea.txt"));
            saida.write(memoria.toString());
            saida.flush();
            saida.close();
        } catch (Exception e) {
            System.out.println("Erro ao gravar");
        }
    }
}
