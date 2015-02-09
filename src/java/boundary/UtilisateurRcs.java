/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import entity.Utilisateur;
import java.net.URI;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Loris
 */
@Stateless
@Path("inscriptionBdy")
public class UtilisateurRcs {

    @Inject
    UtilisateurBdy utilisateurs;

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response inscriptions() {
        List<Utilisateur> liste = utilisateurs.findAll();
        GenericEntity<List<Utilisateur>> resultat = new GenericEntity<List<Utilisateur>>(liste) {
        };
        return Response.ok(resultat).build();
    }

    @GET
    @Path("{id}")
    public Response find(@PathParam("id") long id) {
        Utilisateur u = utilisateurs.find(id);
        if (u != null) {
            return Response.ok(u).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    public Response enregistrement(Utilisateur request, @Context UriInfo info) {
        Utilisateur u = utilisateurs.update(request);
        long id = u.getId();
        URI uri = info.getAbsolutePathBuilder().path("/" + id).build();
        JsonObject confirmation = Json.createObjectBuilder().
                add("confirmation-id", u.getId()).build();
        return Response.created(uri).entity(confirmation).build();
    }
}
