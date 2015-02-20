/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import entity.Episode;
import entity.Utilisateur;
import java.util.ArrayList;
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
public class EpisodeBdy {
    
    @PersistenceContext
    EntityManager em;
    
    @Inject
    Event<Episode> listeners;
    
    public Episode create(String titre, int duree,String lien){
        Episode e= new Episode(titre, duree, lien);     
        em.persist(e);
        return e;
    }
    
    public Episode update(Episode e){
        em.persist(e);
        return e;
    }
    
    public List<Episode> findAll(){
        Query q = em.createQuery("SELECT e FROM Episode e ");
        return (List<Episode>)q.getResultList();
    }
    
}
