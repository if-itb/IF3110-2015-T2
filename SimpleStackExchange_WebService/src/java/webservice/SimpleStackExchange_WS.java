/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import entity.Answer;
import entity.Answervoter;
import entity.Question;
import entity.Questionvoter;
import entity.Registereduser;
import java.util.Date;
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

    /**
     * Web service operation
     */
    @WebMethod(operationName = "voteQuestion")
    public Boolean voteQuestion(@WebParam(name = "qid") int qid, @WebParam(name = "uid") int uid, @WebParam(name = "value") String value) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SimpleStackExchange_WebServicePU");
        EntityManager em = emf.createEntityManager();
        
        Questionvoter qvoter = new Questionvoter();
        qvoter.setQid(qid);
        qvoter.setUid(uid);
        qvoter.setValue(value);
        qvoter.setCreatedtime(new Date());
        
        int vote = getVotesQuestion(qid);
        vote += Integer.parseInt(value);
        
        // increment countvotes in Question table
        Question q = em.find(Question.class, qid);
                
        em.getTransaction().begin();
        try {
            q.setCountvotes(vote);
            em.persist(qvoter);
            
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            return false;
        } finally {
            em.close();
        }
        
        emf.close();
        
        return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "voteAnswer")
    public Boolean voteAnswer(@WebParam(name = "aid") int aid, @WebParam(name = "uid") int uid, @WebParam(name = "value") String value) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SimpleStackExchange_WebServicePU");
        EntityManager em = emf.createEntityManager();
        
        Answervoter avoter = new Answervoter();
        avoter.setAid(aid);
        avoter.setUid(uid);
        avoter.setValue(value);
        avoter.setCreatedtime(new Date());
        
        int vote = getVotesAnswer(aid);
        vote += Integer.parseInt(value);
        
        // increment countvotes in Question table
        Answer a = em.find(Answer.class, aid);
                
        em.getTransaction().begin();
        try {
            a.setCountvotes(vote);
            em.persist(avoter);
            
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            return false;
        } finally {
            em.close();
        }
        
        emf.close();
        
        return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteAllVoteAnswer")
    public Boolean deleteAllVoteAnswer(@WebParam(name = "aid") int aid) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SimpleStackExchange_WebServicePU");
        EntityManager em = emf.createEntityManager();
       
        em.getTransaction().begin();
        try {
            int ex = em.createNativeQuery("DELETE FROM answervoter WHERE aid = " + aid)
                    .executeUpdate();

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            return false;
        } finally {
            em.close();
        }
        
        emf.close();
        return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteAllVoteQuestion")
    public Boolean deleteAllVoteQuestion(@WebParam(name = "qid") int qid) {
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("SimpleStackExchange_WebServicePU");
        EntityManager em = emf.createEntityManager();
       
        em.getTransaction().begin();
        try {
            int ex = em.createNativeQuery("DELETE FROM questionvoter WHERE qid = " + qid)
                    .executeUpdate();

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            return false;
        } finally {
            em.close();
        }
        
        emf.close();
        return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getVotesQuestion")
    public Integer getVotesQuestion(@WebParam(name = "qid") int qid) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SimpleStackExchange_WebServicePU");
        EntityManager em = emf.createEntityManager();
       
        return (Integer)em.createQuery("SELECT q.countvotes FROM Question q WHERE q.qid="+qid, Integer.class).getSingleResult();
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "getVotesAnswer")
    public Integer getVotesAnswer(@WebParam(name = "aid") int aid) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SimpleStackExchange_WebServicePU");
        EntityManager em = emf.createEntityManager();
       
        return (Integer)em.createQuery("SELECT a.countvotes FROM Answer a WHERE a.aid="+aid, Integer.class).getSingleResult();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "hasVotedAnswer")
    public Boolean hasVotedAnswer(@WebParam(name = "aid") int aid, @WebParam(name = "uid") int uid) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SimpleStackExchange_WebServicePU");
        EntityManager em = emf.createEntityManager();
       
        em.getTransaction().begin();
        int count = 0;
        try {
            count = ((Number)em.createQuery("SELECT COUNT(av) FROM Answervoter av WHERE av.aid=:aid")
                    .setParameter("aid", aid)
                    .getSingleResult()).intValue();

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        
        emf.close();
        
        return count > 0;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "hasVotedQuestion")
    public Boolean hasVotedQuestion (@WebParam(name = "qid") int qid, @WebParam(name = "uid") int uid) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SimpleStackExchange_WebServicePU");
        EntityManager em = emf.createEntityManager();
       
        em.getTransaction().begin();
        int count = 0;
        try {
            count = ((Number)em.createQuery("SELECT COUNT(qv) FROM Questionvoter qv WHERE qv.qid=:qid")
                    .setParameter("qid", qid)
                    .getSingleResult()).intValue();

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        
        emf.close();
        
        return count > 0;
    }
}
