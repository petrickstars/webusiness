/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.webusiness.controller;

import br.com.webusiness.dao.CategoriaDAO;
import br.com.webusiness.dao.CidadeDAO;
import br.com.webusiness.dao.EstadoDAO;
import br.com.webusiness.dao.PadraoDAO;
import br.com.webusiness.dao.ServicoDAO;
import br.com.webusiness.model.Categoria;
import br.com.webusiness.model.Cidade;
import br.com.webusiness.model.Estado;
import br.com.webusiness.model.Servico;
import br.com.webusiness.util.HibernateUtil;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;
import org.hibernate.Session;

/**
 *
 * @author aaoliveira
 */
@ManagedBean
@ViewScoped
public class PrincipalMB extends PadraoMB implements Serializable {

    private String nome;
    private Categoria categoria;
    private Cidade cidade;
    private Estado estado;
    private List<Categoria> categorias;
    private List<Cidade> cidades;
    private List<Estado> estados;
    private List<Servico> servicos;
    private boolean pesquisando;

    public PrincipalMB() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public List<Cidade> getCidades() {
        return cidades;
    }

    public List<Estado> getEstados() {
        return estados;
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public boolean isPesquisando() {
        return pesquisando;
    }

    @PostConstruct
    public void init() {
        this.listarObjetos();
        this.pesquisando = true;
    }

    private void listarEstados(Session session) throws Exception {
        EstadoDAO estadoDAO = new EstadoDAO(session);
        this.estados = estadoDAO.listar(Estado.class, "nome");
    }

    private void listarCategorias(Session session) throws Exception {
        CategoriaDAO categoriaDAO = new CategoriaDAO(session);
        this.categorias = categoriaDAO.listar(Categoria.class, "descricao");
    }

    public void listarCidades() {
        try {
            CidadeDAO cidadeDAO = new CidadeDAO(HibernateUtil.getSession());
            cidadeDAO.iniciarTransacao();
            this.cidades = cidadeDAO.listar(this.estado);
            cidadeDAO.fecharTransacao();
        } catch (Exception ex) {
            Logger.getLogger(PrincipalMB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void listarObjetos() {
        try {
            Session session = HibernateUtil.getSession();
            PadraoDAO padraoDAO = new PadraoDAO<>(session);
            padraoDAO.iniciarTransacao();
            this.listarCategorias(session);
            this.listarEstados(session);
            padraoDAO.fecharTransacao();
        } catch (Exception ex) {
            Logger.getLogger(PrincipalMB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void listarServicos() throws Exception {
        ServicoDAO servicoDAO = new ServicoDAO(HibernateUtil.getSession());
        servicoDAO.iniciarTransacao();
        this.servicos = servicoDAO.listar(this.nome, this.categoria, this.cidade);
        servicoDAO.fecharTransacao();
    }

    public void onClickButtonPesquisar() {
        try {
            this.pesquisando = false;
            this.listarServicos();
        } catch (Exception ex) {
            Logger.getLogger(PrincipalMB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void onClickButtonVoltar() {
        this.pesquisando = true;
    }
}
