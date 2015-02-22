/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import boundary.EpisodeBdy;
import entity.Episode;
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
public class ListeEpisode {

    @Inject
    private EpisodeBdy episode;
    private List<Episode> liste;

    public EpisodeBdy getEpisode() {
        return episode;
    }

    public void setEpisode(EpisodeBdy episode) {
        this.episode = episode;
    }

    public List<Episode> getListe() {
        liste = episode.findAll();
        return liste;
    }

    public void setListe(List<Episode> liste) {
        this.liste = liste;
    }

    /**
     * Action handler - appelé lorsque l'utilisateur sélectionne une ligne dans
     * la DataTable pour voir les détails
     *
     * @param id Id du cours à linker
     * @return URL du cours
     */
    public String showDetailsEpisode(int id) {
        return "listeepisode?idepisode=" + id;
    }    
    
}