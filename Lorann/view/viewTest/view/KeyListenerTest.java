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

public class KeyListenerTest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Tests if the KeyEventPerformer passed to the constructor is not null.
     */
    @Test
    public void testKeyListener() {
        try {
            new KeyListener(null);
            fail("Not yet implemented");
        } catch (final Exception e) {
            // TODO Auto-generated catch block
            final String expected = "The KeyEventPerformer is null";
            assertEquals(expected, e.getMessage());
        }
    }
}
