package view;

import model.Conta;

public class ContaView {
    public void imprimirConta(Conta conta) {
        if (conta != null) {
            System.out.println("ID: " + conta.getId());
            System.out.println("Nome: " + conta.getNome());
            System.out.println("Saldo: " + conta.getSaldo());
            System.out.println("-----------------------------");
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    public void imprimirTodasContas(Conta[] contas) {
        if (contas.length > 0) {
            System.out.println("Todas as contas:");
            for (Conta conta : contas) {
                imprimirConta(conta);
            }
        } else {
            System.out.println("Não há contas cadastradas.");
        }
    }
}


