package mock;

import mock.db.IDBClient;
import mock.db.Person;

import java.util.Arrays;
import java.util.List;

public class MockDBClient implements IDBClient {
    String currentId;
    Person currentPerson;
    RuntimeException exception;

    public MockDBClient(String id, Person person) {
        this.currentId = id;
        this.currentPerson = person;
        this.exception = null;
    }

    public MockDBClient(String id, Person person, RuntimeException exception) {
        this.currentId = id;
        this.currentPerson = person;
        this.exception = exception;
    }

    @Override
    public String addPerson(Person person) {
        if (exception != null) {
            throw exception;
        }
        return currentId;
    }

    @Override
    public String updatePerson(String id, Person person) {
        if (exception != null) {
            throw exception;
        }
        return currentId;
    }

    @Override
    public void removePerson(String id) {
        if (exception != null) {
            throw exception;
        }
    }

    @Override
    public List<Person> getAllPeople() {
        if (exception != null) {
            throw exception;
        }
        return Arrays.asList(currentPerson);
    }

    @Override
    public Person getPerson(String id) {
        if (exception != null) {
            throw exception;
        }
        return currentPerson;
    }
}
