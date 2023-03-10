package com.distribuida.rest;

import com.distribuida.db.Book;
import com.distribuida.service.BookService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.Map;
import java.util.concurrent.ExecutionException;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;
import static jakarta.ws.rs.core.Response.Status.ACCEPTED;

@ApplicationScoped
@Path("/books")
public class BookRest {
    @Inject
    private BookService bookService;

    @GET
    @Path("/{id}")
    @Produces(APPLICATION_JSON)
    public Book findOneById(@PathParam("id") Long id) throws ExecutionException, InterruptedException {
        return this.bookService.findOne(id);
    }

    @GET
    @Produces(APPLICATION_JSON)
    public Response findAll() throws ExecutionException, InterruptedException {
        return Response.status(ACCEPTED).entity(bookService.findAll()).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Map<String, Long> update(@PathParam("id") Long id, Book book) {
        return Map.of("rowsChanged", this.bookService.update(id, book));
    }

    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Map<String, Long> save(Book book) {
        return Map.of("rowsChanged", this.bookService.save(book));
    }

    @DELETE
    @Path("/{id}")
    @Produces(APPLICATION_JSON)
    public Map<String, Long> delete(@PathParam("id") Long id) {
        return Map.of("rowsChanged", this.bookService.delete(id));
    }
}
