/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import entity.Cours;
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
    
    public Cours create(String titre, String description, double prix){
        Cours c = new Cours( titre, description, prix);
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
    
    public Cours find(int id){
        Query q = em.createQuery("SELECT c FROM Cours c WHERE c.ID = :idc")
                .setParameter("idc", id);
        List<Cours> lc = q.getResultList();
        return (Cours) lc.get(1);
    }
    
    public void delete(Cours c){
        em.remove(em.merge(c));
    }
    
}
