/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package facadedesignpattern.model;

/**
 *
 * @author 180901405
 */
public class Cliente {
    private int idCliente;
    private String nome;

    public Cliente(int id, String nome){
        this.setIdCliente(id);
        this.setNome(nome);
    }
    
    public Cliente(String nome){
        this.setNome(nome);
    }
    
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    
    
}
