/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import boundary.UtilisateurBdy;
import entity.Utilisateur;
import java.util.ArrayList;
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
public class ListeUtilisateurs {
    
    @Inject
    private UtilisateurBdy utilisateurs;
    private List<Utilisateur> liste = new ArrayList<>();

    public UtilisateurBdy getUtilisateurs() {
        return utilisateurs;
    }

    public void setUtilisateurs(UtilisateurBdy utilisateurs) {
        this.utilisateurs = utilisateurs;
    }

    public List<Utilisateur> getListe() {
        liste = utilisateurs.findAll();
        return liste;
    }

    public void setListe(List<Utilisateur> liste) {
        this.liste = liste;
    }
    
    public String delete(Utilisateur u){
        utilisateurs.delete(u);
        return "listeutilisateurs.xhtml?faces-redirect=true";
    }
    
}
