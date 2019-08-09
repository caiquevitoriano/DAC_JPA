/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author caique
 */

@Entity
public class Publicacao implements Serializable {
    
    @Id
    private int codPublicacao;
    private String titulo;
    
    @ManyToOne
    @JoinColumn(name = "escritor_publicacao")
    private Escritor escritor;
    
    @ManyToOne
    @JoinColumn(name = "revisor_publicacao")
    private Revisor revisor;    
    
    @OneToMany(mappedBy = "publicacao")
    private List<Area> areas;

    public Publicacao() {
    }

    public Publicacao(int codPublicacao, String titulo, Escritor escritor, Revisor revisor, List<Area> areas) {
        this.codPublicacao = codPublicacao;
        this.titulo = titulo;
        this.escritor = escritor;
        this.revisor = revisor;
        this.areas = areas;
    }

    public int getCodPublicacao() {
        return codPublicacao;
    }

    public void setCodPublicacao(int codPublicacao) {
        this.codPublicacao = codPublicacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Escritor getEscritor() {
        return escritor;
    }

    public void setEscritor(Escritor escritor) {
        this.escritor = escritor;
    }

    public Revisor getRevisor() {
        return revisor;
    }

    public void setRevisor(Revisor revisor) {
        this.revisor = revisor;
    }

    public List<Area> getAreas() {
        return areas;
    }

    public void setAreas(List<Area> areas) {
        this.areas = areas;
    }
    
    
    
    
    
    
}
