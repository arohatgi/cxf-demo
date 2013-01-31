package com.bulain.cxf.servlet.jaxws;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners(value = {DependencyInjectionTestExecutionListener.class})
@ContextConfiguration(locations = {"classpath:spring/applicationContext-httpsserver.xml"})
public class HttpsServer {
    @Test
    public void test() throws Exception {
        try {
            Thread.sleep(1000 * 100);
        } catch (InterruptedException e) {
        }
    }

}
