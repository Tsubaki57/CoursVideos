/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import boundary.EpisodeBdy;
import boundary.UtilisateurBdy;
import entity.Episode;
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
public class AfficheEpisode {

    @Inject
    private EpisodeBdy episodes;
    @Inject
    private UtilisateurBdy utilisateurs;
    private Episode episode;
    private int idep;
    private String cours;

    @PostConstruct
    public void onInit() {
        this.idep = 0;
    }

    public EpisodeBdy getEpisodes() {
        return episodes;
    }

    public void setEpisodes(EpisodeBdy episodes) {
        this.episodes = episodes;
    }

    public Episode getEpisode() {
        List<Episode> l = episodes.findAll();
        if (this.idep != 0) {
            for (Episode ep : l) {
                if (ep.getId() == this.idep) {
                    this.setEpisode(ep);
                }
            }
        }
        return episode;
    }

    public void setEpisode(Episode ep) {
        this.episode = ep;
    }

    public int getIdep() {
        return idep;
    }

    public void setIdep(int idep) {
        this.idep = idep;
    }

    public String getCours() {
        episode = getEpisode();

        if (episode == null) {
            return "olala gros probleme";
        }

        if (episode.getCours() != null) {
            cours = episode.getCours().getTitre();
        } else {
            cours = "Inconnu";
        }
        return cours;
    }

    public void setCours(String cours) {
        this.cours = cours;
    }



}
