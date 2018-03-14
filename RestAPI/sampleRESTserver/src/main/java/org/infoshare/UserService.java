package org.infoshare;

import org.infoshare.model.UserStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("/users")
public class UserService {

    private Logger LOG = LoggerFactory.getLogger(UserService.class);

    @Inject
    private UserStore us;

    public UserService() {
    }

    @Context
    UriInfo uriInfo;

    @GET
    @Path("/hello/{text}")
    @Produces(MediaType.TEXT_PLAIN)

//    Query param podane zostaja po znaku zapytania jako parametry zapytania, natomiast
//    Path param podawane są po slashu

    public Response sayHello(@QueryParam("name") String name, @PathParam("text") String text) {
        LOG.info("Hello world!");
//        return Response.ok("Hello world "+ name +" "+ text).build();

        // Proby roznych metod po wstrzyknieciu kontekstu UriInfo

        return Response.ok(uriInfo.getAbsolutePath() +"\n"
                + uriInfo.getMatchedURIs() +"\n"
                + uriInfo.getBaseUri()+"\n"
                + uriInfo.getPath()).build();
    }

    @GET
    @Path("/user-agent/")
    @Produces(MediaType.TEXT_PLAIN)

    public Response clientReader(@HeaderParam("user-agent") String agent) {
        return Response.ok(agent).build();
    }

    // Wyswietlanie listy uzytkownikow
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)

    public Response usersList() {

        if (us.getBase().isEmpty() || us.getBase() == null) {
            return Response.status(204).build();
        } else {
            return Response.ok(us.getBase()).build();
        }
    }

}