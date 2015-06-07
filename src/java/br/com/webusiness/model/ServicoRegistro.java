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


@Entity(name = "ServicoRegistro")
@Table(name = "ServicoRegistro")
/**A classe SevicoRegistro é usada para manipular os registros dos serviços, sua classificação, cliente e anunciate do serviço.
 *
 * @author paulohenrique
 */
public class ServicoRegistro implements Serializable {

    @Id
    @GeneratedValue
    /**Atributo id armazena o valor de identificação do Registro do Serviço.
     * 
     */
    private long id;
  
    @OneToOne
    @JoinColumn(name = "idServico")
    /**O objeto servico armazena os dados referentes ao Registro Serviço.
     * 
     */
    private Servico servico;
        
    @OneToOne
    @JoinColumn(name = "idUsuarioCliente")
    /**O objeto usuarioCliente armazena os dados referentes ao cliente que utiliza o Serviço.
     * 
     */
    private Usuario usuarioCliente;
    
    @OneToOne
    @JoinColumn(name = "idUsuarioAnunciante")
    /**O objeto usuarioAnunciante armazena os dados referentes ao Anunciante do Serviço.
     * 
     */
    private Usuario usuarioAnunciante;
    
    /**O objeto classificacao armazena os dados referentes a classificação do Serviço
     * 
     */
    private Byte classificacao;
    
    @Version
    /**O hibernate controla a concorrência dos objetos usando o atributo version.
     * 
     */
    private int version;

    /**Método construtor da classe ServicoRegistro.
     * 
     */
    public ServicoRegistro() {
    }

    /**Método getId recebe o Identificador do registro do serviço.
     *  
     * @return Long - Valor do identificador o registro do seviço.
     */
    public long getId() {
        return id;
    }

     /**Método setId insere e/ou altera o valor do atributo id
     * 
     * @param id 
     */
    public void setId(long id) {
        this.id = id;
    }

    /**Método getServico recebe o serviço inserido pelo anunciante.
     *  
     * @return servico - Retorna o objeto seviço.
     */
    public Servico getServico() {
        return servico;
    }

    /**Método setServico insere e/ou altera o valor do objeto servico.
     * 
     * @param servico 
     */
    public void setServico(Servico servico) {
        this.servico = servico;
    }

    /**Método getUsuarioCliente recebe o usuario(cliente) do serviço.
     *  
     * @return usuarioCliente - Retorna o objeto usuarioCliente.
     */
    public Usuario getUsuarioCliente() {
        return usuarioCliente;
    }

    /**Método setUsuarioCliente insere e/ou altera o valor do objeto usuarioCliente.
     * 
     * @param usuarioCliente 
     */
    public void setUsuarioCliente(Usuario usuarioCliente) {
        this.usuarioCliente = usuarioCliente;
    }

    /**Método getUsuarioAnunciante recebe o usuario(anunciante) do serviço.
     *  
     * @return usuarioAnunciante - Retorna o objeto asuarioAnunciante.
     */
    public Usuario getUsuarioAnunciante() {
        return usuarioAnunciante;
    }

    /**Método setUsuarioCliente insere e/ou altera o valor do objeto usuarioCliente.
     * 
     * @param usuarioAnunciante 
     */
    public void setUsuarioAnunciante(Usuario usuarioAnunciante) {
        this.usuarioAnunciante = usuarioAnunciante;
    }

    /**Método getClassificacao recebe a classificacao do serviço.
     *  
     * @return classificacao - Retorna o objeto classificacao.
     */
    public Byte getClassificacao() {
        return classificacao;
    }

    /**Método setClassificacao insere e/ou altera o valor do objeto classificacao.
     * 
     * @param classificacao
     */
    public void setClassificacao(Byte classificacao) {
        this.classificacao = classificacao;
    }

    /**Metodo getVersion recebe o valor da versão do objeto
     * 
     * @return int - Número da versão 
     */   
    public int getVersion() {
        return version;
    }

    /**Metodo setVersion insere e/ou altera o valor da versão do objeto
     * 
     * @param version 
     */  
    public void setVersion(int version) {
        this.version = version;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }

    /**
     * {@inheritDoc}
     */
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