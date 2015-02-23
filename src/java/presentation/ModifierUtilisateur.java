/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import boundary.UtilisateurBdy;
import entity.Utilisateur;
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
public class ModifierUtilisateur {
    
    @Inject
    private UtilisateurBdy utilisateurs;
    private Utilisateur utilisateur;
    private int idut;

    @PostConstruct
    public void onInit() {
        this.utilisateur = this.utilisateurs.find(idut);
    }

    public UtilisateurBdy getUtilisateurs() {
        return utilisateurs;
    }

    public void setUtilisateurs(UtilisateurBdy utilisateurs) {
        this.utilisateurs = utilisateurs;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public int getIdut() {
        return idut;
    }

    public void setIdut(int idut) {
        this.idut = idut;
    }
    
    public String doChangeUser(){
        utilisateurs.merge(utilisateur);
        return "listeutilisateurs.xhtml?faces-redirect=true";
    }
}
