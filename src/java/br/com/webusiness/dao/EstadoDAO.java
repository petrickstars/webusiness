/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.webusiness.dao;

import br.com.webusiness.model.Estado;
import org.hibernate.Session;

/**
 *
 * @author PauloH
 */
public class EstadoDAO extends PadraoDAO<Estado> {

    public EstadoDAO(Session sessao) {
        super(sessao);
    }

  

}
