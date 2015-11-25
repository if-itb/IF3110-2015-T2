/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import entity.Answer;
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
     * Web service operation
     */
    @WebMethod(operationName = "createUser")
    public void createUser(@WebParam(name = "user") Registereduser user) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SimpleStackExchange_WebServicePU");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        try {
            
            em.persist(user);
            
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        
        emf.close();
    }
    
      /**
     * Web service operation
     */
    @WebMethod(operationName = "createQuestion")
    public void createQuestion(@WebParam(name = "token") String token, @WebParam(name = "question") Question question) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SimpleStackExchange_WebServicePU");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        try {
            
            em.persist(question);
            
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        
        emf.close();
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

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getQuestion")
    public Question getQuestion(@WebParam(name = "qid") int qid) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SimpleStackExchange_WebServicePU");
        EntityManager em = emf.createEntityManager();
        return (Question) em.createNamedQuery("Question.findByQid")
                .setParameter("qid", qid)
                .getResultList().get(0);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getAnswers")
    public List<Answer> getAnswers(@WebParam(name = "qid") int qid) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SimpleStackExchange_WebServicePU");
        EntityManager em = emf.createEntityManager();
       
        return (List<Answer>)em.createQuery("SELECT q FROM Answer q WHERE q.qid="+qid, Answer.class).getResultList();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "checkEmailUser")
    public Boolean checkEmailUser(@WebParam(name = "email") String email) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SimpleStackExchange_WebServicePU");
        EntityManager em = emf.createEntityManager();
        if (em.createNamedQuery("Registereduser.findByEmail")
                .setParameter("email", email)
                .getResultList() == null) {
            return true;
        }
        else return false;
    }
}
