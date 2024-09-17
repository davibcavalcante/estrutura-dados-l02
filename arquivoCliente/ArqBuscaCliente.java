import java.io.*;

public class ArqBuscaCliente {
    static StringBuffer memoria = new StringBuffer();

    public static void main(String[] args) {
        try {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader arqentrada = new BufferedReader(new FileReader("c:/Cliente.txt"));

            System.out.println("Digite o nome do cliente");
            String cliente = entrada.readLine();
            String diaSemana = "", horario = "", tipoServico = "", valor = "", linha = "";

            while ((linha = arqentrada.readLine()) != null) {
                memoria.append(linha + "\n");
            }

            int inicio = -1;
            inicio = memoria.indexOf(cliente);

            if (inicio != -1) {
                int ultimo = memoria.indexOf("\t", inicio);
                String nomeCliente = ler(inicio, ultimo);
                int primeiro = ultimo + 1;
                ultimo = memoria.indexOf("\t", primeiro);
                diaSemana = ler(primeiro, ultimo);
                primeiro = ultimo + 1;
                ultimo = memoria.indexOf("\t", primeiro);
                horario = ler(primeiro, ultimo);
                primeiro = ultimo + 1;
                ultimo = memoria.indexOf("\t", primeiro);
                tipoServico = ler(primeiro, ultimo);
                primeiro = ultimo + 1;
                int fim = memoria.indexOf("\n", primeiro);
                valor = ler(primeiro, fim);

                RegCliente clienteEncontrado = new RegCliente(nomeCliente, diaSemana, horario, tipoServico, valor);
                System.out.println("Cliente encontrado: " + nomeCliente + ", Dia: " + diaSemana + ", Horário: " + horario + ", Serviço: " + tipoServico + ", Valor: " + valor);

                System.out.println("Deseja alterar o dia da semana? (S/N)");
                String resp = entrada.readLine();
                if (resp.equalsIgnoreCase("S")) {
                    System.out.println("Digite o novo dia da semana:");
                    diaSemana = entrada.readLine();
                    clienteEncontrado.alteraDiaSemana(diaSemana);
                }

                System.out.println("Deseja alterar o horário? (S/N)");
                resp = entrada.readLine();
                if (resp.equalsIgnoreCase("S")) {
                    System.out.println("Digite o novo horário:");
                    horario = entrada.readLine();
                    clienteEncontrado.alteraHorario(horario);
                }

                System.out.println("Deseja alterar o tipo de serviço? (S/N)");
                resp = entrada.readLine();
                if (resp.equalsIgnoreCase("S")) {
                    System.out.println("Digite o novo tipo de serviço:");
                    tipoServico = entrada.readLine();
                    clienteEncontrado.alteraTipoServico(tipoServico);
                }

                System.out.println("Deseja alterar o valor? (S/N)");
                resp = entrada.readLine();
                if (resp.equalsIgnoreCase("S")) {
                    System.out.println("Digite o novo valor:");
                    valor = entrada.readLine();
                    clienteEncontrado.alteraValor(valor);
                }

                memoria.replace(inicio, fim, clienteEncontrado.mostraCliente() + "\t" + clienteEncontrado.mostraDiaSemana() + "\t" + clienteEncontrado.mostraHorario() + "\t" + clienteEncontrado.mostraTipoServico() + "\t" + clienteEncontrado.mostraValor());
                gravar();
            } else {
                System.out.println("Cliente não encontrado");
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
            BufferedWriter saida = new BufferedWriter(new FileWriter("c:/Cliente.txt"));
            saida.write(memoria.toString());
            saida.flush();
            saida.close();
        } catch (Exception e) {
            System.out.println("Erro ao gravar");
        }
    }
}
