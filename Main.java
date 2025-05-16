package usermanagement;

import java.util.List;
import java.util.Scanner;

/**
 * Interface de linha de comando para interagir com o usuário.
 */
public class Main {
    private static final String DATA_FILENAME = "users.txt";

    public static void main(String[] args) {
        UserService service = new UserService(DATA_FILENAME);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== SISTEMA DE CADASTRO DE USUÁRIOS ===");
            System.out.println("1. Cadastrar usuário");
            System.out.println("2. Editar usuário");
            System.out.println("3. Excluir usuário");
            System.out.println("4. Listar usuários");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            String opt = scanner.nextLine();
            switch (opt) {
                case "1":
                    cadastrar(service, scanner);
                    break;
                case "2":
                    editar(service, scanner);
                    break;
                case "3":
                    excluir(service, scanner);
                    break;
                case "4":
                    listar(service);
                    break;
                case "5":
                    service.saveUsers();
                    System.out.println("Dados salvos. Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void cadastrar(UserService service, Scanner sc) {
        System.out.print("Nome: ");
        String nome = sc.nextLine().trim();
        System.out.print("Email: ");
        String email = sc.nextLine().trim();

        User u = service.create(nome, email);
        System.out.println("Usuário cadastrado: " + u);
    }

    private static void editar(UserService service, Scanner sc) {
        System.out.print("ID do usuário a editar: ");
        int id = Integer.parseInt(sc.nextLine());
        User u = service.findById(id);
        if (u == null) {
            System.out.println("Usuário não encontrado.");
            return;
        }
        System.out.print("Novo nome (atual: " + u.getName() + "): ");
        String nome = sc.nextLine().trim();
        System.out.print("Novo email (atual: " + u.getEmail() + "): ");
        String email = sc.nextLine().trim();

        if (service.update(id, nome.isEmpty() ? u.getName() : nome,
                                email.isEmpty() ? u.getEmail() : email)) {
            System.out.println("Usuário atualizado.");
        } else {
            System.out.println("Falha ao atualizar.");
        }
    }

    private static void excluir(UserService service, Scanner sc) {
        System.out.print("ID do usuário a excluir: ");
        int id = Integer.parseInt(sc.nextLine());
        if (service.delete(id)) {
            System.out.println("Usuário excluído.");
        } else {
            System.out.println("Usuário não encontrado.");
        }
    }

    private static void listar(UserService service) {
        List<User> all = service.listAll();
        if (all.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
        } else {
            System.out.println("\n--- Lista de Usuários ---");
            all.forEach(u -> System.out.println(u));
        }
    }
}
