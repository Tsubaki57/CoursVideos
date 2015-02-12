/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import utils.Sha;

/**
 *
 * @author Loris
 */
@Entity
@NamedQuery(name = "findAllUtilisateurs", query = "SELECT u FROM Utilisateur u")
public class Utilisateur implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String nom;
    private String prenom;
    private String mail;
    private String mdp;
    private String statut;
    @ManyToMany
    private List<Cours> cours;
    @ManyToMany
    private List<Episode> episodes;

    public Utilisateur() {
        this.statut = "user";
    }

    public Utilisateur(String nom, String prenom, String mail, String mdp, String statut) {
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail.toLowerCase();
        this.mdp = Sha.hash256(mdp);
        this.statut = statut;
        this.cours = new ArrayList<Cours>();
        this.episodes = new ArrayList<Episode>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail.toLowerCase();
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = Sha.hash256(mdp);
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public List<Cours> getCours() {
        return cours;
    }

    public void setCours(List<Cours> cours) {
        this.cours = cours;
    }

    public List<Episode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(List<Episode> episodes) {
        this.episodes = episodes;
    }

}
