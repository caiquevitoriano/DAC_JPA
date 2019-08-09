/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author caique
 */

@Entity
public class Revisor extends Pessoa implements Serializable{
    
    private String nota;    
    
    @OneToMany
    private List<Publicacao> publicacoes;

    public Revisor() {
    }

    public Revisor(String nota, List<Publicacao> publicacoes) {
        this.nota = nota;
        this.publicacoes = publicacoes;
    }

    public Revisor(String nota, List<Publicacao> publicacoes, int id, String nome, Date dataNasciemntp) {
        super(id, nome, dataNasciemntp);
        this.nota = nota;
        this.publicacoes = publicacoes;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public List<Publicacao> getPublicacoes() {
        return publicacoes;
    }

    public void setPublicacoes(List<Publicacao> publicacoes) {
        this.publicacoes = publicacoes;
    }
    
    
    
}
