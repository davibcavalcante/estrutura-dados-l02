import java.io.*;

public class ArqBusca {
    static StringBuffer memoria = new StringBuffer();

    public static void main(String[] args) {
        try {
            BufferedReader entrada;
            entrada = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader arqentrada;
            arqentrada = new BufferedReader(new FileReader("c:/Agenda.txt"));

            System.out.println("Digite o nome");
            String nome = entrada.readLine();
            String endereco = "";
            String telefone = "";
            String linha = "";

            while ((linha = arqentrada.readLine()) != null) {
                memoria.append(linha + "\n");
            }

            int inicio = -1;
            inicio = memoria.indexOf(nome);

            if (inicio != -1) {
                int ultimo = memoria.indexOf("\t", inicio);
                String Nome = ler(inicio, ultimo);
                int primeiro = ultimo + 1;
                ultimo = memoria.indexOf("\t", primeiro);
                endereco = ler(primeiro, ultimo);
                primeiro = ultimo + 1;
                int fim = memoria.indexOf("\n", primeiro);
                telefone = ler(primeiro, fim);

                regAgenda regAg1 = new regAgenda(Nome, endereco, telefone);
                System.out.println("Endereço: " + regAg1.mostraEnd() +
                        "Telefone: " + regAg1.mostraTel());
                System.out.println("Entre com novo endereço");
                endereco = entrada.readLine();
                regAg1.alteraEnd(endereco);
                System.out.println("Entre com novo telefone");
                telefone = entrada.readLine();
                regAg1.alteraTel(telefone);
                memoria.replace(inicio, fim, regAg1.mostraNome() + "\t" +
                        regAg1.mostraEnd() + "\t" + regAg1.mostraTel());
                gravar();
                arqentrada.close();
            } else {
                System.out.println("Item não encontrado");
            }
            arqentrada.close();
        } catch (FileNotFoundException erro) {
            System.out.println("Arquivo não encontrado!");
        } catch (Exception erro) {
            System.out.println("Erro de Leitura !");
        }
    }

    public static String ler(int primeiro, int ultimo) {
        String dados = "";
        char[] destino = new char[ultimo - primeiro];
        memoria.getChars(primeiro, ultimo, destino, 0);
        for (int i = 0; i < destino.length; i++) {
            dados += destino[i];
        }
        return dados;
    }

    public static void gravar() {
        try {
            BufferedWriter saida;
            saida = new BufferedWriter(new FileWriter("c:/Agenda.txt"));
            saida.write(memoria.toString());
            saida.flush();
            saida.close();
        } catch (Exception erro) {
            System.out.println("Erro de gravação!");
        }
    }
}
