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
    public Boolean createQuestion(@WebParam(name = "token") String token, @WebParam(name = "question") Question question) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SimpleStackExchange_WebServicePU");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        try {
            
            em.persist(question);
            
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
        
        
        // increment countvotes in Question table
        Question q = em.find(Question.class, qid);
                
        em.getTransaction().begin();
        try {
            Questionvoter qvoter;
            if(hasVotedQuestion(qid, uid)) {
                qvoter = (Questionvoter)em.createQuery("SELECT q FROM Questionvoter q WHERE q.qid=:qid AND q.uid=:uid", Questionvoter.class)
                        .setParameter("qid", qid).setParameter("uid", uid)
                        .getSingleResult();
                qvoter.setValue(value);
            }
            else {
                qvoter = new Questionvoter();
                qvoter.setQid(qid);
                qvoter.setUid(uid);
                qvoter.setValue(value);
                qvoter.setCreatedtime(new Date());
                em.persist(qvoter);
            }
            
            em.getTransaction().commit();
            
            em.getTransaction().begin();
            int vote = getVotesQuestion(qid);
            q.setCountvotes(vote);
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
        
        
        // increment countvotes in Question table
        Answer a = em.find(Answer.class, aid);
                
        em.getTransaction().begin();
        try {
            Answervoter avoter;
            if(hasVotedAnswer(aid, uid)) {
                avoter = (Answervoter)em.createQuery("SELECT a FROM Answervoter a WHERE a.aid=:aid AND a.uid=:uid", Answervoter.class)
                        .setParameter("aid", aid).setParameter("uid", uid)
                        .getSingleResult();
                avoter.setValue(value);
            }
            else {
                avoter = new Answervoter();
                avoter.setAid(aid);
                avoter.setUid(uid);
                avoter.setValue(value);
                avoter.setCreatedtime(new Date());
                em.persist(avoter);
            }
            
            em.getTransaction().commit();
            
            em.getTransaction().begin();
            int vote = getVotesAnswer(aid);
            a.setCountvotes(vote);
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
        List< String > res = (List<String>)em.createQuery("SELECT q.value FROM Questionvoter q WHERE q.qid="+qid, String.class).getResultList();
        Integer sum = 0;
        for(String it : res) {
            sum += Integer.parseInt(it);
        }
        return sum;
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "getVotesAnswer")
    public Integer getVotesAnswer(@WebParam(name = "aid") int aid) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SimpleStackExchange_WebServicePU");
        EntityManager em = emf.createEntityManager();
        List< String > res = (List<String>)em.createQuery("SELECT a.value FROM Answervoter a WHERE a.aid="+aid, String.class).getResultList();
        Integer sum = 0;
        for(String it : res) {
            sum += Integer.parseInt(it);
        }
        return sum;
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
            count = ((Number)em.createQuery("SELECT COUNT(av) FROM Answervoter av WHERE av.aid=:aid AND av.uid=:uid")
                    .setParameter("aid", aid).setParameter("uid", uid)
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
            count = ((Number)em.createQuery("SELECT COUNT(qv) FROM Questionvoter qv WHERE qv.qid=:qid AND qv.uid=:uid")
                    .setParameter("qid", qid).setParameter("uid", uid)
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
    @WebMethod(operationName = "createAnswer")
    public Boolean createAnswer(@WebParam(name = "token") String token, @WebParam(name = "answer") Answer answer) { 
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SimpleStackExchange_WebServicePU");
        EntityManager em = emf.createEntityManager();
        Question q = em.find(Question.class, answer.getQid());
        
        em.getTransaction().begin();
        try {
            q.setCountanswers(1+getCountAnswer(answer.getQid()));
            em.persist(answer);
            
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
    @WebMethod(operationName = "getCountAnswer")
    public Integer getCountAnswer(@WebParam(name = "qid") int qid) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SimpleStackExchange_WebServicePU");
        EntityManager em = emf.createEntityManager();
        return (Integer)em.createQuery("SELECT a FROM Answer a WHERE a.qid=:qid", Integer.class)
                .setParameter("qid", qid).getResultList().size();
    }
}
