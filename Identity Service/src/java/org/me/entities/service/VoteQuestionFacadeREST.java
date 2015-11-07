/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.entities.service;

import java.util.List;
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
import javax.ws.rs.core.PathSegment;
import org.me.entities.VoteQuestion;
import org.me.entities.VoteQuestionPK;

/**
 *
 * @author Asus
 */
@Stateless
@Path("org.me.entities.votequestion")
public class VoteQuestionFacadeREST extends AbstractFacade<VoteQuestion> {
  @PersistenceContext(unitName = "Identity_ServicePU")
  private EntityManager em;

  private VoteQuestionPK getPrimaryKey(PathSegment pathSegment) {
    /*
     * pathSemgent represents a URI path segment and any associated matrix parameters.
     * URI path part is supposed to be in form of 'somePath;idUser=idUserValue;idQuestion=idQuestionValue'.
     * Here 'somePath' is a result of getPath() method invocation and
     * it is ignored in the following code.
     * Matrix parameters are used as field names to build a primary key instance.
     */
    org.me.entities.VoteQuestionPK key = new org.me.entities.VoteQuestionPK();
    javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
    java.util.List<String> idUser = map.get("idUser");
    if (idUser != null && !idUser.isEmpty()) {
      key.setIdUser(new java.lang.Integer(idUser.get(0)));
    }
    java.util.List<String> idQuestion = map.get("idQuestion");
    if (idQuestion != null && !idQuestion.isEmpty()) {
      key.setIdQuestion(new java.lang.Integer(idQuestion.get(0)));
    }
    return key;
  }

  public VoteQuestionFacadeREST() {
    super(VoteQuestion.class);
  }

  @POST
  @Override
  @Consumes({"application/xml", "application/json"})
  public void create(VoteQuestion entity) {
    super.create(entity);
  }

  @PUT
  @Path("{id}")
  @Consumes({"application/xml", "application/json"})
  public void edit(@PathParam("id") PathSegment id, VoteQuestion entity) {
    super.edit(entity);
  }

  @DELETE
  @Path("{id}")
  public void remove(@PathParam("id") PathSegment id) {
    org.me.entities.VoteQuestionPK key = getPrimaryKey(id);
    super.remove(super.find(key));
  }

  @GET
  @Path("{id}")
  @Produces({"application/xml", "application/json"})
  public VoteQuestion find(@PathParam("id") PathSegment id) {
    org.me.entities.VoteQuestionPK key = getPrimaryKey(id);
    return super.find(key);
  }

  @GET
  @Override
  @Produces({"application/xml", "application/json"})
  public List<VoteQuestion> findAll() {
    return super.findAll();
  }

  @GET
  @Path("{from}/{to}")
  @Produces({"application/xml", "application/json"})
  public List<VoteQuestion> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
    return super.findRange(new int[]{from, to});
  }

  @GET
  @Path("count")
  @Produces("text/plain")
  public String countREST() {
    return String.valueOf(super.count());
  }

  @Override
  protected EntityManager getEntityManager() {
    return em;
  }
  
}
