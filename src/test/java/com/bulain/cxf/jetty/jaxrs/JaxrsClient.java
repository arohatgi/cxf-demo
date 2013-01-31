package com.bulain.cxf.jetty.jaxrs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Collection;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.DeleteMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.PutMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.cxf.helpers.IOUtils;
import org.apache.cxf.jaxrs.client.WebClient;
import org.junit.Test;

import com.bulain.cxf.jaxrs.Person;

public class JaxrsClient {

    @Test
    public void testList() throws IOException {
        URL url = new URL("http://localhost:8083/jaxrs/persons");
        InputStream in = url.openStream();
        System.out.println(IOUtils.toString(in));
    }

    @Test
    public void testGet() throws IOException {
        URL url = new URL("http://localhost:8083/jaxrs/persons/10");
        InputStream in = url.openStream();
        System.out.println(IOUtils.toString(in));
    }

    @Test
    public void testCreate() throws HttpException, IOException {
        PostMethod post = new PostMethod("http://localhost:8083/jaxrs/persons");
        String content = "<person><firstName>firstName</firstName><lastName>lastName</lastName></person>";
        String contentType = "text/xml";
        String charset = "UTF-8";
        RequestEntity entity = new StringRequestEntity(content, contentType, charset);
        post.setRequestEntity(entity);
        HttpClient httpclient = new HttpClient();

        try {
            int code = httpclient.executeMethod(post);
            assertEquals(204, code);
        } finally {
            post.releaseConnection();
        }
    }

    @Test
    public void testUpdate() throws HttpException, IOException {
        PutMethod put = new PutMethod("http://localhost:8083/jaxrs/persons/10");
        String content = "<person><firstName>firstName</firstName><id>10</id><lastName>lastName</lastName></person>";
        String contentType = "text/xml";
        String charset = "UTF-8";
        RequestEntity entity = new StringRequestEntity(content, contentType, charset);
        put.setRequestEntity(entity);
        HttpClient httpclient = new HttpClient();

        try {
            int code = httpclient.executeMethod(put);
            assertEquals(204, code);
        } finally {
            put.releaseConnection();
        }
    }

    @Test
    public void testDelete() throws HttpException, IOException {
        DeleteMethod delete = new DeleteMethod("http://localhost:8083/jaxrs/persons/11");
        HttpClient httpclient = new HttpClient();

        try {
            int code = httpclient.executeMethod(delete);
            assertEquals(204, code);
        } finally {
            delete.releaseConnection();
        }
    }
    
    //WebClient
    @Test
    public void testListX() {
        WebClient client = WebClient.create("http://localhost:8083/jaxrs");
        client.accept(MediaType.APPLICATION_JSON);
        client.type(MediaType.APPLICATION_JSON_TYPE);
        client.path("persons"); 
        Collection<? extends Person> persons = client.getCollection(Person.class);
        System.out.println(persons);
    }

    @Test
    public void testGetX() {
        WebClient client = WebClient.create("http://localhost:8083/jaxrs");
        client.accept(MediaType.APPLICATION_JSON);
        client.type(MediaType.APPLICATION_JSON_TYPE);
        client.path("persons/10"); 
        Person person = client.get(Person.class);
        assertNotNull(person);
    }
    
    @Test
    public void testCreateX(){
        WebClient client = WebClient.create("http://localhost:8083/jaxrs");
        client.accept(MediaType.APPLICATION_JSON);
        client.type(MediaType.APPLICATION_JSON_TYPE);
        client.path("persons"); 
        
        Person person = new Person();
        person.setFirstName("firstName");
        person.setLastName("lastName");
        Response response = client.post(person);
        assertEquals(204, response.getStatus());
    }

    @Test
    public void testUpdateX(){
        WebClient client = WebClient.create("http://localhost:8083/jaxrs");
        client.accept(MediaType.APPLICATION_JSON);
        client.type(MediaType.APPLICATION_JSON_TYPE);
        client.path("persons/10"); 
        
        Person person = new Person();
        person.setId(Long.valueOf(10));
        person.setFirstName("firstName10-updated");
        person.setLastName("lastName10-updated");
        Response response = client.put(person);
        assertEquals(204, response.getStatus());
    }

    @Test
    public void testDeleteX() {
        WebClient client = WebClient.create("http://localhost:8083/jaxrs");
        client.accept(MediaType.APPLICATION_JSON);
        client.type(MediaType.APPLICATION_JSON_TYPE);
        client.path("persons/11"); 
        
        Response response = client.delete();
        assertEquals(204, response.getStatus());
        
    }
    
}
