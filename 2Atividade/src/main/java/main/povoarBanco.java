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
            
        

        Revisor revisor1 = new Revisor("RUIM", new ArrayList<>(), 1, "Caique Vitoriano", Date.valueOf(LocalDate.of(1997, 07, 27)));
        
        Escritor escritor1 = new Escritor(4, new ArrayList<>(), 2, "Ricarte Rodrigues", Date.valueOf(LocalDate.of(1997, 02, 20)));
        
        Publicacao publi1 = new Publicacao(100, "QUERO JOGAR", escritor1, revisor1, new ArrayList<>());
        Publicacao publi2 = new Publicacao(100, "CANCEI DE JOGAR", escritor1, revisor1, new ArrayList<>());
        
        Area area1 = new Area(1, "Jogos", publi1);
        area1.setPublicacao(publi2);
        
        em.getTransaction().begin();
        
            em.persist(revisor1);
            em.persist(escritor1);
            em.persist(publi1);
            em.persist(publi2);
            em.persist(area1);
        
        em.getTransaction().commit();
    }

}
