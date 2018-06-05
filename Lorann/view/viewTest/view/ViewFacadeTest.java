/*
 *
 */
package view;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import viewinterfaces.IView;

/**
 * <h1>The class ViewFacadeTest tests the proper functioning of the methods of
 * ViewFacade.</h1>
 * 
 * @author Aurélien Dellac
 * @version 1 juin 2018
 */
public class ViewFacadeTest {
    private IView view;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        this.view = new ViewFacade();
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test if the message passed to the method is not empty.
     */
    @Test
    public void testDisplayMessage() {
        try {
            this.view.displayMessage("");
            fail("Not yet implemented");
        } catch (final Exception e) {
            // TODO Auto-generated catch block
            final String expected = "Message to display is empty";
            assertEquals(expected, e.getMessage());
        }

    }

}
