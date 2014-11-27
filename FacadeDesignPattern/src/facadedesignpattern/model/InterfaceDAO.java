/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package facadedesignpattern.model;

import java.util.List;

/**
 *
 * @author 180901405
 * @param <E>
 */
public interface InterfaceDAO <E>{
    
    public void inserir(E e);
    public void deletar(E e);
    public void atualizar(E e);
    public List<E> listar();  
    
}
