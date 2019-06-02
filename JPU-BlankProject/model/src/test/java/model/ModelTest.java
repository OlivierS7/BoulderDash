package model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Olivier
 *
 */
public class ModelTest {
    private Model model;
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        this.model = new Model();
        this.model.getMap().setWin(false);
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test of the GetIsWin method
     */
    @Test
    public void testGetIsWin() {
        boolean expected = false;
        assertEquals(expected, this.model.getIsWin());
    }

}