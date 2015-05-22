/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.webusiness.controller;

import br.com.webusiness.dao.UsuarioDAO;
import br.com.webusiness.model.Usuario;
import br.com.webusiness.tipos.TipoUsuario;
import br.com.webusiness.util.HibernateUtil;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author PauloH
 */
@ManagedBean
@ViewScoped
public class AnuncianteMB implements Serializable {

    private Usuario usuario;

    public AnuncianteMB() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @PostConstruct
    public void init() {
        this.limparObjetos();
    }

    private void limparObjetos() {
        this.usuario = new Usuario();
        this.usuario.setTipoUsuario(TipoUsuario.ANUNCIANTE);
    }

    public void salvar() {
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO(HibernateUtil.getSession());
            usuarioDAO.iniciarTransacao();
            usuarioDAO.salvar(this.usuario);
            usuarioDAO.fecharTransacao();
            this.limparObjetos();
        } catch (Exception ex) {
            Logger.getLogger(AnuncianteMB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
