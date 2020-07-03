package mock.db;

import java.util.List;

public interface IDBClient {
    String addPerson(Person person);
    String updatePerson(String id, Person person);
    void removePerson(String id);
    List<Person> getAllPeople();
    public Person getPerson(String id);
}
