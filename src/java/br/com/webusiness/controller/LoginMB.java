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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author PauloH
 */
@ManagedBean
@ViewScoped
public class LoginMB extends PadraoMB implements Serializable {

    private String login;
    private String senha;

    public LoginMB() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String logar() {
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO(HibernateUtil.getSession());
            usuarioDAO.iniciarTransacao();
            Usuario usuario = usuarioDAO.logar(this.login, this.senha);
            usuarioDAO.fecharTransacao();
            if (usuario != null) {
                insereObjNaSessao("usuario", usuario);
                insereObjNaSessao("logado", true);
                insereObjNaSessao("admin", usuario.getTipoUsuario().equals(TipoUsuario.ADMINISTRADOR));
              
                return "/faces/view/principal.xhtml";
            } else {
                Logger.getLogger(LoginMB.class.getName()).log(Level.SEVERE, null, "Usuário não logado!");
            }

        } catch (Exception ex) {
            Logger.getLogger(LoginMB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

}
