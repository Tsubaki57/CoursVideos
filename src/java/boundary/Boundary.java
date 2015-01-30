/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import entity.Cours;
import entity.Utilisateur;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Loris
 */
public class Boundary {
    
    protected EntityManager em;

    public Boundary(EntityManager em) {
        this.em = em;
    }
    
    public Utilisateur createUtil(String nom, String prenom, String email, String mdp, String status){
        Utilisateur u = new Utilisateur(nom, prenom, email, mdp, status);
        em.persist(u);
        return u;
    }
    
    public Utilisateur updateUtil(Utilisateur u){
        em.persist(u);
        return u;
    }
    
    public Collection<Utilisateur> findAllUtil(){
        Query q = em.createQuery("SELECT u FROM Utilisateur u ");
        return (Collection<Utilisateur>)q.getResultList();
    }
    
    public Cours createCours(String titre, String image, double prix){
        Cours c = new Cours( titre, image, prix);
        em.persist(c);
        return c;
    }
    
    public Cours updateCours(Cours c){
        em.persist(c);
        return c;
    }
    
    public Collection<Utilisateur> findAllCours(){
        Query q = em.createQuery("SELECT c FROM Cours c ");
        return (Collection<Utilisateur>)q.getResultList();
    }
    
    // TODO creat, update, findall episodes
}
