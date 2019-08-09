/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author caique
 */
@Entity
public class Area implements Serializable {

    @Id
    private int cod;
    private String nome;

    @ManyToOne
    @JoinColumn(name = "publicacao_area")
    private Publicacao publicacao;

    public Area() {
    }

    public Area(int cod, String nome, Publicacao publicacao) {
        this.cod = cod;
        this.nome = nome;
        this.publicacao = publicacao;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Publicacao getPublicacao() {
        return publicacao;
    }

    public void setPublicacao(Publicacao publicacao) {
        this.publicacao = publicacao;
    }
    
    

}
