package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.dao.UserDao;
import fr.istic.taa.jaxrs.domain.User;
import io.swagger.v3.oas.annotations.Parameter;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/user")
@Produces({"application/json", "application/xml"})
public class UserResource {

    UserDao userDao = new UserDao();

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getListUser()  {
        return this.userDao.findAll();
    }

    @GET
    @Path("/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUserById(@PathParam("userId") Long userId)  {
        return this.userDao.findOne(userId);
    }

    @POST
    @Path("/create")
    @Consumes("application/json")
    public Response addUser( @Parameter(description = "Ajout User", required = true) User user) {
        this.userDao.save(user);
        return Response.ok().entity("SUCCESS").build();
    }

    @POST
    @Path("/update")
    @Consumes("application/json")
    public Response updateUser( @Parameter(description = "Update User", required = true) User user) {
        this.userDao.update(user);
        return Response.ok().entity("SUCCESS").build();
    }

    @DELETE
    @Path("/{userId}")
    public void  deleteUser(@PathParam("userId") Long userId) {
        this.userDao.deleteById(userId);

    }
}