/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import boundary.Boundary;
import entity.Utilisateur;
import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Loris
 */
@Named
@RequestScoped
public class Inscription {
    
    @Inject
    Boundary boundary;
    private Utilisateur utilisateur;
    
    @PostConstruct
    public void onInit(){
        this.utilisateur = new Utilisateur();
    }

    public Boundary getBoundary() {
        return boundary;
    }

    public void setBoundary(Boundary boundary) {
        this.boundary = boundary;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
    
    public String doAddUser(){
        utilisateur = boundary.updateUtil(utilisateur);
        return "listeUtilisateur.xhtml?faces-redirect=true";
    }
    
}
