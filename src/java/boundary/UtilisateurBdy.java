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
public class UtilisateurBdy {

    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    EntityManager em;

    public Utilisateur create(String nom, String prenom, String email, String mdp, String status) {
        Utilisateur u = new Utilisateur(nom, prenom, email, mdp, status);
        em.persist(u);
        return u;
    }

    public Utilisateur update(Utilisateur u) {
        em.persist(u);
        return u;
    }
    
    public Utilisateur merge(Utilisateur u) {
        em.merge(u);
        em.flush();
        return u;
    }

    public List<Utilisateur> findAll() {
        Query q = em.createQuery("SELECT u FROM Utilisateur u ");
        return (List<Utilisateur>) q.getResultList();
    }

    public Utilisateur find(long id) {
        Query q = em.createQuery("SELECT u FROM Utilisateur u WHERE u.id = :uid")
                .setParameter("uid", id);
        List<Utilisateur> lu = (List<Utilisateur>) q.getResultList();
        int size = lu.size();
        if (size < 1) return null;
        return lu.get(size-1);
    }
    
    public Utilisateur find(String mail) {
        mail = mail.toLowerCase();
        Query q = em.createQuery("SELECT u FROM Utilisateur u WHERE u.mail LIKE :email")
                .setParameter("email", mail);
        List<Utilisateur> lu = (List<Utilisateur>) q.getResultList();
        int size = lu.size();
        if (size < 1) return null;
        return lu.get(size-1);
    }
    
    public void delete(Utilisateur u) {
        
        // TODO à tester avec un tulisateur
        for (Cours c : u.getCours()) {
                
            List<Cours> lc = u.getCours();
            lc.remove(c);
            u.setCours(lc);

            List<Utilisateur> lu = c.getUtilisateurs();
            lu.remove(u);
            c.setUtilisateurs(lu);
            
            em.merge(c);
        }
        
        u = em.merge(u);
        em.remove(u);
    }

}
