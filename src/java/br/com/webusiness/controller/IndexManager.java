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
public class IndexManager implements Serializable {

    public IndexManager() {
        
    }
    
    public String irPara(String pagina) {
        return pagina;
    }
    
}
