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
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

/**
 *
 * @author Loris
 */
@Stateless
public class CoursBdy {

    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    EntityManager em;

    public Cours create(String titre, String description, double prix) {
        Cours c = new Cours(titre, description, prix);
        em.persist(c);
        return c;
    }

    public Cours update(Cours c) {
        em.persist(c);
        return c;
    }

    public Cours merge(Cours c) {
        em.merge(c);
        em.flush();
        return c;
    }

    public List<Cours> findAll() {
        Query q = em.createQuery("SELECT c FROM Cours c ");
        return (List<Cours>) q.getResultList();
    }

    public Cours find(int id) {
        Query q = em.createQuery("SELECT c FROM Cours c WHERE c.id = :idc")
                .setParameter("idc", id);
        List<Cours> lc = (List<Cours>) q.getResultList();
        int size = lc.size();
        if (size < 1) return null;
        return lc.get(size-1);
    }

    public void delete(Cours c) {
        
        // TODO à tester avec un tulisateur
        for (Utilisateur u : c.getUtilisateurs()) {
                
            List<Cours> lc = u.getCours();
            lc.remove(c);
            u.setCours(lc);

            List<Utilisateur> lu = c.getUtilisateurs();
            lu.remove(u);
            c.setUtilisateurs(lu);
            
            em.merge(u);
        }
        
        c = em.merge(c);
        em.remove(c);
    }

}
