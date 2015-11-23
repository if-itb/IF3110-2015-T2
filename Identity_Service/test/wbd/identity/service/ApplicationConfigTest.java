/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wbd.identity.service;

import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Afrizal
 */
public class ApplicationConfigTest {
  
  public ApplicationConfigTest() {
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
   * Test of getClasses method, of class ApplicationConfig.
   */
  @Test
  public void testGetClasses() {
    System.out.println("getClasses");
    ApplicationConfig instance = new ApplicationConfig();
    Set<Class<?>> expResult = null;
    Set<Class<?>> result = instance.getClasses();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }
  
}
