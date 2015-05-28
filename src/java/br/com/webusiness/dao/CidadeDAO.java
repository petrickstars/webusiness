/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.webusiness.dao;

import br.com.webusiness.model.Categoria;
import br.com.webusiness.model.Cidade;
import br.com.webusiness.model.Estado;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author PauloH
 */
public class CidadeDAO extends PadraoDAO<Cidade> {

    public CidadeDAO(Session sessao) {
        super(sessao);
    }

    /**
     * Lista todas as cidades de um estado.
     *
     * @param estado
     * @return
     */
    public List<Cidade> listar(Estado estado) throws Exception {
        Criteria criteria = super.sessao.createCriteria(Cidade.class);
        criteria.add(Restrictions.eq("estado", estado));
        criteria.addOrder(Order.asc("nome"));
        return criteria.list();
    }

}
