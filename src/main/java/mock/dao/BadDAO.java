package mock.dao;

import mock.db.DBClient;
import mock.db.Person;
import mock.metrics.Metrics;

import java.util.List;

/**
 * Hard to unit test because we call new in the constructor.
 * This means we can't provide mock implementations for DBClient and Metrics
 */
public class BadDAO {
    private DBClient db;
    private Metrics metrics;

    public BadDAO() {
        this.db = new DBClient();
        this.metrics = new Metrics();
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
