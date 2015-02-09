/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import boundary.CoursBdy;
import entity.Cours;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Loris
 */
@Named
@RequestScoped
public class Creercours {
    
    @Inject
    private CoursBdy coursb;
    private Cours cours;

    public CoursBdy getCoursb() {
        return coursb;
    }

    public void setCoursb(CoursBdy coursb) {
        this.coursb = coursb;
    }

    public Cours getCours() {
        return cours;
    }

    public void setCours(Cours cours) {
        this.cours = cours;
    }
    
    public String doAddCours() {
        cours = coursb.update(cours);
        return "listeCours.xhtml?faces-redirect=true";
    }
    
}
