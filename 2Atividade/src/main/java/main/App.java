/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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
                .createEntityManagerFactory("atividade2")
                .createEntityManager();

        new povoarBanco(em).dadosIniciais();

//        letraB(em);
//        letraC(em);
        letraD(em);

    }

//  b. O título da publicação e o nome do revisor que tenham alguma publicação na área
//  de indústria.
    private static void letraB(EntityManager em) {
        String jpql = "SELECT p.titulo, r.nome FROM Revisor r, IN (r.publicacoes) p,IN(p.areas) a WHERE a.nome like 'Indústria' ";

        Query query = em.createQuery(jpql);
        List<Object[]> lista = query.getResultList();

        for (Object[] object : lista) {
            System.out.println("Publicação: " + object[0]);
            System.out.println("Revisor: " + object[1]);
        }
    }

//  c. O nome dos Revisores que possuem alguma publicação começando com Java.
    private static void letraC(EntityManager em) {

        String jpql = "SELECT r.nome FROM Revisor r, IN(r.publicacoes) p WHERE p.titulo LIKE 'Java%'";
        TypedQuery<String> query = em.createQuery(jpql, String.class);

        query.getResultList().forEach(System.out::println);
    }

    private static void letraD(EntityManager em) {
        String jpql = "SELECT e.nome, count(p) FROM Escritor e, IN(e.publicacoes) p WHERE e.premios > 3 GROUP BY e.nome";

        Query query = em.createQuery(jpql);
        List<Object[]> lista = query.getResultList();
        
        for (Object[] object : lista) {
            System.out.println("Escritor: " + object[0] + " -- Quantidade de Publicações: " + object[1]);
           
        }

    }
}
