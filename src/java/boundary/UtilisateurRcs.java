/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import entity.Utilisateur;
import java.net.URI;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
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
    UtilisateurBdy inscriptions;
    
    @POST
    public Response enregistrement(Utilisateur request, @Context UriInfo info){
        Utilisateur u = inscriptions.updateUtil(request);
        long id= u.getId();
        URI uri = info.getAbsolutePathBuilder().path("/"+id).build();
        JsonObject confirmation = Json.createObjectBuilder().
                add("confirmation-id",u.getId()).build();
        return Response.created(uri).entity(confirmation).build();
    }
}
