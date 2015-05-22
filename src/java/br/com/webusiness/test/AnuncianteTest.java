/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.webusiness.test;

import br.com.webusiness.dao.UsuarioDAO;
import br.com.webusiness.model.Usuario;
import br.com.webusiness.util.HibernateUtil;

/**
 *
 * @author PauloH
 */
public class AnuncianteTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        inserirAnunciante();
        System.exit(0);
    }
    private static void inserirAnunciante() throws Exception{
        
       UsuarioDAO usuarioDAO = new UsuarioDAO(HibernateUtil.getSession());
            usuarioDAO.iniciarTransacao();
            Usuario usuario = new Usuario();
            usuario.setNome("Usuario 1");
           
            usuarioDAO.salvar(usuario);
            usuarioDAO.fecharTransacao(); 
    }
}
