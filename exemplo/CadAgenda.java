import java.io.*;

public class CadAgenda {
    public static void main(String[] args) {
        try {
            BufferedReader entrada;

            entrada = new BufferedReader(new InputStreamReader(System.in));

            BufferedWriter saida;
            saida = new BufferedWriter(new FileWriter("c:/Agenda.txt", true));

            System.out.println("Digite o nome");
            String Nome = entrada.readLine();
            System.out.println("Digite o endereço");
            String Endereco = entrada.readLine();
            System.out.println("Digite seu telefone");
            String Telefone = entrada.readLine();
            regAgenda regAg1 = new regAgenda(Nome, Endereco, Telefone);

            saida.write(regAg1.mostraNome() + "\t");
            saida.write(regAg1.mostraEnd() + "\t");
            saida.write(regAg1.mostraTel() + "\n");
            saida.flush();
            saida.close();
        } catch (Exception e) {
            System.out.println("Erro de Gravação");
        }
    }
}
