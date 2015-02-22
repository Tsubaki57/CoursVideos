/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import boundary.EpisodeBdy;
import entity.Episode;
import java.util.ArrayList;
import java.util.List;
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
public class ListeEpisode {

    @Inject
    private EpisodeBdy episode;
    private List<Episode> liste;
    private int idec;
    private String courstitle;

    @PostConstruct
    public void onInit() {
        this.idec = 0;
        this.courstitle = "Tous les cours";
    }

    public EpisodeBdy getEpisode() {
        return episode;
    }

    public void setEpisode(EpisodeBdy episode) {
        this.episode = episode;
    }

    public List<Episode> getListe() {
        liste = episode.findAll();
        List listeok = new ArrayList<Episode>();
        if (this.idec != 0) {
            for (Episode e : liste) {
                if (e.getCours() != null) {
                    if (e.getCours().getId() == this.idec) {
                        listeok.add(e);
                        this.courstitle = e.getCours().getTitre();
                    }
                }
            }
        } else {
            listeok = liste;
        }

        return listeok;
    }

    public void setListe(List<Episode> liste) {
        this.liste = liste;
    }

    public int getIdec() {
        return idec;
    }

    public void setIdec(int idec) {
        this.idec = idec;
    }

    public String getCourstitle() {
        return courstitle;
    }

    public void setCourstitle(String courstitle) {
        this.courstitle = courstitle;
    }
    
    

    /**
     * Action handler - appelé lorsque l'utilisateur sélectionne une ligne dans
     * la DataTable pour voir les détails
     *
     * @param id Id du cours à linker
     * @return URL du cours
     */
    public String showDetailsEpisode(int id) {
        return "episode?id=" + id +"&faces-redirect=true";
    }

}
