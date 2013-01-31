package com.bulain.cxf.local.jaxws;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bulain.cxf.jarws.Hello;
import com.bulain.cxf.jarws.HelloService;
import com.bulain.cxf.jarws.HelloServiceImpl;

public class JavaLocalTest {
    private HelloService helloService;

    @BeforeClass
    public static void setUpClass() {
        // create service
        HelloServiceImpl helloImpl = new HelloServiceImpl();

        // bind to server
        JaxWsServerFactoryBean svrFactory = new JaxWsServerFactoryBean();
        svrFactory.setServiceClass(HelloService.class);
        svrFactory.setAddress("local://HelloService");
        svrFactory.setServiceBean(helloImpl);
        svrFactory.create();
    }

    @Before
    public void setUp() {
        // create client
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(HelloService.class);
        factory.setAddress("local://HelloService");
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
    public void testHandle() {
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
    public void testHand() {
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
