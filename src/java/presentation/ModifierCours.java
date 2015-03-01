/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import boundary.CoursBdy;
import entity.Cours;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Loris
 */
@Named
@ViewScoped
public class ModifierCours implements Serializable{
    
    @Inject
    private CoursBdy coursb;
    private Cours cours;
    private int idec;
    
    @PostConstruct
    public void onInit(){
    }

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

    public int getIdec() {
        return idec;
    }

    public void setIdec(int idec) {
        this.cours = this.coursb.find(idec);
        this.idec = idec;
    }
    
    public String doChangeCours(){
        this.cours = this.coursb.merge(cours);
        return "listecours.xhtml?faces-redirect=true";
    }
    
}
