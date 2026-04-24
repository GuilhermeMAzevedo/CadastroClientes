package com.cadastroclientes.main;

import com.cadastroclientes.repository.Repository;
import com.cadastroclientes.service.Service;
import com.cadastroclientes.util.Validator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static Scanner scanner;
    private static Service service;
    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        Repository repository = new Repository();
        service = new Service(repository);
        int opcao = -1;
        do {
            opcao = obterOpcaoMenu();

            switch (opcao) {
                case 1:
                    cadastrarCliente();
                    break;
                case 2:
                    listarClientes();
                    break;
                case 3:
                    atualizarCliente();
                    break;
                case 4:
                    deletarCliente();
                    break;
                case 5:
                    buscarCliente();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Erro: Digite uma das opções válidas");
            }
        } while (opcao != 0);
        scanner.close();
    }
    private static void exibirMenu(){
        System.out.println("\n==========MENU==========");
        System.out.println("1 - Cadastrar Cliente");
        System.out.println("2 - Listar Clientes");
        System.out.println("3 - Atualizar Dados de um Cliente");
        System.out.println("4 - Deletar Cliente");
        System.out.println("5 - Buscar Cliente por ID");
        System.out.println("0 - Sair");
        System.out.println("========================\n");
    }

    private static int obterOpcaoMenu(){
        while (true){
            try {
                exibirMenu();
                System.out.print("Digite a sua escolha: ");
                int opcao = scanner.nextInt();
                scanner.nextLine();
                return opcao;
            } catch (InputMismatchException e){
                System.out.println("Erro: Digite apenas números inteiros");
                scanner.nextLine();
            }
        }
    }

    private static void cadastrarCliente(){
        System.out.println("------Cadastrar Novo Cliente------");
        String nome;
        while (true){
            try {
                System.out.println("Digite o nome (Ex: João da Silva): ");
                nome = scanner.nextLine();
                Validator.validateName(nome);
                break;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

        String email;
        while (true){
            try {
                System.out.println("Digite o e-mail (Ex: joao@exemplo.com): ");
                email = scanner.nextLine();
                Validator.validateEmail(email);
                service.validateEmailForCreate(email);
                break;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

        String celular;
        while (true){
            try {
                System.out.println("Digite o celular celular com o DDD (Ex: 11987654321): ");
                celular = scanner.nextLine();
                Validator.validatePhone(celular);
                break;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

        try{
            service.create(nome, email, celular);
            System.out.println(service.listAll());
            System.out.println("Cliente cadastrado com sucesso!");
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            System.out.println("Tente novamente");
        }
    }

    private static void listarClientes(){
        try {
            System.out.println(service.listAll());
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    private static void exibirMenuAtualizarDados(){
        System.out.println("\n------Atualizar Dados do Cliente------");
        System.out.println("Quais dados do cliente você deseja alterar?");
        System.out.println("1 - Nome");
        System.out.println("2 - E-mail");
        System.out.println("3 - Celular");
        System.out.println("0 - Voltar");
    }

    private static void atualizarCliente(){
        try {
            System.out.println(service.listAll());
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return;
        }
        String id;
        while (true){
            try {
                System.out.print("Digite o ID que deseja alterar: ");
                id = scanner.nextLine();
                Validator.validateId(id);
                System.out.println(service.findById(id));
                break;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

        int opcaoAtualizar = -1;
        do {
            while (true){
                try {
                    exibirMenuAtualizarDados();
                    System.out.print("Digite a sua escolha: ");
                    opcaoAtualizar = scanner.nextInt();
                    scanner.nextLine();
                    break;
                } catch (InputMismatchException e){
                    System.out.println("Erro: Digite apenas números inteiros");
                }
            }
            String nome = service.findById(id).getName();
            String email = service.findById(id).getEmail();
            String celular = service.findById(id).getPhone();
            switch (opcaoAtualizar) {
                case 1:
                    while (true) {
                        try {
                            System.out.print("Digite o novo nome (Ex: João da Silva): ");
                            nome = scanner.nextLine();
                            Validator.validateName(nome);
                            break;
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    try {
                        service.update(id, nome, email, celular);
                        System.out.println("Cliente atualizado com sucesso!");
                        System.out.println(service.findById(id));
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    while (true) {
                        try {
                            System.out.print("Digite o novo e-mail (Ex: joao@exemplo.com): ");
                            email = scanner.nextLine();
                            Validator.validateEmail(email);
                            service.validateEmailForUpdate(id, email);
                            break;
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    try {
                        service.update(id, nome, email, celular);
                        System.out.println("Cliente atualizado com sucesso!");
                        System.out.println(service.findById(id));
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    while (true) {
                        try {
                            System.out.print("Digite o novo telefone celular com o DDD(Ex: 11987654321): ");
                            celular = scanner.nextLine();
                            Validator.validatePhone(celular);
                            break;
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    try {
                        service.update(id, nome, email, celular);
                        System.out.println("Cliente atualizado com sucesso!");
                        System.out.println(service.findById(id));
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Erro: Digite uma das opções válidas");
            }
        } while (opcaoAtualizar != 0) ;

    }

    private static void deletarCliente(){
        try {
            System.out.println(service.listAll());
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return;
        }
        String id;
        while (true){
            try {
                System.out.print("Digite o ID que deseja deletar: ");
                id = scanner.nextLine();
                Validator.validateId(id);
                service.findById(id);
                break;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }

        }
        try {
            service.delete(id);
            System.out.println(service.listAll());
            System.out.println("Cliente deletado com sucesso!");
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    private static void buscarCliente(){
        try {
            service.listAll();
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return;
        }
        String id;
        while (true){
            try {
                System.out.print("Digite o ID que deseja buscar: ");
                id = scanner.nextLine();
                Validator.validateId(id);
                System.out.println(service.findById(id));
                break;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
