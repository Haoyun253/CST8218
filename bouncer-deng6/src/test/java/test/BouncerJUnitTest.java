/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import cst8218.haoyun.bouncer.BouncerController;
import cst8218.haoyun.bouncer.entity.Bouncer;
import javax.faces.component.UIColumn;
import javax.faces.context.FacesContextWrapper;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dell
 */
public class BouncerJUnitTest {

    public BouncerJUnitTest() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    
    @Test
    public void testObject() {
        assertNotNull(new Bouncer(1L)); 
    }

    @Test
    public void testConverterString() {
        BouncerController.BouncerControllerConverter converter = new BouncerController.BouncerControllerConverter();
        Bouncer BObject = new Bouncer(1L);
        String BString;
        BString = converter.getAsString(
                new FacesContextWrapper() {
        },
                new UIColumn(),
                BObject);

        assertEquals(BString, "1");
    }

}
