package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.dao.TableauDao;
import fr.istic.taa.jaxrs.dao.generic.AbstractJpaDao;
import fr.istic.taa.jaxrs.dao.generic.EntityManagerHelper;
import fr.istic.taa.jaxrs.domain.Tableau;
import io.swagger.v3.oas.annotations.Parameter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/tableau")
@Produces({"application/json", "application/xml"})
public class TableauResource {

    TableauDao tableauDao = new TableauDao();

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tableau> getListTableau()  {
        return this.tableauDao.findAll();
    }

    @GET
    @Path("/{tableauId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Tableau getTableauById(@PathParam("tableauId") Long tableauId)  {
        return this.tableauDao.findOne(tableauId);
    }

    @POST
    @Path("/create")
    @Consumes("application/json")
    public Response addTableau( @Parameter(description = "Ajout Tableau", required = true) Tableau tableau) {
        this.tableauDao.save(tableau);
        return Response.ok().entity("SUCCESS").build();
    }

    @POST
    @Path("/update")
    @Consumes("application/json")
    public Response updateTableau( @Parameter(description = "Update Tableau", required = true) Tableau tableau) {
        this.tableauDao.update(tableau);
        return Response.ok().entity("SUCCESS").build();
    }

    @DELETE
    @Path("/{tableauId}")
    public void  deleteTableau(@PathParam("tableauId") Long tableauId) {
        this.tableauDao.deleteById(tableauId);

    }
}