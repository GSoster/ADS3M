/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author 180901405
 */
public class ConnectionFactory {
    public static Connection getConnection() throws ClassNotFoundException, SQLException{
        return (getConnectionPostgre());
    }

    private static Connection getConnectionPostgre() throws ClassNotFoundException, SQLException{
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:5432/banco1";
        String username = "postgres";
        String password = "senacrs";
        Connection conexao = DriverManager.getConnection(url, username, password);
        return conexao;
    }
}

