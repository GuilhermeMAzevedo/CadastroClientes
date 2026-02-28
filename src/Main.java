import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Repository r = new Repository();
        Service s = new Service(r);
        int opcao = -1;
        do {
            try {
                System.out.println("1 - Casdastrar");
                System.out.println("2 - Listar");
                System.out.println("3 - Atualizar");
                System.out.println("4 - Deletar");
                System.out.println("5 - Buscar por ID");
                System.out.println("0 - Sair");
                System.out.print("Digite sua escolha: ");
                opcao = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e){
                System.out.println("Erro: Digite apenas números inteiros");
                sc.nextLine();
                continue;
            }


            switch (opcao) {
                case 1:
                    String nome1;
                    while (true){
                        try {
                            System.out.println("Digite o nome (Ex: João da Silva): ");
                            nome1 = sc.nextLine();
                            Validator.validateName(nome1);
                            break;
                        } catch (IllegalArgumentException e){
                            System.out.println(e.getMessage());
                        }
                    }

                    String email1;
                    while (true){
                       try {
                           System.out.println("Digite o email (Ex: joao@exemplo.com): ");
                           email1 = sc.nextLine();
                           Validator.validateEmail(email1);
                           s.validateEmailForCreate(email1);
                           break;
                       } catch (IllegalArgumentException e){
                           System.out.println(e.getMessage());
                       }
                    }

                    String telefone1;
                    while (true){
                        try {
                            System.out.println("Digite o telefone com o DDD (Ex: 11987654321): ");
                            telefone1 = sc.nextLine();
                            Validator.validatePhone(telefone1);
                            break;
                        }catch (IllegalArgumentException e){
                            System.out.println(e.getMessage());
                        }
                    }

                    try{
                        s.create(nome1, email1, telefone1);
                        System.out.println(s.listAll());
                    } catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                        System.out.println("Tente novamente");
                    }

                    break;
                case 2:
                    try {
                        System.out.println(s.listAll());
                    } catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }

                    break;
                case 3:
                    String id3;
                    try {
                        s.listAll();
                    } catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                        continue;
                    }
                    while (true){
                        try {
                            System.out.print("Digite o ID que deseja alterar: ");
                            id3 = sc.nextLine();
                            Validator.validateId(id3);
                            System.out.println(s.findById(id3));
                            break;
                        } catch (IllegalArgumentException e){
                            System.out.println(e.getMessage());
                        }
                    }

                    String nome3;
                    while (true){
                        try {
                            System.out.print("Digite o novo nome (Ex: João da Silva): ");
                            nome3 = sc.nextLine();
                            Validator.validateName(nome3);
                            break;
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }

                    String email3;
                    while (true) {
                        try {
                            System.out.print("Digite o novo email (Ex: joao@exemplo.com): ");
                            email3 = sc.nextLine();
                            Validator.validateEmail(email3);
                            s.validateEmailForCreate(email3);
                            break;
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }

                    String telefone3;
                    while (true) {
                        try {
                            System.out.print("Digite o novo telefone com o DDD(Ex: 11987654321): ");
                            telefone3 = sc.nextLine();
                            Validator.validatePhone(telefone3);
                            break;
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    try {
                        s.update(id3, nome3, email3, telefone3);
                        System.out.println("Atualizado com sucesso!");
                        System.out.println(s.listAll());
                    } catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }

                    break;
                case 4:
                    try {
                        System.out.println(s.listAll());
                    } catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                        continue;
                    }
                    String id4;
                    while (true){
                        try {
                            System.out.print("Digite o ID que deseja deletar: ");
                            id4 = sc.nextLine();
                            Validator.validateId(id4);
                            s.findById(id4);
                            break;
                        } catch (IllegalArgumentException e){
                            System.out.println(e.getMessage());
                        }

                    }
                    try {
                        s.delete(id4);
                        System.out.println(s.listAll());
                    } catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }

                    break;
                case 5:
                    try {
                        s.listAll();
                    } catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                        continue;
                    }
                    String id5;
                    while (true){
                        try {
                            System.out.print("Digite o ID que deseja buscar: ");
                            id5 = sc.nextLine();
                            Validator.validateId(id5);
                            s.findById(id5);
                            break;
                        } catch (IllegalArgumentException e){
                            System.out.println(e.getMessage());
                        }
                    }
                    try {
                        System.out.println(s.findById(id5));
                    } catch (IllegalArgumentException e){
                        System.out.println(e.getMessage()   );
                    }

                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Erro: Digite uma das opções válidas");
            }
        } while (opcao != 0);
        sc.close();
    }
}
