/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import entity.Question;
import entity.Registereduser;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author mfikria
 */
@WebService(serviceName = "SimpleStackExchange_WS")
public class SimpleStackExchange_WS {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
      /**
     * Web service operation
     * @return 
     */
    @WebMethod(operationName = "listQuestion")
    public List<Question> listQuestion() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SimpleStackExchange_WebServicePU");
        EntityManager em = emf.createEntityManager();
        
        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Question.class));
        return em.createQuery(cq).getResultList();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getUserById")
    public Registereduser getUserById(@WebParam(name = "uid") int uid) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SimpleStackExchange_WebServicePU");
        EntityManager em = emf.createEntityManager();
        return em.find(Registereduser.class, uid);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "searchQuestion")
    public List<Question> searchQuestion(@WebParam(name = "keyword") String keyword) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SimpleStackExchange_WebServicePU");
        EntityManager em = emf.createEntityManager();
       
        return  em.createQuery("SELECT q FROM Question q WHERE q.topic LIKE '%"+keyword+"%' OR q.content LIKE '%"+keyword+"%'", Question.class).getResultList();
                
    }
}
