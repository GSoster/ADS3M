/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package facadedesignpattern.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author 180901405
 */
public class ConnectionFactory {
 
    public static Connection getConnection() throws ClassNotFoundException, SQLException
    {        
        return (getConnectionDerby());
    }
    
    
    public static Connection getConnectionDerby() throws ClassNotFoundException, SQLException{   
        System.gc();
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        String url = "jdbc:derby://localhost:1527/ExemploFacade";
        String username = "";
        String password = "";
        Connection conexao = DriverManager.getConnection(url, username, password);
        return conexao;
    }
    
    
}
