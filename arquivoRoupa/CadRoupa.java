import java.io.*;

public class CadRoupa {
    public static void main(String[] args) {
        try {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter saida = new BufferedWriter(new FileWriter("c:/Roupa.txt", true));

            System.out.println("Digite o tipo de roupa");
            String roupa = entrada.readLine();
            System.out.println("Digite o tamanho");
            String tamanho = entrada.readLine();
            System.out.println("Digite a cor");
            String cor = entrada.readLine();
            System.out.println("Digite o modelo (masculino, feminino, unisex)");
            String modelo = entrada.readLine();

            RegRoupa novaRoupa = new RegRoupa(roupa, tamanho, cor, modelo);

            saida.write(novaRoupa.mostraRoupa() + "\t");
            saida.write(novaRoupa.mostraTamanho() + "\t");
            saida.write(novaRoupa.mostraCor() + "\t");
            saida.write(novaRoupa.mostraModelo() + "\n");

            saida.flush();
            saida.close();
        } catch (Exception e) {
            System.out.println("Erro de Gravação");
        }
    }
}
