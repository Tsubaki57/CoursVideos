/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import boundary.CoursBdy;
import boundary.EpisodeBdy;
import entity.Cours;
import entity.Episode;
import java.util.List;
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
    @Inject
    private CoursBdy coursb;
    private int idec;

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

    public CoursBdy getCoursb() {
        return coursb;
    }

    public void setCoursb(CoursBdy coursb) {
        this.coursb = coursb;
    }

    public int getIdec() {
        return idec;
    }

    public void setIdec(int i) {
        this.idec = i;
    }

    public String doAddEpisode() {
        try {
            List<Cours> lc = coursb.findAll();
            for (Cours c : lc){
                if(c.getId() == this.idec) episode.setCours(c);
            }
            episode = episodeb.update(episode);
            
        } catch (Exception e) {
            e.printStackTrace();
            
        }
        return "listeepisode.xhtml?faces-redirect=true";
    }
}
