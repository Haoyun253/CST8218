/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cst8218.haoyun.bouncer.service;

import cst8218.haoyun.bouncer.entity.AppUser;
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
import javax.ws.rs.core.MediaType;

/**
 * Add restful services to Bouncer
 * @author noahh
 */
@DeclareRoles("{Admin,Administration,Regular}")
@Stateless
@Path("cst8218.haoyun.bouncer.entity.appuser")
public class AppUserFacadeREST extends AbstractFacade<AppUser> {
    
    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    public AppUserFacadeREST() {
        super(AppUser.class);
    }
    //Add roles that are allowed
    @RolesAllowed("Admin,Administration")
    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(AppUser entity) {
        super.create(entity);
    }
    //Add roles that are allowed
    @RolesAllowed("Admin,Administration")
    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Long id, AppUser entity) {
        super.edit(entity);
    }
    //Add roles that are allowed
    @RolesAllowed("Admin,Administration")
    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }
    //Add roles that are allowed
    @RolesAllowed("Admin,Administration")
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public AppUser find(@PathParam("id") Long id) {
        return super.find(id);
    }
    //Add roles that are allowed
    @RolesAllowed("Admin,Administration")
    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<AppUser> findAll() {
        return super.findAll();
    }
    //Add roles that are allowed
    @RolesAllowed("Admin,Administration")
    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<AppUser> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }
    //Add roles that are allowed
    @RolesAllowed("Admin,Administration")
    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
