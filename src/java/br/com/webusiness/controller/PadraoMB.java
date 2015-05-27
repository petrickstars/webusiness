/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.webusiness.controller;

import br.com.webusiness.model.Usuario;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author PauloH
 */
public class PadraoMB {

    public String irPara(String pagina) {
        return pagina;
    }

    /**
     * Verifica se contém um objeto na sessão com a key do parâmetro
     *
     * @param key chave de acesso ao objeto
     * @return TRUE se existir
     */
    public boolean containsObjSessao(String key) {
        return FacesContext.getCurrentInstance().getExternalContext().getSessionMap().containsKey(key);
    }

    /**
     * Adiciona objeto na sessão
     *
     * @param key chave de acesso ao objeto
     * @param value valor do objeto
     */
    public void insereObjNaSessao(String key, Object value) {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(key, value);
    }

    /**
     * Obtém objeto da sessão que estiver mapeado anteriormente
     *
     * @param <T> retorna objeto genérico
     * @param key chave de acesso ao objeto
     * @return null quando não existir objeto com a key do parâmetro.
     */
    public <T> T getObjSessao(String key) {
        if (this.containsObjSessao(key)) {
            return (T) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(key);
        } else {
            return null;
        }
    }

    /**
     * Remove um objeto da sessão
     *
     * @param key chave de acesso ao objeto
     */
    public void removeObjSessao(String key) {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove(key);
    }

    /**
     * Invalida uma corrente sessão
     */
    public void invalidarSessao() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
        session.invalidate();
    }

    public Usuario getUsuarioSessao() {
        return (Usuario) this.getObjSessao("usuario");
    }
    
    public String logout() {        
        invalidarSessao();
        return "/faces/view/principal.xhtml";
    }
}
