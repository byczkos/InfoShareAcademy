package org.infoshare;

import org.infoshare.model.User;
import org.infoshare.model.UserStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.io.InvalidObjectException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

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

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findUserById(@PathParam("id") int id) {
       if (us.getBase().containsKey(id)) {
           return Response.ok(us.getBase().get(id)).build();
       } else {
           return Response.status(404).build();
       }
    }

    // dodawanie uzytkownika do listy

    @PUT
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response putUser(User user) {
        if (user == null) {
            return Response.status(400).build();
        } else {
            us.add(user);
            return usersList();
        }
    }
    // usuwanie uzytkownika z listy
    @DELETE
    @Path("/delete")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteUser(@QueryParam("id") Integer id) throws InvalidObjectException {
        if (us.getBase().containsKey(id)) {
            us.remove(id);
            return usersList();
        } else {
            return Response.status(404).build();
        }
    }

    @POST
    @Path("/login")
    public Response login(@FormParam("username") String username, @FormParam("pass") String pass) throws URISyntaxException {
        Map<String, User> usersByLogin = new HashMap<>();
        usersByLogin = us.getBase().values()
                .stream()
                .filter(x -> x.getCredentials() !=null)
                .filter(x -> x.getCredentials().getPassword() != null)
                .collect(Collectors.toMap(x -> x.getCredentials().getUsername(), x -> x));
        if (usersByLogin.containsKey(username)) {
            if (usersByLogin.get(username).getCredentials().getPassword().equals(pass)) {
                return Response.ok().build();
            } else {
                return Response.ok("Zly login i haslo").build();
            }
        }
        return Response.temporaryRedirect(URI.create("http://www.wp.pl")).build();
    }
}
