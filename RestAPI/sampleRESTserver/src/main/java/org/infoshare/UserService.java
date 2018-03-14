package org.infoshare;

import org.infoshare.model.UserStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
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



}
