package mock.dao;

import mock.db.DBClient;
import mock.db.Person;
import mock.metrics.Metrics;

import java.util.List;

/**
 * Still uses dependency injection but doesn't use interfaces.
 * Instead, we rely on Mockito framework to create mock objects for us so that
 * we don't have to have all this boilerplate for interfaces.
 *
 * See BestDAOTests for details
 */
public class BestDAO {
    private DBClient db;
    private Metrics metrics;

    public BestDAO(DBClient db, Metrics metrics) {
        this.db = db;
        this.metrics = metrics;
    }

    public String addPerson(Person person) {
        boolean error = false;
        try {
            return db.addPerson(person);
        } catch (Exception e) {
            error = true;
            throw e;
        } finally {
            metrics.addInsertCount(error);
        }
    }

    public String updatePerson(String id, Person person) {
        boolean error = false;
        try {
            return db.updatePerson(id, person);
        } catch (Exception e) {
            error = true;
            throw e;
        } finally {
            metrics.addUpdateCount(error);
        }
    }

    public Person getPerson(String id) {
        boolean error = false;
        try {
            return db.getPerson(id);
        } catch (Exception e) {
            error = true;
            throw e;
        } finally {
            metrics.addGetCount(error);
        }
    }

    public List<Person> getAllPeople() {
        boolean error = false;
        try {
            return db.getAllPeople();
        } catch (Exception e) {
            error = true;
            throw e;
        } finally {
            metrics.addGetCount(error);
        }
    }

    public void deletePerson(String id) {
        boolean error = false;
        try {
            db.removePerson(id);
        } catch (Exception e) {
            error = true;
            throw e;
        } finally {
            metrics.addDeleteCount(error);
        }
    }
}
