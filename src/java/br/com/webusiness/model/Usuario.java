/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.webusiness.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import br.com.webusiness.tipos.TipoUsuario;

@Entity(name = "Usuario")
@Table(name = "Usuario")
/**A classe Usuario é usada para manipular os dados dos registros dos usuários (anunciantes ou administrador).
 *
 * @author paulohenrique
 */
public class Usuario implements Serializable {

    @Id
    @GeneratedValue
    /** O atributo id armazena o valor de identificação do usuário.
     * 
     */
    private long id;
    
    @Column(length = 50)
    /** O atributo nome armazena o nome do usuário.
     * 
     */
    private String nome;
    
    @Column(length = 60)
    /** O atributo endereco armazena o endereço do usuário.
     * 
     */
    private String endereco;
    
    @Column(length = 15)
    /** O atributo numero armazena o número da residência do usuário.
     * 
     */
    private String numero;
    
    @Column(length = 30)
    /** O atributo bairro armazena o bairro onde o usuário reside.
     * 
     */
    private String bairro;
    
    @OneToOne
    @JoinColumn(name = "idCidade")
    /** O objeto cidade armazena a cidade onde o usuário reside.
     * 
     */
    private Cidade cidade;
    
    /** O objeto TipoUsuario armazena o tipo de usuário que o usuário é (usuário administrador ou usuário normal).
     * 
     */
    private TipoUsuario tipoUsuario;
    
    @Column(length = 14)
    /** O aAtributo cpfOuCnpj armazena o CPF ou o CNPJ do usuário.
     * 
     */
    private String cpfOuCnpj;
    
    @Column(length = 10)
    /** O atributo telefoneFixo armazena o telefone fixo do usuário.
     * 
     */
    private String telefoneFixo;
    
    @Column(length = 11)
    /** O atributo telefoneCelular armazena o telefone celular do usuário.
     * 
     */
    private String telefoneCelular;
    
    /** O atributo ativo armazena a informação se o usuário esta ativo.
     * 
     */
    private boolean ativo;
    
    /** O atributo bloqueado armazena se o usuário esta bloqueado.
     * 
     */
    private boolean bloqueado;
    
    @Column(length = 8)
    /** O atributo cep armazena o CEP do usuário.
     * 
     */
    private String cep;
    
    @Column(length = 50)
    /** O atributo email armazena o email do usuário.
     * 
     */
    private String email;
    
    @Column(length = 50)
    /** O atributo email2 armazena um email alternativo do usuário.
     * 
     */
    private String email2;
    
    @Column(length = 30)
    /** O atributo complemento armazena o complemento do endereçõ do usuário.
     * 
     */
    private String complemento;
    
    @Column(columnDefinition = "timestamp default current_timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    /** O atributo dataCadastro armazena a data do cadastro do usuário.
     * 
     */
    private Date dataCadastro;
    
    @Column(length = 12)
    /** O atributo rg armazena o RG (Regitro Geral) do usuário.
     * 
     */
    private String rg;
    
    @Column(length = 11)
    /** O atributo cnh armazena o número da CNH (Carteira Nacional de Habilitação) do usuário.
     * 
     */
    private String cnh;
    
    @Column(length = 2)
    /** O atributo tipoCnh armazena a categoria da CNH (Carteira Nacional de Habilitação) do usuário.
     * 
     */
    private String tipoCnh;
    
    @Column(length = 40)
    /** O atributo rasãoSocial armazena a rasão social da empresa do usuário se houver.
     * 
     */
    private String razaoSocial;
    
    @Column(length = 1)
    /** O atributo sexo armazena o sexo do usuário.
     * 
     */
    private String sexo;
    
    @Column(length = 30)
    /** O atributo site armazena o site do usuário.
     * 
     */
    private String site;
    
    @Column(length = 12)
    /** O atributo login armazena o login do usuário.
     * 
     */
    private String login;
    
    @Column(length = 8)
    /** O atributo senha armazena o senha do usuário.
     * 
     */
    private String senha;   
    
    @Version
    /** O hibernate controla a concorrência dos objetos usando o atributo version.
     * 
     */
    private int version;

     /** Método construtor da classe Usuário.
     * 
     */
    public Usuario() {
    }
    
    /** Metodo getId recebe o identificador do usuário
    * 
    * @return Long - Valor que identifica o usuário 
    */
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    
    /**
     * 
     * @param nome 
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getCpfOuCnpj() {
        return cpfOuCnpj;
    }

    public void setCpfOuCnpj(String cpfOuCnpj) {
        this.cpfOuCnpj = cpfOuCnpj;
    }

    public String getTelefoneFixo() {
        return telefoneFixo;
    }

    public void setTelefoneFixo(String telefoneFixo) {
        this.telefoneFixo = telefoneFixo;
    }

    public String getTelefoneCelular() {
        return telefoneCelular;
    }

    public void setTelefoneCelular(String telefoneCelular) {
        this.telefoneCelular = telefoneCelular;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public boolean isBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public String getTipoCnh() {
        return tipoCnh;
    }

    public void setTipoCnh(String tipoCnh) {
        this.tipoCnh = tipoCnh;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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
        final Usuario other = (Usuario) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
}