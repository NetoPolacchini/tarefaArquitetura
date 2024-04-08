import dao.GerenciadorContatos;
import models.Contato;


import java.util.Scanner;

public class SistemaContatosCLI {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Sistema de Gerenciamento de Contatos");

        boolean sair = false;

        while (!sair) {
            System.out.println("\nComandos disponíveis:");
            System.out.println("1 - Listar todos os contatos");
            System.out.println("2 - Adicionar um novo contato");
            System.out.println("3 - Remover um contato");
            System.out.println("4 - Sair");

            System.out.print("Digite o número do comando desejado: ");
            int comando = scanner.nextInt();
            scanner.nextLine();

            switch (comando) {
                case 1:
                    GerenciadorContatos.listar();
                    break;
                case 2:
                    System.out.print("Digite o nome do contato: ");
                    String nome = scanner.nextLine();

                    System.out.print("Digite o telefone do contato: ");
                    String telefone = scanner.nextLine();

                    System.out.print("Digite o email do contato: ");
                    String email = scanner.nextLine();

                    Contato novoContato = new Contato(nome, telefone, email);
                    GerenciadorContatos.save(novoContato);
                    System.out.println("Contato adicionado com sucesso!");
                    break;
                case 3:
                    System.out.print("Digite o nome do contato a ser removido: ");
                    String nomeParaRemover = scanner.nextLine();

                    GerenciadorContatos.remove(nomeParaRemover);

                    break;
                case 4:
                    sair = true;
                    break;
                default:
                    System.out.println("Comando não reconhecido.");
            }

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.err.println("Erro ao pausar a thread: " + e.getMessage());
            }

        }

        scanner.close();
        System.out.println("Sistema de Gerenciamento de Contatos encerrado.");
    }
}
