/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cst8218.haoyun.bouncer.service;

import cst8218.haoyun.bouncer.entity.Bouncer;
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
 * Allow for restful services on the appUser table
 * @author noahh
 */
@DeclareRoles({"Admin", "ApiGroup"})
@RolesAllowed({"Admin", "ApiGroup"})
@Stateless
@Path("cst8218.haoyun.bouncer.entity.bouncer")
public class BouncerFacadeREST extends AbstractFacade<Bouncer> {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    public BouncerFacadeREST() {
        super(Bouncer.class);
    }
    
<<<<<<< HEAD
    @RolesAllowed({"Admin", "ApiGroup"})
=======
    //Add roles that are allowed
//    @RolesAllowed("{Admin,Administration, Regular}")
>>>>>>> 1fd4190924eb11e3782300e216ac1efa2bf61d46
    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Bouncer entity) {
        super.create(entity);
    }
<<<<<<< HEAD

    @RolesAllowed({"Admin", "ApiGroup"})    
=======
    
    //Add roles that are allowed
//    @RolesAllowed("{Admin,Administration, Regular}")    
>>>>>>> 1fd4190924eb11e3782300e216ac1efa2bf61d46
    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Long id, Bouncer entity) {
        super.edit(entity);
    }
    
<<<<<<< HEAD
    @RolesAllowed({"Admin", "ApiGroup"})
=======
    //Add roles that are allowed
//    @RolesAllowed("{Admin,Administration, Regular}")
>>>>>>> 1fd4190924eb11e3782300e216ac1efa2bf61d46
    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }
    
<<<<<<< HEAD
    @RolesAllowed({"Admin", "ApiGroup"})
=======
    //Add roles that are allowed
//    @RolesAllowed("{Admin,Administration, Regular}")
>>>>>>> 1fd4190924eb11e3782300e216ac1efa2bf61d46
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Bouncer find(@PathParam("id") Long id) {
        return super.find(id);
    }
    
<<<<<<< HEAD
    @RolesAllowed({"Admin", "ApiGroup"})
=======
    //Add roles that are allowed
//    @RolesAllowed("{Admin,Administration, Regular}")
>>>>>>> 1fd4190924eb11e3782300e216ac1efa2bf61d46
    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Bouncer> findAll() {
        return super.findAll();
    }
    
<<<<<<< HEAD
    @RolesAllowed({"Admin", "ApiGroup"})
=======
    //Add roles that are allowed
//    @RolesAllowed("{Admin,Administration, Regular}")
>>>>>>> 1fd4190924eb11e3782300e216ac1efa2bf61d46
    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Bouncer> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }
    
<<<<<<< HEAD
    @RolesAllowed({"Admin", "ApiGroup"})
=======
    //Add roles that are allowed
//    @RolesAllowed("{Admin,Administration, Regular}")
>>>>>>> 1fd4190924eb11e3782300e216ac1efa2bf61d46
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
