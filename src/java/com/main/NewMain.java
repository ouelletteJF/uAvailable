

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.main;
import com.uavailable.entites1.Membre;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author ferdinand
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String  prenom = "Domy",nom = "inputLast" ,eMail = "inputEmail";
                
        
        
        
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("uAvailablePU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        tx.begin();
                Membre membre = new Membre(eMail,nom,prenom);
     
        
        //NewEntity entity = new NewEntity();
        
        em.persist(membre);
        
        tx.commit();
        em.close();
        emf.close();
   
    }
    
}
