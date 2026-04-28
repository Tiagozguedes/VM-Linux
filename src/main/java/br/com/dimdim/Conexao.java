package br.com.dimdim;
import java.sql.Connection;
import java.sql.DriverManager;
public class Conexao {
    public static Connection getConexao() throws Exception {
        return DriverManager.getConnection("jdbc:mysql://bd_portalweb:3306/portalweb", "root", "@Fiap2tds2023");
    }
}
