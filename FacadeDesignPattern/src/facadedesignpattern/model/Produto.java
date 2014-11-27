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
public class Produto {
    private int idProduto;
    private String nome;
    private double preco;

    public Produto(int idProduto, String nome, double preco) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.preco = preco;
    }
    
    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    
    
}
