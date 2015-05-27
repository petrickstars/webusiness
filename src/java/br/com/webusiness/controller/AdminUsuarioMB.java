/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.webusiness.controller;

import br.com.webusiness.dao.CategoriaDAO;
import br.com.webusiness.dao.ServicoDAO;
import br.com.webusiness.dao.UsuarioDAO;
import br.com.webusiness.model.Categoria;
import br.com.webusiness.model.Servico;
import br.com.webusiness.model.Usuario;
import br.com.webusiness.util.HibernateUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
public class AdminUsuarioMB extends PadraoMB implements Serializable {

    private String nome;

    private List<Usuario> usuarios;

    public AdminUsuarioMB() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }
    
    

    public void pesquisarUsuarios() {
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO(HibernateUtil.getSession());
            usuarioDAO.iniciarTransacao();
            this.usuarios = usuarioDAO.listar(this.nome);
            usuarioDAO.fecharTransacao();
        } catch (Exception ex) {
            Logger.getLogger(AdminUsuarioMB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void bloquear(Usuario usuario) {
        usuario.setBloqueado(true);
        this.atualizarUsuario(usuario);
    }

    public void desbloquear(Usuario usuario) {
        usuario.setBloqueado(false);
        this.atualizarUsuario(usuario);
    }

    private void atualizarUsuario(Usuario usuario) {
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO(HibernateUtil.getSession());
            usuarioDAO.iniciarTransacao();
            usuarioDAO.atualizar(usuario);
            usuarioDAO.fecharTransacao();
        } catch (Exception ex) {
            Logger.getLogger(AdminUsuarioMB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
