package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.dao.SondageDao;
import fr.istic.taa.jaxrs.domain.Sondage;
import io.swagger.v3.oas.annotations.Parameter;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/sondage")
@Produces({"application/json", "application/xml"})
public class SondageResource {

    SondageDao sondageDao = new SondageDao();

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Sondage> getListSondage()  {
        return this.sondageDao.findAll();
    }

    @GET
    @Path("/{sondageId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Sondage getSondageById(@PathParam("sondageId") Long sondageId)  {
        return this.sondageDao.findOne(sondageId);
    }

    @POST
    @Path("/create")
    @Consumes("application/json")
    public Response addSondage( @Parameter(description = "Ajout Sondage", required = true) Sondage sondage) {
        this.sondageDao.save(sondage);
        return Response.ok().entity("SUCCESS").build();
    }

    @POST
    @Path("/update")
    @Consumes("application/json")
    public Response updateSondage( @Parameter(description = "Update Sondage", required = true) Sondage sondage) {
        this.sondageDao.update(sondage);
        return Response.ok().entity("SUCCESS").build();
    }

    @DELETE
    @Path("/{sondageId}")
    public void  deleteSondage(@PathParam("sondageId") Long sondageId) {
        this.sondageDao.deleteById(sondageId);

    }
}