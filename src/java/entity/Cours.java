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
import javax.persistence.OneToMany;

/**
 *
 * @author Loris
 */
@Entity
public class Cours implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String titre;
    private String image;
    private double prix;
    @OneToMany(mappedBy = "cours")
    private List<Episode> episodes;
    @ManyToMany(mappedBy = "cours")
    private List<Utilisateur> utilisateurs;

    public Cours() {
    }

    public Cours(String titre, String image, double prix) {
        this.titre = titre;
        this.image = image;
        this.prix = prix;
        this.episodes = new ArrayList<Episode>();
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public List<Episode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(List<Episode> episodes) {
        this.episodes = episodes;
    }

    public List<Utilisateur> getUtilisateurs() {
        return utilisateurs;
    }

    public void setUtilisateurs(List<Utilisateur> utilisateurs) {
        this.utilisateurs = utilisateurs;
    }

}
