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
    private Cours cours;
    @Inject
    private CoursBdy coursb;
    private List<Cours> liste;

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

    public Cours getCours() {
        return cours;
    }

    public void setCours(Cours cours) {
        this.cours = cours;
    }

    public List<Cours> getListe() {
        liste = coursb.findAll();
        return liste;
    }

    public void setListe(List<Cours> liste) {
        this.liste = liste;
    }

    public CoursBdy getCoursb() {
        return coursb;
    }

    public void setCoursb(CoursBdy coursb) {
        this.coursb = coursb;
    }

    public String doAddEpisode() {
        episode.setCours(cours);
        episode = episodeb.update(episode);
        return "listeepisode.xhtml?faces-redirect=true";
    }
}
