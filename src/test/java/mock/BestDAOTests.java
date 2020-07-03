package mock;

import org.junit.Assert;
import mock.best.BestDAO;
import mock.db.DBClient;
import mock.db.Person;
import mock.metrics.Metrics;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * Uses Mockito to create mock implementations for DBClient and Metrics.
 * Uses much less boilerplate to create and setup the mock objects
 *
 * Don't forget the @RunWith(MockitoJUnitRunner.class) annotation on the test class,
 * otherwise the tests won't run correctly
 */
@RunWith(MockitoJUnitRunner.class)
public class BestDAOTests {
    private static final String TEST_ID = "12345";
    private static final Person TEST_PERSON = new Person(TEST_ID, "John", "Smith", 45);

    @Mock DBClient db;
    @Mock Metrics metrics;
    BestDAO dao;

    @Before
    public void setup() {
        dao = new BestDAO(db, metrics);
    }

    @Test
    public void testAdd() {
        // Set up mock DB to return TEST_ID when we call addPerson
        Mockito.when(db.addPerson(TEST_PERSON)).thenReturn(TEST_ID);

        String id = dao.addPerson(TEST_PERSON);
        Assert.assertEquals(TEST_ID, id);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddThrowsException() {
        // Set up mock DB to throw exception when we call addPerson
        Mockito.when(db.addPerson(TEST_PERSON)).thenThrow(IllegalArgumentException.class);

        dao.addPerson(TEST_PERSON);
    }

    @Test
    public void testUpdate() {
        // Set up mock DB to throw exception when we call updatePerson
        Mockito.when(db.updatePerson(TEST_ID, TEST_PERSON)).thenReturn(TEST_ID);

        String id = dao.updatePerson(TEST_ID, TEST_PERSON);
        Assert.assertEquals(TEST_ID, id);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUpdateThrowsException() {
        // Set up mock DB to throw exception when we call updatePerson
        Mockito.when(db.updatePerson(TEST_ID, TEST_PERSON)).thenThrow(IllegalArgumentException.class);

        dao.updatePerson(TEST_ID, TEST_PERSON);
    }
}
