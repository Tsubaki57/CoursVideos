/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import boundary.CoursBdy;
import entity.Cours;
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
    
    public String delete(Cours c){
        cours.delete(c);
        return "listecours.xhtml?faces-redirect=true";
    }

    /**
     * Action handler - appelé lorsque l'utilisateur sélectionne une ligne dans
     * la DataTable pour voir les détails
     *
     * @param id Id du cours à linker
     * @return URL du cours
     */
    public String showDetailsCours(int id) {
        return "listeepisode?id=" + id + "&faces-redirect=true";
    }
    
    public String showDetailsCoursUser(int id){
        return "cours.xhtml?id=" + id + "&faces-redirect=true";
    }
    
    public String createEpisode(int id){
        return "creerepisode.xhtml?id=" + id + "&faces-redirect=true";
    }

}
