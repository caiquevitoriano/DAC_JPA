/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import dominio.Area;
import dominio.Escritor;
import dominio.Publicacao;
import dominio.Revisor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author caique
 */
public class AppCriteria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManager em = Persistence
                .createEntityManagerFactory("atividade2")
                .createEntityManager();

        new povoarBanco(em).dadosIniciais();

//        letraA(em);
//        letraB(em);
//        letraC(em);
        letraD(em);

    }

//    a. O nome do escritor, o título da publicação e o nome da área em que o esctrito tem o
//    atributo id igual a 3.
    private static void letraA(EntityManager em) {
        String jpql = "SELECT e.nome, p.titulo, a.nome FROM Escritor e, "
                + "IN(e.publicacoes) p, IN(p.areas) a WHERE e.id = 3";

        Query query = em.createQuery(jpql);
        List<Object[]> lista = query.getResultList();

        for (Object[] object : lista) {
            System.out.println("Escritor: " + object[0]);
            System.out.println("Pubçicação: " + object[1]);
            System.out.println("Area: " + object[2]);
        }

    }

//  b. O título da publicação e o nome do revisor que tenham alguma publicação na área
//  de indústria.
    private static void letraB(EntityManager em) {
        // String jpql = "SELECT p.titulo, r.nome FROM Revisor r, IN (r.publicacoes) p,IN(p.areas) a WHERE a.nome like 'Indústria' ";

        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Object[]> criteria = builder.createQuery(Object[].class);

        Root<Publicacao> root = criteria.from(Publicacao.class);
        Join<Publicacao, Area> join = root.join("areas");
        Join<Publicacao, Revisor> join1 = root.join("revisor");
        
        Predicate predicate = builder.like(join.get("nome"), "Indústria");
        criteria.multiselect(root.get("titulo"), join1.get("nome")).where(predicate);

        List<Object[]> resultList = em.createQuery(criteria).getResultList();

        for (Object[] object : resultList) {
            System.out.println("Publicação: " + object[0]);
            System.out.println("Revisor: " + object[1]);
            System.out.println("---------------------------------");
        }
    }

//  c. O nome dos Revisores que possuem alguma publicação começando com Java.
    private static void letraC(EntityManager em) {

        //String jpql = "SELECT r.nome FROM Revisor r, IN(r.publicacoes) p WHERE p.titulo LIKE 'Java%'";
        
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<String> criteria = builder.createQuery(String.class);
        
        Root<Revisor> root = criteria.from(Revisor.class);
        Join<Revisor, Publicacao> join = root.join("publicacoes");
        Predicate predicate = builder.like((join.get("titulo")), "Java%");        
        criteria.where(predicate).select(root.get("nome"));
        
        em.createQuery(criteria).getResultList().forEach(System.out::println);
        
    }

//  d. O nome e a quantidade de Publicações escritas por Escritores com mais que três
//  prêmios.
    private static void letraD(EntityManager em) {
        //String jpql = "SELECT e.nome, count(p) FROM Escritor e, IN(e.publicacoes) p WHERE e.premios > 3 GROUP BY e.nome";

        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Object[]> criteria = builder.createQuery(Object[].class);
        
        Root<Escritor> root  = criteria.from(Escritor.class);
        Join<Escritor, Publicacao> join = root.join("publicacoes");
 
        Predicate predicate = builder.gt(root.get("premios"), 3);

        criteria.multiselect(root.get("nome"), builder.count(join)).where(predicate).groupBy(root.get("nome"));
        
        List<Object[]> lista = em.createQuery(criteria).getResultList();
        for (Object[] object : lista) {
            System.out.println("Escritor: " + object[0] + "Quantidade de Publicações: " + object[1]);
            System.out.println("------------------");

        }

    }
}
