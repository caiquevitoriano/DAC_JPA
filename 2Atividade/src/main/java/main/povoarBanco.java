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
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.persistence.EntityManager;

/**
 *
 * @author caique
 */
public class povoarBanco {

    private final EntityManager em;

    public povoarBanco(EntityManager em) {
        this.em = em;
    }

    public void dadosIniciais() {       
        

        
        Escritor escritor1 = new Escritor(4, new ArrayList<>(), 2, "Ricarte Rodrigues", Date.valueOf(LocalDate.of(1997, 02, 20)));
        Escritor escritor2 = new Escritor(4, new ArrayList<>(), 4, "Vinicios", Date.valueOf(LocalDate.of(1999, 05, 06)));
        
        Revisor revisor1 = new Revisor("RUIM", new ArrayList<>(), 1, "Caique Vitoriano", Date.valueOf(LocalDate.of(1997, 07, 27)));
        Revisor revisor2 = new Revisor("TOP", new ArrayList<>(), 3, "Alexa Lins", Date.valueOf(LocalDate.of(1997, 05, 06)));
        
        Publicacao publi1 = new Publicacao(100, "QUERO JOGAR", new ArrayList<>(), escritor1, revisor1);
        Publicacao publi2 = new Publicacao(101, "CANSEI DE JOGAR", new ArrayList<>(), escritor1, revisor1);
        Publicacao publi3 = new Publicacao(103, "Java é TOP kkk", new ArrayList<>(), escritor2, revisor2);
            
        
        Area area1 = new Area(1, "Jogos", publi1);
        Area area2 = new Area(2, "Indústria", publi3);
        area1.setPublicacao(publi2);
        
        em.getTransaction().begin();
        
            em.persist(escritor1);
            em.persist(escritor2);
            em.persist(revisor1);
            em.persist(revisor2);
            em.persist(publi1);
            em.persist(publi2);
            em.persist(publi3);
            em.persist(area1);
            em.persist(area2);
        
        em.getTransaction().commit();
    }

}
