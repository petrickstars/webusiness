/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.webusiness.dao;

import br.com.webusiness.model.Usuario;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author PauloH
 */
public class UsuarioDAO extends PadraoDAO<Usuario> {

    public UsuarioDAO(Session sessao) {
        super(sessao);
    }

    public Usuario logar(String login, String senha) {
        Criteria criteria = super.sessao.createCriteria(Usuario.class);
        criteria.add(Restrictions.eq("login", login));
        criteria.add(Restrictions.eq("senha", senha));
        return (Usuario) criteria.uniqueResult();
    }

}
