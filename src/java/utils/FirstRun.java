/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import boundary.CoursBdy;
import boundary.EpisodeBdy;
import boundary.UtilisateurBdy;
import entity.Cours;
import entity.Episode;
import entity.Utilisateur;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Loris
 */
@Named
@RequestScoped
public class FirstRun {
    
    @Inject
    UtilisateurBdy utilB;
    @Inject
    CoursBdy coursB;
    @Inject
    EpisodeBdy episodeB;
    
    @PostConstruct
    public void onInit() {
        System.out.println("Premier lancement, création d'un jeu d'éssai.");
    }
    
    public String createSomeRows(){
        
        Utilisateur u1 = new Utilisateur("Ministrator", "Ad", "admin@admin", "admin", "admin");
        Utilisateur u2 = new Utilisateur("Doe", "John", "jd@mail", "jd", "user");
        
        u1 = utilB.update(u1);
        u2 = utilB.update(u2);
        
        Cours c1 = new Cours("Cours d'Anglais", "Ceci est un cours d'Anglais trop génial", 50);
        Cours c2 = new Cours("Cours de yoyo", "Un cours de yoyo vraiment inutile, on ne peut pas faire payer ca !", 0);
        
        c1 = coursB.update(c1);
        c2 = coursB.update(c2);
        
        List<Episode> le;
        
        Episode e1 = new Episode("Anglais débutant", 29, "SoR6YO3AE74");
        Episode e2 = new Episode("Anglais : Age of ultron", 2, "tmeOjFno6Do");
        Episode e3 = new Episode("Master yoyo", 5, "PEU_BVFgncU");
        
        le = c1.getEpisodes();
        le.add(e1);
        le.add(e2);
        c1.setEpisodes(le);
        
        le = c2.getEpisodes();
        le.add(e3);
        c2.setEpisodes(le);
        
        e1 = episodeB.update(e1);
        e2 = episodeB.update(e2);
        e3 = episodeB.update(e3);
        
        c1 = coursB.merge(c1);
        c2 = coursB.merge(c2);
        
        System.out.println("Jeu d'éssai créé sans encombres.");
        
        return "accueil.xhtml";
    }
    
}
