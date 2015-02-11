/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import entity.Cours;
import entity.Utilisateur;
import java.util.List;
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
    
    public Cours create(String titre, String image, double prix){
        Cours c = new Cours( titre, image, prix);
        em.persist(c);
        return c;
    }
    
    public Cours update(Cours c){
        em.persist(c);
        return c;
    }
    
    public List<Cours> findAll(){
        Query q = em.createQuery("SELECT c FROM Cours c ");
        return (List<Cours>)q.getResultList();
    }
    
}
