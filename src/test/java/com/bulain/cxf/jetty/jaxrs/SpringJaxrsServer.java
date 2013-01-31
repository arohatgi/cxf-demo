package com.bulain.cxf.jetty.jaxrs;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners(value = {DependencyInjectionTestExecutionListener.class})
@ContextConfiguration(locations = {"classpath:spring/applicationContext-jaxrsserver.xml"})
public class SpringJaxrsServer {
    @Test
    public void test() {
        try {
            Thread.sleep(1000 * 1000);
        } catch (InterruptedException e) {
        }
    }
}
