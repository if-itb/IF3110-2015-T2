/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebService;


import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import java.util.Vector;
//Service Endpoint Interface
@WebService
@SOAPBinding(style = Style.RPC)
public interface StackWS{
 
	@WebMethod String getHelloWorldAsString(String name);
        @WebMethod int tesplus(int a,int b);
        
        @WebMethod int countAnswer(int id);
        @WebMethod String[][] getAllQuestions() ;
        
        @WebMethod String[] getQuestions(int id);
        @WebMethod String[][] getAllAnswers(int id);
        
        @WebMethod int register(String n,String e,String pass);
        @WebMethod String[] getUser(int id);
        
        @WebMethod int addQuestion(String at,String t,String c);
        @WebMethod int updateQuestion(String at,int id,String t,String c);
        
        @WebMethod int deleteQuestion(String at,int id);
        @WebMethod int addAnswer(String at,int idq,int ida,String c);
        
        @WebMethod String[][] searchQuestion(String s);
        @WebMethod int getVote(String t,int id);
        @WebMethod int changeVote(String at,String t,int id,int num);
}