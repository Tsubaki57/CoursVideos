/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import entity.Cours;
import entity.Utilisateur;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Loris
 */
@Stateless
public class UtilisateurBdy {
    
    @PersistenceContext
    EntityManager em;
    
    @Inject
    Event<Utilisateur> listeners;

    public UtilisateurBdy() {
    }

    public UtilisateurBdy(EntityManager em) {
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

}
