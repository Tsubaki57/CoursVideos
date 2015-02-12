/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import boundary.UtilisateurBdy;
import entity.Utilisateur;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import utils.Sha;

/**
 *
 * @author Loris
 */
@Named
@SessionScoped
public class connexion implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Inject
    private UtilisateurBdy utilisateurs;
    private Utilisateur utilisateur;
    private String mail;
    private String pw;
    
    @PostConstruct
    public void onInit() {
        System.out.println("Init @postconstruct");
        this.utilisateur = new Utilisateur();
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        System.out.println("Setmail");
        this.mail = mail;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = Sha.hash256(pw);
    }
    
    public String checkLogin(){
        System.out.println("Connexion: "+mail+" "+pw);
        String url = "connexion.xhtml?faces-redirect=true";
        Utilisateur u = utilisateurs.find(this.mail);
        if(u!=null){
            if(u.getMdp().equals(this.pw)){
                url = "accueil.xhtml?faces-redirect=true";
            }
        }
        return url;
    }
}
