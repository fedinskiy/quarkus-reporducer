package org.acme;

import io.smallrye.mutiny.Uni;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/hello")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TestResource {

    @GET
    @Path("broken")
    public Uni<Response> broken() {
        return Uni.createFrom().item(Response.ok("Slovník").build());
    }

    @GET
    @Path("valid")
    public Uni<Response> valid() {
        return Uni.createFrom().item(Response.ok("Thinking fast and slow").build());
    }
}
