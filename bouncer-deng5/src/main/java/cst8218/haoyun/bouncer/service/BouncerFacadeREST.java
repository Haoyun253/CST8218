/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cst8218.haoyun.bouncer.service;

import cst8218.haoyun.bouncer.entity.Bouncer;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Haoyun Deng
 * 
 * This class has the same purpose as BouncerFacade, but adds a RESTful API. It represents the use of REST methods for interacting with the Bouncer entity.
 * It injects an entity manager that can access the database. It inherits from AbstractFacade, giving it CRUD capabilities.
 * It is @stateless and can handle concurrent client connections due to lack of session state. The @Path annotation designates the endpoint of a class as a resource.
 * Users can access this class and its methods via the HTTP protocol
 */
@DeclareRoles("{Admin,ApiGroup}")
@Stateless
@Path("cst8218.haoyun.bouncer.entity.bouncer")
public class BouncerFacadeREST extends AbstractFacade<Bouncer> {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    public BouncerFacadeREST() {
        super(Bouncer.class);
    }

    /**
      *Accepts a Bouncer entity in the body of a post request for a root resource. 
      * If Id is null, a new entity is created and returned in the response body. Return HTTP Create. If Id is not null, an HTTP error request is returned.
      *
     */
    @RolesAllowed("{Admin,ApiGroup}")
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response createBouncer(Bouncer entity) {
        try {
            if (super.find(entity.getId()) == null) {

                super.create(entity);

                if (entity.getYPosition() == null) {
                    entity.setYPosition(0);
                }

                if (entity.getXPosition() == null) {
                    entity.setYPosition(0);
                }

                if (entity.getYVelocity() == null) {
                    entity.setYVelocity(0);
                }

                return Response.status(Response.Status.CREATED).entity(entity).build();
            } else {
                return Response.status(Response.Status.BAD_REQUEST).build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    /**
      * Accepts an Id appended to the end of the root resource on a POST request and a Bouncer entity in the request body.
      * If the ID is not in the database, HTTP NOT_FOUND is returned. If there is no match between the provided Id and the returned Bouncer, HTTP CONFLICT is returned.
      * If the provided ID matches an ID in the body, updates the bouncer in the database with a non-null field while retaining any data that was not overwritten, returning HTTP CREATED.
      *
     */
    @RolesAllowed("{Admin,ApiGroup}")
    @POST
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    // Response method found on net
    public Response editPost(@PathParam("id") Long id, Bouncer entity) {
        try {
            Bouncer bouncer = super.find(entity.getId());

            if (bouncer == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            } else if (!bouncer.getId().equals(id)) {
                return Response.status(Response.Status.CONFLICT).build();
            } else {
                entity.updates(bouncer);
                return Response.status(Response.Status.OK).entity(bouncer).build();
            }
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    /**
     * Limit the ability to make PUT requests to root resources. Return HTTP forbidden.
     */
    @RolesAllowed("{Admin,ApiGroup}")
    @PUT
    public Response put() {
        return Response.status(Response.Status.FORBIDDEN).build();
    }

      /**
      * Accepts an Id appended to the end of the root resource on a PUT request and a Bouncer entity in the request body.
      * If the ID is not in the database, HTTP NOT_FOUND is returned. If there is no match between the provided Id and the returned Bouncer, HTTP CONFLICT is returned.
      * If the provided ID matches an ID in the body, then completely replace the bouncer in the database with the provided bouncer, returning HTTP CREATED.
      *
     */
    @RolesAllowed("{Admin,ApiGroup}")
    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response edit(@PathParam("id") Long id, Bouncer entity) {
        try {
            Bouncer bouncer = super.find(entity.getId());

            if (bouncer == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            } else if (!bouncer.getId().equals(id)) {
                return Response.status(Response.Status.CONFLICT).build();
            } else {
                super.edit(entity);
                return Response.status(Response.Status.OK).build();
            }
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    @RolesAllowed("{Admin,ApiGroup}")
    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }

    @RolesAllowed("{Admin,ApiGroup}")
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Bouncer find(@PathParam("id") Long id) {
        return super.find(id);
    }

    @RolesAllowed("{Admin,ApiGroup}")
    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Bouncer> findAll() {
        return super.findAll();
    }

    @RolesAllowed("{Admin,ApiGroup}")
    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Bouncer> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }
    /**
      *Returns the count of Bouncer entities in the Bouncer table.
      *
     */
    @RolesAllowed("{Admin,ApiGroup}")
    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public Response countREST() {
        return Response.ok(String.valueOf(super.count())).build();
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
