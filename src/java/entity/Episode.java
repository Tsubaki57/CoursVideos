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
    private int titre;
    private String duree;
    private int lien;
    @ManyToOne
    private Cours cours;
    @ManyToMany(mappedBy = "episodes")
    private List<Utilisateur> utilisateurs;

    public Episode() {
    }

    public Episode(int id, int titre, String duree, int lien, Cours cours) {
        this.id = id;
        this.titre = titre;
        this.duree = duree;
        this.lien = lien;
        this.cours = cours;
        this.utilisateurs = new ArrayList<Utilisateur>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTitre() {
        return titre;
    }

    public void setTitre(int titre) {
        this.titre = titre;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public int getLien() {
        return lien;
    }

    public void setLien(int lien) {
        this.lien = lien;
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
