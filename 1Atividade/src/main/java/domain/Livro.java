/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import convert.ConvertLocalDate;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author caique
 */
@Entity
public class Livro implements Serializable {

    @Id
    private String ISBN;
    private String nome;
//    @Temporal(TemporalType.DATE)
    @Convert(converter = ConvertLocalDate.class)
    private LocalDate lancamento;
    
    @ManyToMany(mappedBy = "livros")
    private List<Autor> autores;

    public Livro() {
        this.autores = new ArrayList<>();
    }

    public Livro(String nome, String ISBN, LocalDate lancamento) {
        this.nome = nome;
        this.ISBN = ISBN;
        this.lancamento = lancamento;
        this.autores = new ArrayList<>();
    }

    public Livro(String nome, String ISBN, LocalDate lancamento, List<Autor> autores) {
        super();
        this.nome = nome;
        this.ISBN = ISBN;
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

    public LocalDate getLancamento() {
        return lancamento;
    }

    public void setLancamento(LocalDate lancamento) {
        this.lancamento = lancamento;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

}
