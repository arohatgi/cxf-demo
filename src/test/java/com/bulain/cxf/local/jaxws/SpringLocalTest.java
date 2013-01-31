package com.bulain.cxf.local.jaxws;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.bulain.cxf.jarws.Hello;
import com.bulain.cxf.jarws.HelloService;

@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners(value = {DependencyInjectionTestExecutionListener.class})
@ContextConfiguration(locations = {"classpath:spring/applicationContext-local.xml"})
public class SpringLocalTest {
    @Autowired
    private HelloService helloService;

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
