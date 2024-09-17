import java.io.*;

public class CadCliente {
    public static void main(String[] args) {
        try {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter saida = new BufferedWriter(new FileWriter("c:/Cliente.txt", true));

            System.out.println("Digite o nome do cliente");
            String cliente = entrada.readLine();
            System.out.println("Digite o dia da semana");
            String diaSemana = entrada.readLine();
            System.out.println("Digite o horário");
            String horario = entrada.readLine();
            System.out.println("Digite o tipo de serviço (cabelo, barba, unha, etc)");
            String tipoServico = entrada.readLine();
            System.out.println("Digite o valor do serviço");
            String valor = entrada.readLine();

            RegCliente novoCliente = new RegCliente(cliente, diaSemana, horario, tipoServico, valor);

            saida.write(novoCliente.mostraCliente() + "\t");
            saida.write(novoCliente.mostraDiaSemana() + "\t");
            saida.write(novoCliente.mostraHorario() + "\t");
            saida.write(novoCliente.mostraTipoServico() + "\t");
            saida.write(novoCliente.mostraValor() + "\n");

            saida.flush();
            saida.close();
        } catch (Exception e) {
            System.out.println("Erro de Gravação");
        }
    }
}
