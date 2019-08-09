/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author caique
 */

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Pessoa implements Serializable{
    @Id
    private int id;
    private String nome;
    @Temporal(TemporalType.DATE)
    private Date  dataNasciemntp;

    public Pessoa() {
    }

    public Pessoa(int id, String nome, Date dataNasciemntp) {
        this.id = id;
        this.nome = nome;
        this.dataNasciemntp = dataNasciemntp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNasciemntp() {
        return dataNasciemntp;
    }

    public void setDataNasciemntp(Date dataNasciemntp) {
        this.dataNasciemntp = dataNasciemntp;
    }
    
    
    
            
}
