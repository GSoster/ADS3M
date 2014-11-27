/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package facadedesignpattern.model;

import facadedesignpattern.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 180901405
 */
public class ClienteDAO implements InterfaceDAO<Cliente>{

    private Cliente cliente;
    private Connection connection;
    private PreparedStatement query;
    
    @Override
    public void inserir(Cliente e) {
        String sql = "INSERT INTO CLIENTE (idCliente, nome) VALUES (?,?)";
        try {            
            this.startConnection(sql);
            query.setInt(1, 1);            
            query.setString(2, e.getNome());            
            query.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                this.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

    @Override
    public void deletar(Cliente e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizar(Cliente e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cliente> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
    private void startConnection(String sql) throws SQLException, ClassNotFoundException {
        this.connection = ConnectionFactory.getConnection();
        if(this.connection != null)
            System.out.println("nao esta nula");
        this.query = this.connection.prepareStatement(sql);
    }
    
    private void closeConnection() throws SQLException {
        this.query.close();
        this.connection.close();        
    }
}
