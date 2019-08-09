/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import javax.persistence.EntityManager;
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
                .createEntityManagerFactory("atividade2")
                .createEntityManager();

       new povoarBanco(em).dadosIniciais();


    }
    
}
