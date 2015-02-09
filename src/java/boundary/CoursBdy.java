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
public class CoursBdy {
    
    @PersistenceContext
    EntityManager em;
    
    @Inject
    Event<Cours> listeners;
    
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
    
}
