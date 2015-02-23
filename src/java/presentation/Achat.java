/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import boundary.CoursBdy;
import boundary.UtilisateurBdy;
import entity.Cours;
import entity.Utilisateur;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Loris
 */
@Named
@RequestScoped
public class Achat {

    @Inject
    private UtilisateurBdy utilisateurs;
    @Inject
    private CoursBdy cours;
    private int idcours;
    private int idutil;

    public UtilisateurBdy getUtilisateurs() {
        return utilisateurs;
    }

    public void setUtilisateurs(UtilisateurBdy utilisateurs) {
        this.utilisateurs = utilisateurs;
    }

    public CoursBdy getCours() {
        return cours;
    }

    public void setCours(CoursBdy cours) {
        this.cours = cours;
    }

    public int getIdcours() {
        return idcours;
    }

    public void setIdcours(int idcours) {
        this.idcours = idcours;
    }

    public int getIdutil() {
        return idutil;
    }

    public void setIdutil(int idutil) {
        this.idutil = idutil;
    }

    public String message(int c, int u) {
        if(u == 0) return "Vous devez être connecté pour acheter un cours.";
        
        String nc = "";
        for (Cours co : cours.findAll()){
            if (co.getId() == c) nc = co.getTitre();
        }
        
        String nu = "";
        for (Utilisateur ut : utilisateurs.findAll()){
            if (ut.getId() == u) nu = ut.getPrenom();
        }
        return "Bonjour " + nu + ", vous êtes sur le point d'acheter '" + nc + "'";
    }

    public String doBuyCours(){
        
        try{
        
        Cours c = null;
        for (Cours co : cours.findAll()){
            if (co.getId() == idcours) c = co;
        }
        
        Utilisateur u = null;
        for (Utilisateur ut : utilisateurs.findAll()){
            if (ut.getId() == idutil) u = ut;
        }
      
        c.ajouterUtilisateur(u);
        u.ajouterCours(c);
        
        u = utilisateurs.merge(u);
        c = cours.merge(c);
        
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return "mesCours.xhtml?faces-redirect=true";
    }
}
