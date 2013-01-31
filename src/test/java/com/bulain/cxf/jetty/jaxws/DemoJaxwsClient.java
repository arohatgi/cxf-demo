package com.bulain.cxf.jetty.jaxws;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.bulain.cxf.demo.service._1_0.DemoService;

@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners(value = {DependencyInjectionTestExecutionListener.class})
@ContextConfiguration(locations = {"classpath:spring/applicationContext-wsdlclient.xml"})
public class DemoJaxwsClient {
    @Autowired
    private DemoService demoService;

    @Test
    public void testCxf() {
        // test
        String sayHello = demoService.say("Bulain");

        // assert
        assertEquals("hello Bulain", sayHello);
    }
}
