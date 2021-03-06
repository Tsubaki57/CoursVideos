package presentation;

import boundary.UtilisateurBdy;
import entity.Utilisateur;
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
public class Inscription {

    @Inject
    UtilisateurBdy utilisateurs;
    private Utilisateur utilisateur;

    @PostConstruct
    public void onInit() {
        this.utilisateur = new Utilisateur();
    }

    public UtilisateurBdy getUtilisateurs() {
        return utilisateurs;
    }

    public void setUtilisateurs(UtilisateurBdy utilisateurs) {
        this.utilisateurs = utilisateurs;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public String doAddUser() {
        utilisateur = utilisateurs.update(utilisateur);
        return "listeutilisateurs.xhtml?faces-redirect=true";
    }

}
