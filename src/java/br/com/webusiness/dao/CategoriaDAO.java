/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.webusiness.dao;

import br.com.webusiness.model.Categoria;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 *
 * @author PauloH
 */
public class CategoriaDAO extends PadraoDAO<Categoria> {

    public CategoriaDAO(Session sessao) {
        super(sessao);
    }

   /**
    * Lista todas as categorias ordenadas por descrição
    * @return 
    */
    public List<Categoria> listar() throws Exception{
        Criteria criteria = super.sessao.createCriteria(Categoria.class);
        criteria.addOrder(Order.asc("descricao"));
        return criteria.list();
    }

}
