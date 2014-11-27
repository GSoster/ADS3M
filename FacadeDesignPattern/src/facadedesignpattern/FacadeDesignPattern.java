/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package facadedesignpattern;

import facadedesignpattern.model.Cliente;
import facadedesignpattern.model.ClienteDAO;

/**
 *
 * @author 180901405
 */
public class FacadeDesignPattern {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cliente c = new Cliente("Guilherme");
        System.out.println(c.getNome());
        ClienteDAO cDAO = new ClienteDAO();
        cDAO.inserir(c);
    }
    
}
