
package br.senac.tads.pi3.gerenciamentoprodutos.db.utils;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author rbezerra
 * Conexão com o SGBD
 */
public class ConnectionUtils {
    
    private Connection obterConexao() throws ClassNotFoundException, SQLException 
    {
        Connection conn = null;
        Class.forName("com.mysql.jdbc.Driver");
        conn = (Connection) DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/gerenciador-produto",
                "root",
                "");
        return conn;
    }
    
}
