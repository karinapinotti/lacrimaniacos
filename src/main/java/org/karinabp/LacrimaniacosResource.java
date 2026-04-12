package org.karinabp;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/lacrimaniacos")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)
public class LacrimaniacosResource {

    private int i = 0;

    @GET
    public int getI(String x) {
        return i;
    }

    @POST
    public void addI() {
        i++;
    }

    @DELETE
    public void removeI() {
        i--;
    }

    @PUT
    public void setI(int i) {
        this.i = i;
    }

    @RestClient
    LacriService lacriService;

    @GET
    @Path("/starships")
    @Produces(MediaType.APPLICATION_JSON)
    public String getLacrimaniacos() {
        return lacriService.getLacrimaniacos();
    }
}
