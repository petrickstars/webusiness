/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.webusiness.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;


@Entity(name = "Categoria")
@Table(name = "Categoria")
/** A classe Categoria é usada para manipular os dados das categorias dos serviços.
 *
 * @author paulohenrique
 */
public class Categoria implements Serializable {

    @Id
    @GeneratedValue
    /**Atributo id armazena o valor de identificação da categoria do serviço.
    * 
    */
    private long id;  
    
    /**Atributo descricao armazenara a descrição detalhada das caracteristicas das categoria do serviço.
    * 
    */
    private String descricao;
    
    
    @Version
    /**O hibernate controla a concorrência dos objetos usando o atributo version.
    * 
    */
    private int version;
    
    /**Método construtor da classe Categoria.
     * 
     */
    public Categoria() {
    }

    /**Método getId recebe o Identificador da categoria do serviço.
     *  
     * @return Long - Valor do identificador da categoria do seviço.
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

    /**Método getDescricao armazena a descrição da categoria do serviço
     * 
     * @return String - Descrição da categoria do serviço
     */
    public String getDescricao() {
        return descricao;
    }

    /**Método setDescricao insere e/ou altera a descrição da categoria do serviço
     * 
     * @param descricao 
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
    
    
    
    @Override  
    /**
     * {@inheritDoc}
     */
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }

    @Override
    /**
     * {@inheritDoc}
     */
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Categoria other = (Categoria) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
}