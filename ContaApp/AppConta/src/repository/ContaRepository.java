package repository;

import model.Conta;

public class ContaRepository {
    private Conta[] contas;
    private int nextId = 1;

    public ContaRepository(int tamanho) {
        this.contas = new Conta[tamanho];
    }

    public void inserir(Conta conta) {
        conta.setId(nextId++);
        contas[conta.getId() - 1] = conta;
    }

    public Conta buscar(int id) {
        for (Conta conta : contas) {
            if (conta != null && conta.getId() == id) {
                return conta;
            }
        }
        return null;
    }

    public boolean remover(int id) {
        for (int i = 0; i < contas.length; i++) {
            if (contas[i] != null && contas[i].getId() == id) {
                contas[i] = null;
                return true;
            }
        }
        return false;
    }

    public boolean alterar(Conta contaAtualizada) {
        for (int i = 0; i < contas.length; i++) {
            if (contas[i] != null && contas[i].getId() == contaAtualizada.getId()) {
                contas[i] = contaAtualizada;
                return true;
            }
        }
        return false;
    }

    public boolean verificarExistencia(int id) {
        for (Conta conta : contas) {
            if (conta != null && conta.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public Conta[] listarTodas() {
        return contas;
    }
}
