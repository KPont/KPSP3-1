/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Kasper
 */
@Path("Player")
public class PlayerResource {

    List<Player> pList = new ArrayList();
    Gson gson = new Gson();
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PlayerResource
     */
    public PlayerResource() {
        pList.add(new Player(1, "James Rodríguez", "Colombia"));
        pList.add(new Player(2, "Thomas Mueller", "Colombia"));
        pList.add(new Player(3, "Messi", "Colombia"));
        pList.add(new Player(4, "Neymar", "Colombia"));
        pList.add(new Player(5, "van Persie", "Colombia"));
    }

    /**
     * Retrieves representation of an instance of rest.PlayerResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getText() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }
    @GET
    @Produces("application/json")
    @Path("{id}")
    public String getPlayer(@PathParam("id") String id) {
        //TODO return proper representation object
//        if(pList.get(Integer.parseInt(id)).getId())
        String str = "";
        boolean fail = true;
        for (int i = 0; i < pList.size(); i++) {
            if(pList.get(i).getId() == Integer.parseInt(id)){
                str = gson.toJson(pList.get(i));
                fail = false;
            }
        }
        if(fail){
            throw new WebApplicationException("No Player found with the given ID",Response.Status.NOT_FOUND);
        }
//        String str = gson.toJson(pList.get(Integer.parseInt(id) - 1));
        return str;
    }

    @PUT
    @Consumes("application/xml")
    public void putXml(String content) {
    }
}
