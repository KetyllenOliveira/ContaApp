import controller.ContaController;
import model.Conta;
import repository.ContaRepository;
import view.ContaView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ContaRepository repository = new ContaRepository(10);
        ContaView view = new ContaView();
        ContaController controller = new ContaController(repository, view);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao cadastro de contas!");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1 - Cadastrar conta");
            System.out.println("2 - Buscar conta");
            System.out.println("3 - Remover conta");
            System.out.println("4 - Alterar conta");
            System.out.println("5 - Verificar existência de conta");
            System.out.println("6 - Listar todas as contas");
            System.out.println("7 - Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do titular da conta: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite o saldo inicial da conta: ");
                    double saldo = scanner.nextDouble();
                    controller.inserirConta(nome, saldo);
                    break;
                case 2:
                    System.out.print("Digite o ID da conta: ");
                    int idBusca = scanner.nextInt();
                    controller.buscarConta(idBusca);
                    break;
                case 3:
                    System.out.print("Digite o ID da conta a ser removida: ");
                    int idRemover = scanner.nextInt();
                    controller.removerConta(idRemover);
                    break;
                case 4:
                    System.out.print("Digite o ID da conta a ser alterada: ");
                    int idAlterar = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer
                    System.out.print("Digite o novo nome do titular da conta: ");
                    String novoNome = scanner.nextLine();
                    System.out.print("Digite o novo saldo da conta: ");
                    double novoSaldo = scanner.nextDouble();
                    Conta contaAtualizada = new Conta(idAlterar, novoNome, novoSaldo);
                    controller.alterarConta(contaAtualizada);
                    break;
                case 5:
                    System.out.print("Digite o ID da conta a verificar: ");
                    int idVerificar = scanner.nextInt();
                    controller.verificarExistenciaConta(idVerificar);
                    break;
                case 6:
                    controller.listarTodasContas();
                    break;
                case 7:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }
}
