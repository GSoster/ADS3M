/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package facadedesignpattern.model;

import java.util.Date;

/**
 *
 * @author 180901405
 */
public class Venda {
        
    private int nota;
    private Date data;

    public Venda(int nota, Date data){
        this.setData(data);
        this.setNota(nota);
    }
    
    
    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
    
    
}
