import java.io.*;

public class CadCompanhiaAerea {
    public static void main(String[] args) {
        try {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter saida = new BufferedWriter(new FileWriter("c:/CompanhiaAerea.txt", true));

            System.out.println("Digite o nome da companhia aérea");
            String companhiaAerea = entrada.readLine();
            System.out.println("Digite o número do voo");
            String numeroVoo = entrada.readLine();
            System.out.println("Digite o trecho do voo (cidade de partida - cidade de chegada)");
            String trechoVoo = entrada.readLine();
            System.out.println("Digite o horário de saída");
            String horarioSaida = entrada.readLine();
            System.out.println("Digite o horário de chegada");
            String horarioChegada = entrada.readLine();

            RegCompanhiaAerea voo = new RegCompanhiaAerea(companhiaAerea, numeroVoo, trechoVoo, horarioSaida, horarioChegada);

            saida.write(voo.mostraCompanhiaAerea() + "\t");
            saida.write(voo.mostraNumeroVoo() + "\t");
            saida.write(voo.mostraTrechoVoo() + "\t");
            saida.write(voo.mostraHorarioSaida() + "\t");
            saida.write(voo.mostraHorarioChegada() + "\n");

            saida.flush();
            saida.close();
        } catch (Exception e) {
            System.out.println("Erro de Gravação");
        }
    }
}
