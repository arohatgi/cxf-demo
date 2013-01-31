package com.bulain.cxf.jms.jaxws;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners(value = {DependencyInjectionTestExecutionListener.class})
@ContextConfiguration(locations = {"classpath:spring/applicationContext-jmsserver.xml"})
public class SpringJmsServer {
    @Test
    public void test() {
        try {
            Thread.sleep(1000 * 10);
        } catch (InterruptedException e) {
        }
    }
}
