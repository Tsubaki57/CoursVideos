
import boundary.InscriptionBdy;
import entity.Utilisateur;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
package Application;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Loris
 */
public class Test {
    
    public static void Main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA1PU");
        EntityManager em = emf.createEntityManager();
        
        InscriptionBdy boundary = new InscriptionBdy(em);
        
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        // Let's code
        
        // Créer un utilisateur
        Utilisateur u = boundary.createUtil("Durand", "Loris", "tsubaki57@gmail.com", "lol", "admin");
        
        tx.commit();
        
        // On essaie de ressortir les données
        Collection<Utilisateur> utils = boundary.findAllUtil();
        for (Utilisateur ut : utils){
            System.out.println(ut.getPrenom()+" "+ut.getNom());
        }
        
        em.close();
        emf.close();
        
    }
    
}
