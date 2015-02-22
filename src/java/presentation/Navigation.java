/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Loris
 */
@Named
@SessionScoped
public class Navigation implements Serializable{
    
    private static final long serialVersionUID = 2L;
    private int id;
    
    @PostConstruct
    public void onInit(){
        // On fait rien;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String creerEpisode(int i){
        setId(i);
        return "creerepisode.xhtml?faces-redirect=true";
    }
    
}
