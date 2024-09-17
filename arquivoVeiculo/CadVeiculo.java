import java.io.*;

public class CadVeiculo {
    public static void main(String[] args) {
        try {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter saida = new BufferedWriter(new FileWriter("C:/Users/davib/Desktop/DEV/Veiculo.txt", true));

            System.out.println("Digite o nome do veículo");
            String nome = entrada.readLine();
            System.out.println("Digite a marca");
            String marca = entrada.readLine();
            System.out.println("Digite o ano");
            String ano = entrada.readLine();
            System.out.println("Digite a cor");
            String cor = entrada.readLine();

            RegVeiculo veiculo = new RegVeiculo(nome, marca, ano, cor);

            saida.write(veiculo.mostraNome() + "\t");
            saida.write(veiculo.mostraMarca() + "\t");
            saida.write(veiculo.mostraAno() + "\t");
            saida.write(veiculo.mostraCor() + "\n");

            saida.flush();
            saida.close();
        } catch (Exception e) {
            System.out.println("Erro de Gravação");
        }
    }
}
