/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import boundary.UtilisateurBdy;
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
    UtilisateurBdy utilisateurs;
    private Utilisateur utilisateur;

    @PostConstruct
    public void onInit() {
        this.utilisateur = new Utilisateur();
    }

    public UtilisateurBdy getUtilisateurs() {
        return utilisateurs;
    }

    public void setUtilisateurs(UtilisateurBdy u) {
        this.utilisateurs = u;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public String doAddUser() {
        utilisateur = utilisateurs.updateUtil(utilisateur);
        return "listeUtilisateurs.xhtml?faces-redirect=true";
    }

}
