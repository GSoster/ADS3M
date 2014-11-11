/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.util.List;
import projetoaulabanco7.model.Contato;

/**
 *
 * @author 180901405
 */
public interface ContatoDAO {
 
    /**
     * Criar banco abaixo:
     * 
     create table contato(
        id serial primary key,
        nome varchar(255),
        email varchar(255)
    );
     * 
     */
    
    public void inserir(Contato contato);
    public void deletar(Contato contato);
    public void atualizar(Contato contato);
    public List<Contato> listar();
    public Contato buscarPorId(int id);
    public Contato buscarPorNome(String nome);
    
    
}
