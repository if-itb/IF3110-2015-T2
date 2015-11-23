/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wbd.identity.service;

import java.util.List;
import javax.ws.rs.core.Response;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import wbd.identity.Token;

/**
 *
 * @author Afrizal
 */
public class TokenRESTFacadeTest {
  
  public TokenRESTFacadeTest() {
  }
  
  @BeforeClass
  public static void setUpClass() {
  }
  
  @AfterClass
  public static void tearDownClass() {
  }
  
  @Before
  public void setUp() {
  }
  
  @After
  public void tearDown() {
  }

  /**
   * Test of create method, of class TokenRESTFacade.
   */
  @Test
  public void testCreate() {
    System.out.println("create");
    Token entity = null;
    TokenRESTFacade instance = new TokenRESTFacade();
    Response expResult = null;
    Response result = instance.create(entity);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of edit method, of class TokenRESTFacade.
   */
  @Test
  public void testEdit() {
    System.out.println("edit");
    Token entity = null;
    TokenRESTFacade instance = new TokenRESTFacade();
    Response expResult = null;
    Response result = instance.edit(entity);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of remove method, of class TokenRESTFacade.
   */
  @Test
  public void testRemove() {
    System.out.println("remove");
    String id = "";
    TokenRESTFacade instance = new TokenRESTFacade();
    Response expResult = null;
    Response result = instance.remove(id);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of find method, of class TokenRESTFacade.
   */
  @Test
  public void testFind() {
    System.out.println("find");
    String id = "";
    TokenRESTFacade instance = new TokenRESTFacade();
    Token expResult = null;
    Token result = instance.find(id);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of findAll method, of class TokenRESTFacade.
   */
  @Test
  public void testFindAll() {
    System.out.println("findAll");
    TokenRESTFacade instance = new TokenRESTFacade();
    List<Token> expResult = null;
    List<Token> result = instance.findAll();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of findRange method, of class TokenRESTFacade.
   */
  @Test
  public void testFindRange() {
    System.out.println("findRange");
    Integer max = null;
    Integer first = null;
    TokenRESTFacade instance = new TokenRESTFacade();
    List<Token> expResult = null;
    List<Token> result = instance.findRange(max, first);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of count method, of class TokenRESTFacade.
   */
  @Test
  public void testCount() {
    System.out.println("count");
    TokenRESTFacade instance = new TokenRESTFacade();
    String expResult = "";
    String result = instance.count();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }
  
}
