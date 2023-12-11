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
 *
 * @author noahh
 */
@DeclareRoles({"Admin", "ApiGroup"})
@RolesAllowed({"Admin", "ApiGroup"})
@Stateless
@Path("cst8218.haoyun.bouncer.entity.appuser")
public class AppUserFacadeREST extends AbstractFacade<AppUser> {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    public AppUserFacadeREST() {
        super(AppUser.class);
    }
    
    @RolesAllowed({"Admin", "ApiGroup"})
    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(AppUser entity) {
        super.create(entity);
    }
    
    @RolesAllowed({"Admin", "ApiGroup"})
    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Long id, AppUser entity) {
        super.edit(entity);
    }
    
    @RolesAllowed({"Admin", "ApiGroup"})
    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }
    
    @RolesAllowed({"Admin", "ApiGroup"})
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public AppUser find(@PathParam("id") Long id) {
        return super.find(id);
    }
    
    @RolesAllowed({"Admin", "ApiGroup"})
    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<AppUser> findAll() {
        return super.findAll();
    }
    
    @RolesAllowed({"Admin", "ApiGroup"})
    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<AppUser> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }
    
    @RolesAllowed({"Admin", "ApiGroup"})
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
