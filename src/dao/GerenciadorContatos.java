package dao;

import models.Contato;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;

public class GerenciadorContatos {
    public static void save(Contato contato) {
        String linha = contato.getNome() + ";" + contato.getTelefone() + ";" + contato.getEmail();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("contatos.txt", true))) {
            writer.write(linha);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Erro ao salvar contato: " + e.getMessage());
        }
    }

    public static void remove(String nomeContato) {
        File inputFile = new File("contatos.txt");
        File tempFile = new File("contatos_temp.txt");
        boolean contatoEncontrado = false;

        try (
                BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))
        ) {
            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                String nome = currentLine.split(";")[0];

                if (!nome.equalsIgnoreCase(nomeContato)) {
                    writer.write(currentLine);
                    writer.newLine();
                } else {
                    contatoEncontrado = true;
                    System.out.println("Contato removido com sucesso!");
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao remover contato: " + e.getMessage());
            return;
        }

        if (!contatoEncontrado) {
            System.out.println("O contato '" + nomeContato + "' não foi encontrado.");
            return;
        }

        if (!inputFile.delete()) {
            System.err.println("Não foi possível remover o contato antigo.");
            return;
        }
        if (!tempFile.renameTo(inputFile)) {
            System.err.println("Não foi possível atualizar os contatos.");
        }
    }

    public static void listar() {
        File inputFile = new File("contatos.txt");

        try (
                BufferedReader reader = new BufferedReader(new FileReader(inputFile))
        ) {
            String currentLine;

            System.out.println("Listando contatos:");
            while ((currentLine = reader.readLine()) != null) {
                String[] contatoInfo = currentLine.split(";");

                if (contatoInfo.length == 3) {
                    String nome = contatoInfo[0];
                    String telefone = contatoInfo[1];
                    String email = contatoInfo[2];
                    System.out.println("Nome: " + nome + ", Telefone: " + telefone + ", Email: " + email);
                } else {
                    System.out.println("Contato inválido encontrado e ignorado: " + currentLine);
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao listar contatos: " + e.getMessage());
        }
    }
}
