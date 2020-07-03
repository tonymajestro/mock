package mock.db;

import java.util.*;

/**
 * Pretend like this class talks to a database over the network
 */
public class DBClient implements IDBClient {
    private Map<String, Person> db;

    public DBClient() {
        db = new HashMap<>();
    }

    public String addPerson(Person person) {
        String id = UUID.randomUUID().toString();
        db.put(id, person);
        return id;
    }

    public String updatePerson(String id, Person person) {
        Person previousPerson = db.put(id, person);
        if (previousPerson == null) {
            throw new IllegalArgumentException("Cannot update person, ID " + id + " not found");
        }

        return previousPerson.id;
    }

    public void removePerson(String id) {
        db.remove(id);
    }

    public List<Person> getAllPeople() {
        return new ArrayList<>(db.values());
    }

    public Person getPerson(String id) {
        Person person = db.getOrDefault(id, null);
        if (person == null) {
            throw new IllegalArgumentException("Person with ID " + id + " not found");
        }

        return person;
    }
}
