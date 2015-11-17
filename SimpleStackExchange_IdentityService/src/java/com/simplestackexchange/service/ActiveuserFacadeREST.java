/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simpleStackExchange.service;

import com.simpleStackExchange.entity.Activeuser;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.TransactionRequiredException;
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
 * @author mfikria
 */
@Stateless
@Path("activeuser")
public class ActiveuserFacadeREST extends AbstractFacade<Activeuser> {

    @PersistenceContext(unitName = "SimpleStackExchange_IdentityServicePU")
    private EntityManager em;

    public ActiveuserFacadeREST() {
        super(Activeuser.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Activeuser entity) {
        super.create(entity);
    }
    
    @GET
    @Path("auth/{token}")
    @Produces(MediaType.TEXT_PLAIN)
    public Boolean auth(@PathParam("token") String token) throws ParseException
    {
        Activeuser auser = new Activeuser();
        try {
        auser = (Activeuser) em.createNamedQuery("Activeuser.findByToken")
        .setParameter("token", token)
        .getResultList().get(0);
        }catch(IllegalArgumentException | EntityNotFoundException | EJBException | IndexOutOfBoundsException e){
            return false;
        }
        
        // Generate timestamp
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date date = new Date();
        Date date2 = format.parse(format.format(auser.getCreatedTime()));
        long diff = date.getTime() - date2.getTime();
        long diffMinutes = diff / (60 * 1000) % 60;
        
        return (diffMinutes <= 15);
    }
    
    @GET
    @Path("clear/{token}")
    @Produces(MediaType.TEXT_PLAIN)
    public Boolean clear(@PathParam("token") String token)
    {
        Activeuser auser = new Activeuser();
        
        try{
        auser = (Activeuser) em.createNamedQuery("Activeuser.findByToken")
        .setParameter("token", token)
        .getResultList().get(0);
        }catch(IllegalArgumentException | EntityNotFoundException | EJBException | IndexOutOfBoundsException e){
            return false;
        }
        
        // Delete record
        try{
            super.remove(auser);
        }catch(IllegalArgumentException | TransactionRequiredException e) {
            return false;
        }
        
        return true;
    }
    
    @POST
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Activeuser> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Activeuser> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

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
