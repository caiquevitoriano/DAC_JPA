/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
/**
 *
 * @author caique
 */
@Entity
public class Escritor extends Pessoa{
    
    private int premios;
    
    @OneToMany(mappedBy = "escritor")
    private List<Publicacao> publicacaos;

    public Escritor() {
    }    
    
    public Escritor(int premios, List<Publicacao> publicacaos) {
        this.premios = premios;
        this.publicacaos = publicacaos;
    }

    public Escritor(int premios, List<Publicacao> publicacaos, int id, String nome, Date dataNasciemntp) {
        super(id, nome, dataNasciemntp);
        this.premios = premios;
        this.publicacaos = publicacaos;
    }

    public int getPremios() {
        return premios;
    }

    public void setPremios(int premios) {
        this.premios = premios;
    }

    public List<Publicacao> getPublicacaos() {
        return publicacaos;
    }

    public void setPublicacaos(List<Publicacao> publicacaos) {
        this.publicacaos = publicacaos;
    }
    
    

//    public Escritor(int premios, Set<Publicacao> publicacaos) {
//        this.premios = premios;
//        this.publicacaos = publicacaos;
//    }
//
//    public Escritor(int premios, Set<Publicacao> publicacaos, int id, String nome, Date dataNasciemntp) {
//        super(id, nome, dataNasciemntp);
//        this.premios = premios;
//        this.publicacaos = publicacaos;
//    }
//
//    public int getPremios() {
//        return premios;
//    }
//
//    public void setPremios(int premios) {
//        this.premios = premios;
//    }
//
//    public Set<Publicacao> getPublicacaos() {
//        return publicacaos;
//    }
//
//    public void setPublicacaos(Set<Publicacao> publicacaos) {
//        this.publicacaos = publicacaos;
//    }
    
    
    
}
