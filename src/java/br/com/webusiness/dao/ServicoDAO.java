/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.webusiness.dao;

import br.com.webusiness.model.Servico;
import br.com.webusiness.model.Usuario;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author PauloH
 */
public class ServicoDAO extends PadraoDAO<Servico> {

    public ServicoDAO(Session sessao) {
        super(sessao);
    }

    /**
     * Lista todos os serviços de um usuário
     *
     * @param usuario
     * @return List<Servico> Ordenados pelo campo nome.
     */
    public List<Servico> listar(Usuario usuario) {
        Criteria criteria = super.sessao.createCriteria(Servico.class);
        criteria.add(Restrictions.eq("usuario", usuario));
        criteria.addOrder(Order.asc("nome"));
        return criteria.list();
    }

}
