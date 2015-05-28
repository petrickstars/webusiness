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
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;


@Entity(name = "Cidade")
@Table(name = "Cidade")
/** A classe Cidade será usada para armazenar as cidades referentes aos estados
 *
 * @author paulohenrique
 */
public class Cidade implements Serializable {

   
    @Id
    @GeneratedValue
    /**Atributo id armazena o valor de identificação da cidade
    * 
    */
    private long id;
    @Column(length = 50)
    
    /**Atributo nome armazena o nome da cidade
    * 
    */
    private String nome;
    @Column(length = 7)
    
    /**Atributo codIbge armazena o valor de identificação da cidade junto ao IBGE
    * 
    */
    private String codIbge;
    @OneToOne
    
    /**Atributo estado armazena o estado a qual a cidade pertence
    * 
    */
    @JoinColumn(name = "idEstado")
    private Estado estado;
    
  
    @Version
     /**O hibernate controla a concorrência dos objetos usando o atributo version
    * 
    */
    private int version;

    /**Método construtor da classe Cidade
     * 
     */
    public Cidade() {
    }

    /**Método getId recebe o Identificador da cidade
    *  
    * @return Long - Valor do identificador da cidade
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

    /**Método getNome recebe o nome da cidade
    * 
    * @return String - Nome da cidade
    */
    public String getNome() {
        return nome;
    }

    /**Método setNome nsere e/ou altera o nome da cidade
     * 
     * @param nome 
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    
    public String getCodIbge() {
        return codIbge;
    }

    public void setCodIbge(String codIbge) {
        this.codIbge = codIbge;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
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
        final Cidade other = (Cidade) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
}