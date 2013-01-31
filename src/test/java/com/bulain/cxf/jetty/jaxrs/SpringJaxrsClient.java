package com.bulain.cxf.jetty.jaxrs;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.bulain.cxf.jaxrs.Person;
import com.bulain.cxf.jaxrs.PersonService;

@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners(value = {DependencyInjectionTestExecutionListener.class})
@ContextConfiguration(locations = {"classpath:spring/applicationContext-jaxrsclient.xml"})
public class SpringJaxrsClient {
    @Autowired
    private PersonService personService;

    @Test
    public void testList() {
        List<Person> list = personService.list();
        assertTrue(list.size() > 0);
    }

    @Test
    public void testGet() {
        Person person = personService.get(10L);
        assertNotNull(person);
    }

    @Test
    public void testCreate() {
        Person person = new Person();
        person.setFirstName("firstName");
        person.setLastName("lastName");
        personService.create(person);
    }

    @Test
    public void testUpdate() {
        Person person = new Person();
        person.setId(10L);
        person.setFirstName("firstName-updated");
        person.setLastName("lastName-updated");
        personService.update(10L, person);
    }

    @Test
    public void testDelete() {
        personService.delete(11L);
    }
}
