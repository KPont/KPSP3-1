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
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;

/**
 * REST Web Service
 *
 * @author Kasper
 */
@Path("AllPlayerNames")
public class rest {
    List<Player> pList = new ArrayList();
    Gson gson = new Gson();

    @Context
    private UriInfo context;
    
    /**
     * Creates a new instance of rest
     */
    public rest() {
        pList.add(new Player(1, "James Rodríguez", "Colombia"));
        pList.add(new Player(2, "Thomas Mueller", "Colombia"));
        pList.add(new Player(3, "Messi", "Colombia"));
        pList.add(new Player(4, "Neymar", "Colombia"));
        pList.add(new Player(5, "van Persie", "Colombia"));
        
    }

    @GET
    @Produces("application/json")
    public String getText() {
        //TODO return proper representation object
//        for (int i = 0; i < pList.size(); i++) {
//            
//        }
        return gson.toJson(pList);
    }

    /**
     * PUT method for updating or creating an instance of rest
     *
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @POST
    @Consumes("text/plain")
    public void putText(String content) {
    }
    
    @GET
    @Produces("application/json")
    @Path("Player")
    public String getPlayer() {

        return gson.toJson(pList);
    }
}
