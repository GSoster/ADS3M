/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import banco.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import projetoaulabanco7.model.Contato;

/**
 *
 * @author 180901405
 */
public class ContatoDAOJDBC implements ContatoDAO{
    private Connection conexao;
    private PreparedStatement comando;
    
    
    private void iniciarConexao(String sql) throws ClassNotFoundException, SQLException{
        conexao = ConnectionFactory.getConnection();
        comando = conexao.prepareStatement(sql);
    }
    
    private void fecharConexao() throws SQLException{
        comando.close();
        conexao.close();
        conexao = null;
    }

    @Override
    public void inserir(Contato contato) {
        
        String sql = "INSERT INTO contato(nome, email) VALUES (?,?)";
        try {
            iniciarConexao(sql);
            comando.setString(1, contato.getNome());//altera o ? da query p/ contato.getNome
            comando.setString(2, contato.getEmail());
            comando.executeUpdate();            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ContatoDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ContatoDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                fecharConexao();
            } catch (SQLException ex) {
                Logger.getLogger(ContatoDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void deletar(Contato contato) {
        String sql = "DELETE FROM contato WHERE id= ?)";
        try {
            iniciarConexao(sql);
            comando.setInt(1, contato.getId());//altera o ? da query p/ contato.getID
            comando.executeUpdate();            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ContatoDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ContatoDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                fecharConexao();
            } catch (SQLException ex) {
                Logger.getLogger(ContatoDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void atualizar(Contato contato) {
        String sql = "UPDATE contato SET nome = ?, email = ? WHERE id =?)";
        try {
            iniciarConexao(sql);
            comando.setString(1, contato.getNome());//altera o ? da query p/ contato.getNome
            comando.setString(2, contato.getEmail());
            comando.setInt(3,contato.getId());
            comando.executeUpdate();            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ContatoDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ContatoDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                fecharConexao();
            } catch (SQLException ex) {
                Logger.getLogger(ContatoDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public List<Contato> listar() {
        String sql = "SELECT * FROM contato";
        List<Contato> listaDeContatos;
        listaDeContatos = new ArrayList<Contato>();
        try {
            iniciarConexao(sql);            
            ResultSet resultado = comando.executeQuery();            
            
            while(resultado.next()){
                Contato contato = new Contato(resultado.getInt("id"), resultado.getString("nome"), resultado.getString("email"));
                listaDeContatos.add(contato);
            }            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ContatoDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ContatoDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                fecharConexao();
            } catch (SQLException ex) {
                Logger.getLogger(ContatoDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaDeContatos;
    }

    @Override
    public Contato buscarPorId(int id) {
        String sql = "SELECT * FROM contato WHERE id = ?";
        Contato contato = null;        
        try {
            iniciarConexao(sql);            
            comando.setInt(1, id);
            ResultSet resultado = comando.executeQuery();            
            
            while(resultado.next()){
                contato = new Contato(resultado.getInt("id"), resultado.getString("nome"), resultado.getString("email"));                
            }            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ContatoDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ContatoDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                fecharConexao();
            } catch (SQLException ex) {
                Logger.getLogger(ContatoDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return contato;
    }

    @Override
    public Contato buscarPorNome(String nome) {
        String sql = "SELECT * FROM contato WHERE nome = ?";
        Contato contato = null;        
        try {
            iniciarConexao(sql);            
            comando.setString(1, nome);
            ResultSet resultado = comando.executeQuery();            
            
            while(resultado.next()){
                contato = new Contato(resultado.getInt("id"), resultado.getString("nome"), resultado.getString("email"));                
            }            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ContatoDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ContatoDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                fecharConexao();
            } catch (SQLException ex) {
                Logger.getLogger(ContatoDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return contato;
    }
    
}
