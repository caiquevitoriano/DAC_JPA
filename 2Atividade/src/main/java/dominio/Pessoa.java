/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.Date;

/**
 *
 * @author caique
 */

@Entity
public class Pessoa {
    @Id
    private int id;
    private String nome;
    @Temporal(TemporalType.DATE)
    private Date  dataNasciemntp;
            
}
