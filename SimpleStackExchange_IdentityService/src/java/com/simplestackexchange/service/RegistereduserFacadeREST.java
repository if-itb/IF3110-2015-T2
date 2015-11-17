/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simpleStackExchange.service;

import com.simpleStackExchange.entity.Activeuser;
import com.simpleStackExchange.entity.Registereduser;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import org.apache.http.client.methods.HttpPost;

/**
 *
 * @author mfikria
 */
@Stateless
@Path("user")
public class RegistereduserFacadeREST extends AbstractFacade<Registereduser> {

    @PersistenceContext(unitName = "SimpleStackExchange_IdentityServicePU")
    private EntityManager em;

    public RegistereduserFacadeREST() {
        super(Registereduser.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Registereduser entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Registereduser entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Registereduser find(@PathParam("id") Integer id) {
        return super.find(id);
    }
    
    @POST
    @Path("email")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Override
    public Registereduser findByEmail(@FormParam("email") String email) {
        return super.findByEmail(email);
    }
    
    @POST
    @Path("validate")
    @Produces(MediaType.TEXT_PLAIN)
    public String validate(@FormParam("email") String email, @FormParam("password") String password) throws JAXBException, IOException
    {
        Registereduser user;
        try {
            user = new Registereduser(super.findByEmail(email));
        }catch(IllegalArgumentException | EntityNotFoundException | EJBException | IndexOutOfBoundsException e){
            return "";
        }
            if(user.getPassword().equals(password)) {
 
                // generate token
                String token = UUID.randomUUID().toString().replaceAll("-", "");
               
                // Generate timestamp
                Date date = new Date();
                Timestamp timestamp = new Timestamp(date.getTime());
                
                
                // Create Activeuser object
                Activeuser auser = new Activeuser(token, user.getUid(), date);
               /*
               // Create marshaller for encoding to XML format
               StringWriter sw = new StringWriter();
               JAXBContext context = JAXBContext.newInstance(Activeuser.class);
               Marshaller marshaller = context.createMarshaller();
               marshaller.marshal(auser, sw);
               */
               
               // Insert token authentication to database
               em.persist(auser);
  
               // return auserFacadeREST.countREST();
                return token;
            }
            else return "";
    }
    
    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Registereduser> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Registereduser> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
