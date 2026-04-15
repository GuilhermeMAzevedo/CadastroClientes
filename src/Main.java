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
                System.out.println("Digite o email (Ex: joao@exemplo.com): ");
                email = scanner.nextLine();
                Validator.validateEmail(email);
                service.validateEmailForCreate(email);
                break;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

        String telefone;
        while (true){
            try {
                System.out.println("Digite o telefone com o DDD (Ex: 11987654321): ");
                telefone = scanner.nextLine();
                Validator.validatePhone(telefone);
                break;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

        try{
            service.create(nome, email, telefone);
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

        String nome;
        while (true){
            try {
                System.out.print("Digite o novo nome (Ex: João da Silva): ");
                nome = scanner.nextLine();
                Validator.validateName(nome);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        String email;
        while (true) {
            try {
                System.out.print("Digite o novo email (Ex: joao@exemplo.com): ");
                email = scanner.nextLine();
                Validator.validateEmail(email);
                service.validateEmailForUpdate(id, email);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        String telefone;
        while (true) {
            try {
                System.out.print("Digite o novo telefone com o DDD(Ex: 11987654321): ");
                telefone = scanner.nextLine();
                Validator.validatePhone(telefone);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        try {
            service.update(id, nome, email, telefone);
            System.out.println("Cliente atualizado com sucesso!");
            System.out.println(service.listAll());
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

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
                service.findById(id);
                break;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
