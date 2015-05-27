/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.webusiness.controller;

import br.com.webusiness.dao.CategoriaDAO;
import br.com.webusiness.dao.ServicoDAO;
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
public class ServicoMB extends PadraoMB implements Serializable {

    private Servico servico;
    private List<Categoria> categorias;
    private List<Servico> servicos;

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

    public List<Servico> getServicos() {
        return servicos;
    }

    @PostConstruct
    public void init() {
        this.limparObjetos();
        this.listarCategorias();
        this.listarServicos();
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

    private void listarServicos() {
        try {
            ServicoDAO servicoDAO = new ServicoDAO(HibernateUtil.getSession());
            servicoDAO.iniciarTransacao();
            this.servicos = servicoDAO.listar(getUsuarioSessao());
            servicoDAO.fecharTransacao();
            if (this.servicos == null) {
                this.servicos = new ArrayList<>();
            }
        } catch (Exception ex) {
            Logger.getLogger(ServicoMB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void salvar() {
        try {
            this.addUsuario();
            ServicoDAO servicoDAO = new ServicoDAO(HibernateUtil.getSession());
            servicoDAO.iniciarTransacao();
            servicoDAO.salvarOuAtualizar(this.servico);
            servicoDAO.fecharTransacao();
            if (!this.servicos.contains(this.servico)) {
                this.servicos.add(this.servico);
            }
            this.limparObjetos();
        } catch (Exception ex) {
            Logger.getLogger(ServicoMB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Adiciona o usuário logado no serviço criado.
     */
    private void addUsuario() {
        this.servico.setUsuario(getUsuarioSessao());
    }

    public void excluir(Servico servico) {
        try {
            ServicoDAO servicoDAO = new ServicoDAO(HibernateUtil.getSession());
            servicoDAO.iniciarTransacao();
            servicoDAO.excluir(servico);
            servicoDAO.fecharTransacao();
            this.servicos.remove(servico);
            this.limparObjetos();

        } catch (Exception ex) {
            Logger.getLogger(ServicoMB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
