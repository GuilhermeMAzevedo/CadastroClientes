import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Repository r = new Repository();
        Service s = new Service(r);
        int opcao;
        do {
            System.out.println("1 - Casdastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Atualizar");
            System.out.println("4 - Deletar");
            System.out.println("5 - Buscar por ID");
            System.out.println("0 - Sair");
            System.out.print("Digite sua escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();
            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome: ");
                    String nome1 = sc.nextLine();
                    System.out.println("Digite o email: ");
                    String email1 = sc.nextLine();
                    System.out.println("Digite o telefone: ");
                    String telefone1 = sc.nextLine();

                    s.create(nome1, email1, telefone1);
                    break;
                case 2:
                    System.out.println(s.listAll());
                    break;
                case 3:
                    System.out.print("Digite o ID que deseja alterar: ");
                    String id3 = sc.nextLine();
                    System.out.print("Digite o novo nome: ");
                    String nome3 = sc.nextLine();
                    System.out.print("Digite o novo email: ");
                    String email3 = sc.nextLine();
                    System.out.print("Digite o novo telefone: ");
                    String telefone3 = sc.nextLine();
                    s.update(id3, nome3, email3, telefone3);
                    break;
                case 4:
                    System.out.print("Digite o ID que deseja deletar: ");
                    String id4 = sc.nextLine();
                    s.delete(id4);
                    System.out.println(s.listAll());

                    break;
                case 5:
                    System.out.print("Digite o ID que deseja buscar: ");
                    String id5 = sc.nextLine();
                    System.out.println(s.findById(id5));

                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + opcao);
            }
        } while (opcao != 0);
        sc.close();
    }
}
