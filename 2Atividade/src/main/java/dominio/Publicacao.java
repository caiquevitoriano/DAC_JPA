/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author caique
 */
@Entity
public class Publicacao implements Serializable {

    @Id
    private int codPublicacao;
    private String titulo;

    @OneToMany(mappedBy = "publicacao")
    private List<Area> areas;

    @ManyToOne
    @JoinColumn(name = "escritor_id")
    private Escritor escritor;

    @ManyToOne
    @JoinColumn(name = "revisor_id")
    private Revisor revisor;

    public Publicacao() {
    }

    public Publicacao(int codPublicacao, String titulo, List<Area> areas, Escritor escritor, Revisor revisor) {
        this.codPublicacao = codPublicacao;
        this.titulo = titulo;
        this.areas = areas;
        this.escritor = escritor;
        this.revisor = revisor;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + this.codPublicacao;
        hash = 79 * hash + Objects.hashCode(this.titulo);
        hash = 79 * hash + Objects.hashCode(this.areas);
        hash = 79 * hash + Objects.hashCode(this.escritor);
        hash = 79 * hash + Objects.hashCode(this.revisor);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Publicacao other = (Publicacao) obj;
        if (this.codPublicacao != other.codPublicacao) {
            return false;
        }
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        if (!Objects.equals(this.areas, other.areas)) {
            return false;
        }
        if (!Objects.equals(this.escritor, other.escritor)) {
            return false;
        }
        if (!Objects.equals(this.revisor, other.revisor)) {
            return false;
        }
        return true;
    }
    
    

}
