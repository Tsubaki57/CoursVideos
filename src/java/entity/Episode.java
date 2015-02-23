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
import javax.persistence.ManyToOne;

/**
 *
 * @author Loris
 */
@Entity
public class Episode implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String titre;
    private int duree;
    private String lien;
    @ManyToOne
    private Cours cours;
    @ManyToMany(mappedBy = "episodes")
    private List<Utilisateur> utilisateurs;

    public Episode() {
    }

    public Episode(String titre, int duree, String lien) {
        this.titre = titre;
        this.duree = duree;
        this.lien = lien;      
        this.utilisateurs = new ArrayList<Utilisateur>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public String getLien() {
        return lien;
    }

    public void setLien(String lien) {
        String[] split = lien.split("=");
        this.lien = split[1];
    }

    public Cours getCours() {
        return cours;
    }

    public void setCours(Cours cours) {
        this.cours = cours;
    }

    public List<Utilisateur> getUtilisateurs() {
        return utilisateurs;
    }

    public void setUtilisateurs(List<Utilisateur> utilisateurs) {
        this.utilisateurs = utilisateurs;
    }

}
