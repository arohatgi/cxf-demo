package com.bulain.cxf.jetty.simple;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.apache.cxf.frontend.ClientProxyFactoryBean;
import org.junit.Before;
import org.junit.Test;

import com.bulain.cxf.jarws.Hello;
import com.bulain.cxf.jarws.HelloService;

public class JavaSimpleClient {
    private HelloService helloService;

    @Before
    public void setUp() {
        // create client
        ClientProxyFactoryBean factory = new ClientProxyFactoryBean();
        factory.setServiceClass(HelloService.class);
        factory.setAddress("http://localhost:8083/HelloService");
        helloService = (HelloService) factory.create();
    }

    @Test
    public void testSay() {
        // test
        String sayHello = helloService.say("Bulain");

        // assert
        assertEquals("hello Bulain", sayHello);
    }
    
    @Test
    public void testHandle(){
        //prepare
        String request = "Bulain";
     
        //test
        Hello hello = helloService.handle(request);
        
        //assert
        assertNotNull(hello);
        assertEquals("Bulain", hello.getRequest());
        assertEquals("Hello Bulain", hello.getResponse());
    }
    
    @Test
    public void testHand(){
        //prepare
        Hello param = new Hello();
        param.setRequest("Bulain");
     
        //test
        Hello hello = helloService.hand(param);
        
        //assert
        assertNotNull(hello);
        assertEquals("Bulain", hello.getRequest());
        assertEquals("Hello Bulain", hello.getResponse());
    }

}
