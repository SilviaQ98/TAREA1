package com.distribuida.rest;

import com.distribuida.db.authors;
import com.distribuida.services.authorsServiceImpl;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@ApplicationScoped
@Path("/authors")
public class authorsRest {

    @Inject
    private authorsServiceImpl authorsService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<authors> get() {
        return authorsService.get();
    }

    @GET
    @Path("{/id}")
    @Produces(MediaType.APPLICATION_JSON)
    public authors findById(@PathParam("id") Integer id) {
        return authorsService.findById(id);
    }
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(authors authors) {
        authorsService.create(authors);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public authors update(Integer id, authors authors) {
        return authorsService.update(id, authors);
    }

    @DELETE
    @Path("{/id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void delete( @PathParam("id") Integer id) {
        authorsService.delete(id);
    }
}

