/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.atividade;

import domain.Endereco;
import domain.Pessoa;
import java.time.Instant;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author caique
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        EntityManager em = Persistence
                .createEntityManagerFactory("atividade1")
                .createEntityManager();

        Endereco end1 = new Endereco("rua", "bairro", "cidade", "00000-000");

        Pessoa pessoa1 = new Pessoa(
                "nome",
                "000.000.000-00",
                10,
                Date.from(Instant.now()),
                end1
        );

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        em.persist(pessoa1);
        transaction.commit();

        Pessoa pessoa = em.find(Pessoa.class, "000.000.000-00");
        System.out.println(pessoa.getNome());

    }

}
