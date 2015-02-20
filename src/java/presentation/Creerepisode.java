/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import boundary.EpisodeBdy;
import entity.Episode;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author lucie
 */
@Named
@RequestScoped
public class Creerepisode {
    
    @Inject
    private EpisodeBdy episodeb;
    private Episode episode;
    
    @PostConstruct
    public void onInit() {
        this.episode = new Episode();
    }

    public EpisodeBdy getEpisodeb() {
        return episodeb;
    }

    public void setEpisodeb(EpisodeBdy episodeb) {
        this.episodeb = episodeb;
    }

    public Episode getEpisode() {
        return episode;
    }

    public void setEpisode(Episode episode) {
        this.episode = episode;
    }
    public String doAddEpisode() {
        episode = episodeb.update(episode);
        return "listeepisode.xhtml?faces-redirect=true";
    }
}
