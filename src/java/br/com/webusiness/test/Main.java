/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.webusiness.test;

import br.com.webusiness.util.HibernateUtil;

/**
 *
 * @author PauloH
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        HibernateUtil.getSessionFactory();
        System.exit(0);
    }
    
}
