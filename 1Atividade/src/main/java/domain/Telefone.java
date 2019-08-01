/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;

/**
 *
 * @author caique
 */
@Entity
public class Telefone implements Serializable{
    
    @Id
    private String numero;
    
    @Enumerated 
    private TelefoneType tipo;

    public Telefone() {
    }

    public Telefone(String numero, TelefoneType tipo) {
        this.numero = numero;
        this.tipo = tipo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public TelefoneType getTipo() {
        return tipo;
    }

    public void setTipo(TelefoneType tipo) {
        this.tipo = tipo;
    }
    
    
        

    
}
