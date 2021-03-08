package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.dao.SectionDao;
import fr.istic.taa.jaxrs.domain.Section;
import io.swagger.v3.oas.annotations.Parameter;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/section")
@Produces({"application/json", "application/xml"})
public class SectionResource {

    SectionDao sectionDao = new SectionDao();

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Section> getListSection()  {
        return this.sectionDao.findAll();
    }

    @GET
    @Path("/{sectionId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Section getSectionById(@PathParam("sectionId") Long sectionId)  {
        return this.sectionDao.findOne(sectionId);
    }

    @POST
    @Path("/create")
    @Consumes("application/json")
    public Response addSection( @Parameter(description = "Ajout Section", required = true) Section section) {
        this.sectionDao.save(section);
        return Response.ok().entity("SUCCESS").build();
    }

    @POST
    @Path("/update")
    @Consumes("application/json")
    public Response updateSection( @Parameter(description = "Update Section", required = true) Section section) {
        this.sectionDao.update(section);
        return Response.ok().entity("SUCCESS").build();
    }

    @DELETE
    @Path("/{sectionId}")
    public void  deleteSection(@PathParam("sectionId") Long sectionId) {
        this.sectionDao.deleteById(sectionId);

    }
}