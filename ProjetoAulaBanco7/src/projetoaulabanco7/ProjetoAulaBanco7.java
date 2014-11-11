/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projetoaulabanco7;

import dao.ContatoDAO;
import dao.ContatoDAOJDBC;
import javax.swing.JOptionPane;
import projetoaulabanco7.model.Contato;

/**
 *
 * @author 180901405
 */
public class ProjetoAulaBanco7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Contato contato = new Contato(JOptionPane.showInputDialog("Nome: "), JOptionPane.showInputDialog("Email: "));
        
        ContatoDAO dao = new ContatoDAOJDBC();
        dao.inserir(contato);        
        contato.setNome("novo nome");
        contato.setEmail("nbovasdasdasdasd");
        contato.setId(2);
        dao.atualizar(contato);
        
    }
    
}
