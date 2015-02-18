/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import boundary.CoursBdy;
import entity.Cours;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Loris
 */
@Named
@RequestScoped
public class ListeCours {
    
    @Inject
    private CoursBdy cours;
    private List<Cours> liste;

    public CoursBdy getCours() {
        return cours;
    }

    public void setCours(CoursBdy cours) {
        this.cours = cours;
    }

    public List<Cours> getListe() {
        liste = cours.findAll();
        return liste;
    }

    public void setListe(List<Cours> liste) {
        this.liste = liste;
    }
   
    /** 
     * Action handler - appelé lorsque l'utilisateur sélectionne une ligne dans 
     * la DataTable pour voir les détails 
     */  
    public String showDetailsCours(int id) {  
        return "listeEpisode?idcours=" + id;    }
}
