/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;

/**
 *
 * @author caique
 */
@Entity
public class Livro implements Serializable{
    
    private String ISBN;
    private String nome;
    private Date lancamento;
    private List<Autor> autores;

    public Livro() {
    }

    public Livro(String ISBN, String nome, Date lancamento, List<Autor> autores) {
        this.ISBN = ISBN;
        this.nome = nome;
        this.lancamento = lancamento;
        this.autores = autores;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getLancamento() {
        return lancamento;
    }

    public void setLancamento(Date lancamento) {
        this.lancamento = lancamento;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }    
    
    

    
}
