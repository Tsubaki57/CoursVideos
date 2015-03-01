/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import boundary.EpisodeBdy;
import entity.Episode;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Loris
 */
@Named
@ViewScoped
public class ModifierEpisode implements Serializable{
    
    @Inject
    private EpisodeBdy episodes;
    private Episode episode;
    private int idep;
    
    @PostConstruct
    public void onInit(){
    }

    public EpisodeBdy getEpisodes() {
        return episodes;
    }

    public void setEpisodes(EpisodeBdy episodes) {
        this.episodes = episodes;
    }

    public Episode getEpisode() {
        return episode;
    }

    public void setEpisode(Episode episode) {
        this.episode = episode;
    }

    public int getIdep() {
        return idep;
    }

    public void setIdep(int idep) {
        this.episode = this.episodes.find(idep);
        this.idep = idep;
    }
    
    public String doChangeEpisode(){
        this.episode = this.episodes.merge(this.episode);
        return "listeepisode.xhtml?faces-redirect=true";
    }
    
}
