package controller;

import model.Conta;
import repository.ContaRepository;
import view.ContaView;

public class ContaController {
    private ContaRepository repository;
    private ContaView view;

    public ContaController(ContaRepository repository, ContaView view) {
        this.repository = repository;
        this.view = view;
    }

    public void inserirConta(String nome, double saldo) {
        Conta conta = new Conta();
        conta.setNome(nome);
        conta.setSaldo(saldo);
        repository.inserir(conta);
        view.imprimirConta(conta);
    }

    public Conta buscarConta(int id) {
        Conta conta = repository.buscar(id);
        view.imprimirConta(conta);
        return conta;
    }

    public boolean removerConta(int id) {
        boolean resultado = repository.remover(id);
        if (resultado) {
            System.out.println("Conta removida com sucesso.");
        } else {
            System.out.println("Conta não encontrada.");
        }
        return resultado;
    }

    public boolean alterarConta(Conta contaAtualizada) {
        boolean resultado = repository.alterar(contaAtualizada);
        if (resultado) {
            System.out.println("Conta alterada com sucesso.");
        } else {
            System.out.println("Conta não encontrada.");
        }
        return resultado;
    }

    public boolean verificarExistenciaConta(int id) {
        boolean existe = repository.verificarExistencia(id);
        if (existe) {
            System.out.println("Conta encontrada.");
        } else {
            System.out.println("Conta não encontrada.");
        }
        return existe;
    }

    public void listarTodasContas() {
        Conta[] todasContas = repository.listarTodas();
        view.imprimirTodasContas(todasContas);
    }
}




