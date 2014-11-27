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
public class ItemVenda {
    
    private int idItemVenda, idnota, idProduto, quantidade;

    public ItemVenda(int idItemVenda, int idnota, int idProduto, int quantidade) {
        this.idItemVenda = idItemVenda;
        this.idnota = idnota;
        this.idProduto = idProduto;
        this.quantidade = quantidade;
    }

    public ItemVenda(int idnota, int idProduto, int quantidade) {
        this.idnota = idnota;
        this.idProduto = idProduto;
        this.quantidade = quantidade;
    }

    
    
    public int getIdItemVenda() {
        return idItemVenda;
    }

    public void setIdItemVenda(int idItemVenda) {
        this.idItemVenda = idItemVenda;
    }

    public int getIdnota() {
        return idnota;
    }

    public void setIdnota(int idnota) {
        this.idnota = idnota;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    
    
    
}
