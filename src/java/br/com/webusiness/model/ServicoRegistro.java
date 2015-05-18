/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.webusiness.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 *
 * @author paulohenrique
 */
@Entity(name = "ServicoRegistro")
@Table(name = "ServicoRegistro")
public class ServicoRegistro implements Serializable {

    @Id
    @GeneratedValue
    private long id;
    @OneToOne
    @JoinColumn(name = "idServico")
    private Servico servico;
    @OneToOne
    @JoinColumn(name = "idUsuarioCliente")
    private Usuario usuarioCliente;
    @OneToOne
    @JoinColumn(name = "idUsuarioAnunciante")
    private Usuario usuarioAnunciante;
    private Byte classificacao;
    @Version
    private int version;

    public ServicoRegistro() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public Usuario getUsuarioCliente() {
        return usuarioCliente;
    }

    public void setUsuarioCliente(Usuario usuarioCliente) {
        this.usuarioCliente = usuarioCliente;
    }

    public Usuario getUsuarioAnunciante() {
        return usuarioAnunciante;
    }

    public void setUsuarioAnunciante(Usuario usuarioAnunciante) {
        this.usuarioAnunciante = usuarioAnunciante;
    }

    public Byte getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(Byte classificacao) {
        this.classificacao = classificacao;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ServicoRegistro other = (ServicoRegistro) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
}