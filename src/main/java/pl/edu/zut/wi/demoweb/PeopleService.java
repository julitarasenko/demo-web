package pl.edu.zut.wi.demoweb;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class PeopleService {
    private List<Person> people;

    @PostConstruct
    public void init() {
        people = new ArrayList<>();
        addPerson(new Person("Julia", "Tarasenko"));
        addPerson(new Person("Alex", "Tilnyi"));
    }

    public Person getPerson(int index) {
        return people.get(index);
    }

    public void addPerson(Person person) {
        person.setIndex(people.size());
        people.add(person);
    }

    public void setPerson(int index, Person p) {
        people.set(index, p);
    }

    public void removePerson(int index) {
        people.remove(index);
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }
}
