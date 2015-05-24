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
import br.com.webusiness.tipos.TipoUsuario;
import br.com.webusiness.util.HibernateUtil;
import java.io.Serializable;
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
public class ServicoMB implements Serializable {

    private Servico servico;
    private List<Categoria> categorias;

    public ServicoMB() {
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    @PostConstruct
    public void init() {
        this.limparObjetos();
        this.listarCategorias();
    }

    private void limparObjetos() {
        this.servico = new Servico();
    }

    private void listarCategorias() {
        try {
            CategoriaDAO categoriaDAO = new CategoriaDAO(HibernateUtil.getSession());
            categoriaDAO.iniciarTransacao();
            this.categorias = categoriaDAO.listar();
            categoriaDAO.fecharTransacao();

        } catch (Exception ex) {
            Logger.getLogger(ServicoMB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void salvar() {
        try {
            ServicoDAO servicoDAO = new ServicoDAO(HibernateUtil.getSession());
            servicoDAO.iniciarTransacao();
            servicoDAO.salvar(this.servico);
            servicoDAO.fecharTransacao();
            this.limparObjetos();
        } catch (Exception ex) {
            Logger.getLogger(ServicoMB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void excluir() {
        try {
            ServicoDAO servicoDAO = new ServicoDAO(HibernateUtil.getSession());
            servicoDAO.iniciarTransacao();
            servicoDAO.excluir(this.servico);
            servicoDAO.fecharTransacao();
            this.limparObjetos();
        } catch (Exception ex) {
            Logger.getLogger(ServicoMB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
