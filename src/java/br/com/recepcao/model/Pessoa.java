/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.recepcao.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author gabriel
 */
@Entity
@Table(name = "PESSOA")
public class Pessoa implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "rg")
    private String rg;
    @Column(name = "categoria")
    private String categoria;
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "telefone")
    private String telefone;
    @Column(name = "acesso")
    private String acesso;
    @Column(name = "foto")
    private String foto;
    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
    private Collection<Calendario> pessoaCalendario;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the rg
     */
    public String getRg() {
        return rg;
    }

    /**
     * @param rg the rg to set
     */
    public void setRg(String rg) {
        this.rg = rg;
    }

    /**
     * @return the categoria
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the acesso
     */
    public String getAcesso() {
        return acesso;
    }

    /**
     * @param acesso the acesso to set
     */
    public void setAcesso(String acesso) {
        this.acesso = acesso;
    }

    /**
     * @return the foto
     */
    public String getFoto() {
        return foto;
    }

    /**
     * @param foto the foto to set
     */
    public void setFoto(String foto) {
        this.foto = foto;
    }

    /**
     * @return the pessoaCalendario
     */
    public Collection<Calendario> getPessoaCalendario() {
        return pessoaCalendario;
    }

    /**
     * @param pessoaCalendario the pessoaCalendario to set
     */
    public void setPessoaCalendario(Collection<Calendario> pessoaCalendario) {
        this.pessoaCalendario = pessoaCalendario;
    }
}
