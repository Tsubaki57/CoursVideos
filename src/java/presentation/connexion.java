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
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import utils.Sha;

/**
 *
 * @author Loris
 */
@Named
@SessionScoped
public class Connexion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Inject
    private UtilisateurBdy utilisateurs;
    private CoursBdy cours;
    private Utilisateur utilisateur;
    private String mail;
    private String pw;
    private String label_co;
    private List<Cours> mylist;
    private boolean admin;

    @PostConstruct
    public void onInit() {
        //this.utilisateur = new Utilisateur();
        //On fait rien.
        this.label_co = "Se connecter";
        this.admin = false;
    }

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

    public Utilisateur getUtilisateur() {
        if(this.utilisateur != null) this.utilisateur = utilisateurs.find(this.utilisateur.getMail());
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        if (utilisateur != null) {
            if (utilisateur.isAdmin()) {
                admin = true;
            } else {
                admin = false;
            }
        } else {
            admin = false;
        }
        this.utilisateur = utilisateur;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail.toLowerCase();
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = Sha.hash256(pw);
    }

    public String getLabel_co() {
        return label_co;
    }

    public void setLabel_co(String label_co) {
        this.label_co = label_co;
    }

    public List<Cours> getMylist() {
        if (utilisateur == null) {
            return new ArrayList<Cours>();
        }
        this.mylist = utilisateur.getCours();
        return mylist;
    }

    public void setMylist(List<Cours> mylist) {
        this.mylist = mylist;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String checkLogin() {
        String url = "connexion.xhtml?faces-redirect=true";
        Utilisateur u = utilisateurs.find(this.mail);
        if (u != null) {
            if (u.getMdp().equals(this.pw)) {
                url = "accueil.xhtml?faces-redirect=true";
                setUtilisateur(u);
                setLabel_co("Déconnecter " + u.getPrenom() + " " + u.getNom() + " ");

            } else {
                FacesContext.getCurrentInstance().addMessage("connexionForm:msgLogin", new FacesMessage("Mot de passe invalide"));
            }
        } else {

            FacesContext.getCurrentInstance().addMessage("connexionForm:msgLogin", new FacesMessage("Cette adresse n'est pas inscrite"));
        }
        return url;
    }

    public String de_connexion() {
        if (getLabel_co().equals("Se connecter")) {
            // On redirige simplement
        } else {
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
            setUtilisateur(null);
            setLabel_co("Se connecter");
        }
        return "connexion.xhtml?faces-redirect=true";
    }

    public void adminControl() {
        try {
            if (!admin) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("accueil.xhtml?faces-redirect=true");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean coursPaye(Cours c){
        if(c.getPrix() == 0) return true;
        if(utilisateur != null){
            if(utilisateur.getCours().contains(c)) return true;
        }
        return false;
    }
    
    public int giveUserID(){
        if(utilisateur == null) return 0;
        return utilisateur.getId();
    }
   
}
