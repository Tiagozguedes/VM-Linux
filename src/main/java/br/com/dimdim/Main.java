package br.com.dimdim;
public class Main {
    public static void main(String[] args) throws Exception {
        TransacaoDAO dao = new TransacaoDAO();
        dao.criarTabela();
        dao.inserir(new Transacao("DEPOSITO", 1500.00, "Salario"));
        dao.inserir(new Transacao("SAQUE", 200.00, "Mercado"));
        dao.inserir(new Transacao("TRANSFERENCIA", 500.00, "Aluguel"));
        dao.listar();
    }
}
