package mock.better;

import mock.db.IDBClient;
import mock.db.Person;
import mock.metrics.IMetrics;

import java.util.List;

/**
 * Better implementation because we use dependency injection with interfaces. We can manually create
 * mock implementations of IDBClient and IMetrics to pass to our BetterDAO in unit tests.
 *
 * See BetterDAOTests for details
 */
public class BetterDAO {
    private IDBClient db;
    private IMetrics metrics;

    public BetterDAO(IDBClient db, IMetrics metrics) {
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
