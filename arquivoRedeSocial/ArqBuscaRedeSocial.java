import java.io.*;

public class ArqBuscaRedeSocial {
    static StringBuffer memoria = new StringBuffer();

    public static void main(String[] args) {
        try {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader arqentrada = new BufferedReader(new FileReader("c:/RedeSocial.txt"));

            System.out.println("Digite o nome da rede social");
            String redeSocial = entrada.readLine();
            String nome = "", quantSeguidores = "", assunto = "", linha = "";

            while ((linha = arqentrada.readLine()) != null) {
                memoria.append(linha + "\n");
            }

            int inicio = -1;
            inicio = memoria.indexOf(redeSocial);

            if (inicio != -1) {
                int ultimo = memoria.indexOf("\t", inicio);
                String redeSocialNome = ler(inicio, ultimo);
                int primeiro = ultimo + 1;
                ultimo = memoria.indexOf("\t", primeiro);
                nome = ler(primeiro, ultimo);
                primeiro = ultimo + 1;
                ultimo = memoria.indexOf("\t", primeiro);
                quantSeguidores = ler(primeiro, ultimo);
                primeiro = ultimo + 1;
                int fim = memoria.indexOf("\n", primeiro);
                assunto = ler(primeiro, fim);

                RegRedeSocial redeSocialObj = new RegRedeSocial(redeSocialNome, nome, quantSeguidores, assunto);
                System.out.println("Rede Social encontrada: " + redeSocialNome + ", Nome: " + nome + ", Seguidores: " + quantSeguidores + ", Assunto: " + assunto);

                System.out.println("Deseja alterar o assunto? (S/N)");
                String resp = entrada.readLine();
                if (resp.equalsIgnoreCase("S")) {
                    System.out.println("Digite o novo assunto:");
                    assunto = entrada.readLine();
                    redeSocialObj.alteraAssunto(assunto);
                }

                memoria.replace(inicio, fim, redeSocialObj.mostraRedeSocial() + "\t" + redeSocialObj.mostraNome() + "\t" + redeSocialObj.mostraQuantSeguidores() + "\t" + redeSocialObj.mostraAssunto());
                gravar();
            } else {
                System.out.println("Rede Social não encontrada");
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
            BufferedWriter saida = new BufferedWriter(new FileWriter("c:/RedeSocial.txt"));
            saida.write(memoria.toString());
            saida.flush();
            saida.close();
        } catch (Exception e) {
            System.out.println("Erro ao gravar");
        }
    }
}
