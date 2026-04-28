package br.com.dimdim;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class TransacaoDAO {
    public void criarTabela() throws Exception {
        Connection con = Conexao.getConexao();
        con.createStatement().execute("CREATE TABLE IF NOT EXISTS transacoes (id INT AUTO_INCREMENT PRIMARY KEY, tipo VARCHAR(50), valor DOUBLE, descricao VARCHAR(200))");
        System.out.println("Tabela criada!");
        con.close();
    }
    public void inserir(Transacao t) throws Exception {
        Connection con = Conexao.getConexao();
        PreparedStatement ps = con.prepareStatement("INSERT INTO transacoes (tipo, valor, descricao) VALUES (?, ?, ?)");
        ps.setString(1, t.getTipo());
        ps.setDouble(2, t.getValor());
        ps.setString(3, t.getDescricao());
        ps.execute();
        System.out.println("Inserido: " + t.getTipo());
        con.close();
    }
    public void listar() throws Exception {
        Connection con = Conexao.getConexao();
        ResultSet rs = con.createStatement().executeQuery("SELECT * FROM transacoes");
        System.out.println("--- Transacoes ---");
        while (rs.next()) {
            System.out.println("ID: " + rs.getInt("id") + " | " + rs.getString("tipo") + " | R$" + rs.getDouble("valor") + " | " + rs.getString("descricao"));
        }
        con.close();
    }
}
