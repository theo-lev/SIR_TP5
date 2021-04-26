package fr.istic.taa.jaxrs.rest;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.Gson;
import fr.istic.taa.jaxrs.dao.FicheDao;
import fr.istic.taa.jaxrs.domain.Fiche;
import io.swagger.v3.oas.annotations.Parameter;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/fiche")
@Produces("application/json")

public class FicheResource {

    FicheDao ficheDao = new FicheDao();

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Fiche> getListFiche()  {
        return this.ficheDao.findAll();
    }

    @GET
    @Path("/{ficheId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Fiche getFicheById(@PathParam("ficheId") Long ficheId)  {
        return this.ficheDao.findOne(ficheId);
    }

    @POST
    @Path("/create")
    @Consumes("MediaType.TEXT_PLAIN")
    public Response addFiche( @Parameter(description = "Ajout Fiche", required = true) String fiche)  {
        Gson g = new Gson();
        Fiche f = g.fromJson(fiche, Fiche.class);
        this.ficheDao.save(f);
        return Response.ok().entity("SUCCESS").build();
    }

    @POST
    @Path("/create")
    @Consumes("application/json")
    public Response updateFiche( @Parameter(description = "Update Fiche", required = true) Fiche fiche) {
        this.ficheDao.update(fiche);
        return Response.ok().entity("SUCCESS").build();
    }

    @DELETE
    @Path("/{ficheId}")
    public void  deleteFiche(@PathParam("ficheId") Long ficheId) {
        this.ficheDao.deleteById(ficheId);

    }
}