/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.webusiness.controller;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author aaoliveira
 */
@ManagedBean
@ViewScoped
public class IndexMB extends PadraoMB implements Serializable {

    public IndexMB() {

    }

    public String logout() {
        removeObjSessao("usuario");
        removeObjSessao("logado");
        invalidarSessao();
        return "/faces/view/principal.xhtml";
    }

}
