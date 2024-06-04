package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Arquivo arquivo = new Arquivo();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Listar Clientes");
            System.out.println("3. Ordenar Clientes (A-Z)");
            System.out.println("4. Ordenar Clientes (Z-A)");
            System.out.println("5. Sair");
            System.out.print("Digite a opção desejada: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir o caractere de quebra de linha

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();
                    System.out.print("Endereço: ");
                    String endereco = scanner.nextLine();
                    System.out.print("Idade: ");
                    int idade = scanner.nextInt();
                    scanner.nextLine(); // Consumir o caractere de quebra de linha

                    Cliente cliente = new Cliente(nome, cpf, endereco, idade);
                    arquivo.escrever(cliente);
                    System.out.println("Cliente cadastrado com sucesso!");
                    break;
                case 2:
                    ArrayList<Cliente> listaClientes = arquivo.ler();
                    if (listaClientes.isEmpty()) {
                        System.out.println("Nenhum cliente cadastrado.");
                    } else {
                        for (Cliente c : listaClientes) {
                            System.out.println("Nome: " + c.nome);
                            System.out.println("CPF: " + c.cpf);
                            System.out.println("Endereço: " + c.endereco);
                            System.out.println("Idade: " + c.idade);
                            System.out.println("---------------------");
                        }
                    }
                    break;
                case 3:
                    listaClientes = arquivo.ler();
                    if (listaClientes.isEmpty()) {
                        System.out.println("Nenhum cliente cadastrado.");
                    } else {
                        Collections.sort(listaClientes, (c1, c2) -> c1.nome.compareToIgnoreCase(c2.nome));
                        System.out.println("Clientes ordenados em ordem alfabética:");
                        for (Cliente c : listaClientes) {
                            System.out.println("Nome: " + c.nome);
                            System.out.println("CPF: " + c.cpf);
                            System.out.println("Endereço: " + c.endereco);
                            System.out.println("Idade: " + c.idade);
                            System.out.println("---------------------");
                        }
                    }
                    break;
                case 4:
                    listaClientes = arquivo.ler();
                    if (listaClientes.isEmpty()) {
                        System.out.println("Nenhum cliente cadastrado.");
                    } else {
                        Collections.sort(listaClientes, (c1, c2) -> c2.nome.compareToIgnoreCase(c1.nome));
                        System.out.println("Clientes ordenados em ordem inversa:");
                        for (Cliente c : listaClientes) {
                            System.out.println("Nome: " + c.nome);
                            System.out.println("CPF: " + c.cpf);
                            System.out.println("Endereço: " + c.endereco);
                            System.out.println("Idade: " + c.idade);
                            System.out.println("---------------------");
                        }
                    }
                    break;
                case 5:
                    System.out.println("Saindo do sistema. Até logo!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}