package com.bulain.cxf.jaxrs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PersonServiceImpl implements PersonService {
    private List<Person> persons = new ArrayList<Person>();
    private long index = 100L;

    public PersonServiceImpl() {
        init();
    }

    public List<Person> list() {
        return persons;
    }

    public Person get(Long id) {
        Person temp = null;
        for (Person p : persons) {
            if (p.getId().equals(id)) {
                temp = p;
                break;
            }
        }
        return temp;
    }

    public void create(Person person) {
        index++;
        person.setId(index);
        persons.add(person);
    }

    public void update(Long id, Person person) {
        for (Person p : persons) {
            if (p.getId().equals(id)) {
                p.setFirstName(person.getFirstName());
                p.setLastName(person.getLastName());
            }
        }
    }

    public void delete(Long id) {
        Iterator<Person> iterator = persons.iterator();
        while (iterator.hasNext()) {
            Person p = iterator.next();
            if (p.getId().equals(id)) {
                iterator.remove();
            }
        }
    }

    void init() {
        Person p = new Person();
        p.setId(10L);
        p.setFirstName("firstName10");
        p.setLastName("lastName10");
        persons.add(p);

        p = new Person();
        p.setId(11L);
        p.setFirstName("firstName11");
        p.setLastName("lastName11");
        persons.add(p);
    }
}
