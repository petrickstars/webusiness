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
    
    /** O método getId recebe o identificador do usuário.
     * 
     * @return Long - O valor que identifica o usuário 
     */
    public long getId() {
        return id;
    }

    /**O método setId insere e/ou altera o valor do atributo id.
     * 
     * @param id 
     */
    public void setId(long id) {
        this.id = id;
    }

    /** O método getNome recebe o nome do usuário.
     * 
     * @return String - O nome da cidade
     */
    public String getNome() {
        return nome;
    }
    
    /** O método setNome insere e/ou altera o nome do usuário.
     * 
     * @param nome 
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /** O método getEndereco recebe o endereço do usuário.
     * 
     * @return String - O endereço do usuário
     */
    public String getEndereco() {
        return endereco;
    }

    /** O método setEndereco insere e/ou altera o endereço do usuário.
     * 
     * @param endereco
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /** O método getnumero recebe o numero da residencia do usuário.
     * 
     * @return String - O numero da residência do usuário
     */
    public String getNumero() {
        return numero;
    }

    /** O método setNumero insere e/ou altera o numero da resedência do usuário.
     * 
     * @param numero
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /** O método getBairro recebe o bairro do usuário.
     * 
     * @return String - O bairro do usuário
     */
    public String getBairro() {
        return bairro;
    }

    /** O método setBairro insere e/ou altera o bairro do usuário.
     * 
     * @param bairro 
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /** O método getCidade recebe a cidade do usuário.
     * 
     * @return String - A cidade do usuário
     */
    public Cidade getCidade() {
        return cidade;
    }

    /** O método setCidade insere e/ou altera a cidade do usuário.
     * 
     * @param  cidade
     */
    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    /** O método getTipoUsuario recebe o o tipo do usuário (Administrador ou normal).
     * 
     * @return String - O tipo do usuário
     */
    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    /** O método setTipoUsuario insere e/ou altera o tipo de usuário.
     * 
     * @param  tipoUsuario 
     */
    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    /** O método getCpfOuCnpj recebe o CEP ou CNPJ do usuário.
     * 
     * @return String - O CPF ou CNPJ do usuário
     */
    public String getCpfOuCnpj() {
        return cpfOuCnpj;
    }

    /** O método setCpfOuCnpj insere e/ou altera o CPF ou CNPJ do usuário.
     * 
     * @param cpfOuCnpj 
     */
    public void setCpfOuCnpj(String cpfOuCnpj) {
        this.cpfOuCnpj = cpfOuCnpj;
    }

    /** O método getTelefone recebe o telefone do usuário.
     * 
     * @return String - O telefone do usuário
     */
    public String getTelefoneFixo() {
        return telefoneFixo;
    }

    /** O método setTelefoneFixo insere e/ou altera o telefone fixo do usuário.
     * 
     * @param  telefoneFixo 
     */
    public void setTelefoneFixo(String telefoneFixo) {
        this.telefoneFixo = telefoneFixo;
    }

    /** O método getTelefoneCelular recebe o telefone celular do usuário.
     * 
     * @return String - O telefone celular do usuário
     */
    public String getTelefoneCelular() {
        return telefoneCelular;
    }

    /** O método setTelefoneCelular insere e/ou altera o telefone celular do usuário.
     * 
     * @param  telefoneCelular 
     */
    public void setTelefoneCelular(String telefoneCelular) {
        this.telefoneCelular = telefoneCelular;
    }

    /** O método isAtivo recebe a informação se o usuário esta ou não ativo.
     * 
     * @return Boolean - Se o usuário esta ativo ou não
     */
    public boolean isAtivo() {
        return ativo;
    }

    /** O método setAtivo insere e/ou altera se o usuário esta ativo.
     * 
     * @param  ativo 
     */
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

   /** O método isBloqueado recebe a informação se o usuário esta ou não bloqueado.
     * 
     * @return Boolean - Se o usuário esta bloqueado ou não
     */
    public boolean isBloqueado() {
        return bloqueado;
    }

    /** O método setBloqueado insere e/ou altera se o usuário esta bloqueado.
     * 
     * @param  bloqueado 
     */
    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }

    /** O método getCep recebe o CEP do usuário.
     * 
     * @return String - O CEP do usuário
     */
    public String getCep() {
        return cep;
    }

    /** O método setCep insere e/ou altera o CEP do usuário.
     * 
     * @param  cep
     */
    public void setCep(String cep) {
        this.cep = cep;
    }

    /** O método getEmail recebe o email do usuário.
     * 
     * @return String - O email do usuário
     */
    public String getEmail() {
        return email;
    }

    /** O método setEmail insere e/ou altera o email do usuário.
     * 
     * @param  email 
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /** O método getEmail2 recebe o email alternativo do usuário.
     * 
     * @return String - O email2 do usuário
     */
    public String getEmail2() {
        return email2;
    }

    /** O método setEmail2 insere e/ou altera o email alternativo do usuário.
     * 
     * @param  email2 
     */
    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    /** O método getComplemento recebe o complemento do endereço do usuário.
     * 
     * @return String - O complemento do usuário
     */
    public String getComplemento() {
        return complemento;
    }

    /** O método setComplemento insere e/ou altera o complemento do endereço do usuário.
     * 
     * @param  complemento 
     */
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    /** O método getDataCadastro recebe a data do cadastro do usuário.
     * 
     * @return Date - a data do cadastro do usuário
     */
    public Date getDataCadastro() {
        return dataCadastro;
    }

    /** O método setDataCadastro insere e/ou altera a data do cadastro do usuário.
     * 
     * @param  dataCadastro 
     */
    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    /** O método getRg recebe o RG (Registro Geral) do usuário.
     * 
     * @return String - O RG (Registro Geral) do usuário
     */
    public String getRg() {
        return rg;
    }

    /** O método setRg insere e/ou altera o RG (Registro Geral) do usuário.
     * 
     * @param  rg
     */
    public void setRg(String rg) {
        this.rg = rg;
    }

    /** O método getCnh recebe a CNH (Carteira Nacional de Habilitação) do usuário.
     * 
     * @return String - A CNH (Carteira Nacional de Habilitação) do usuário
     */
    public String getCnh() {
        return cnh;
    }

    /** O método setCnh insere e/ou altera o número da CNH (Carteira Nacional de Habilitação) do usuário.
     * 
     * @param cnh 
     */
    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    /** O método getTipoCnh recebe a categoria da CNH do usuário.
     * 
     * @return String - A  categoria da CNH do usuário
     */
    public String getTipoCnh() {
        return tipoCnh;
    }

    /** O método setTipoCnh insere e/ou altera a categoria da CNH do usuário.
     * 
     * @param  tipoCnh 
     */
    public void setTipoCnh(String tipoCnh) {
        this.tipoCnh = tipoCnh;
    }

    /** O método getRasaoSocial recebe a rasão social da empresa do usuário se houver.
     * 
     * @return String - A rasão social da empresa do usuário se houver
     */
    public String getRazaoSocial() {
        return razaoSocial;
    }

    /** O método setRazaoSocial insere e/ou altera a rasao social da empresa do usuário se houver.
     * 
     * @param  razaoSocial 
     */
    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    /** O método getSexo recebe o sexo do usuário.
     * 
     * @return String - O sexo do usuário
     */
    public String getSexo() {
        return sexo;
    }

    /** O método setSexo insere e/ou altera o sexo do usuário.
     * 
     * @param  sexo
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /** O método getSite recebe o site do usuário.
     * 
     * @return String - O site do usuário
     */
    public String getSite() {
        return site;
    }

    /** O método setSite insere e/ou altera o site do usuário.
     * 
     * @param  site
     */
    public void setSite(String site) {
        this.site = site;
    }

    /** O método getLogin recebe o login do usuário.
     * 
     * @return String - O login do usuário
     */
    public String getLogin() {
        return login;
    }

    /** O método setLogin insere e/ou altera o login do usuário.
     * 
     * @param  login
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /** O método getSenha recebe o senha do usuário.
     * 
     * @return String - O senha do usuário
     */
    public String getSenha() {
        return senha;
    }

    /** O método setSenha insere e/ou altera o senha do usuário.
     * 
     * @param  senha
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }  

     /** O metodo getVersion recebe o valor da versão do objeto
     * 
     * @return int - Número da versão 
     */   
    public int getVersion() {
        return version;
    }

    /** O metodo setVersion insere e/ou altera o valor da versão do objeto
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
        final Usuario other = (Usuario) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
}