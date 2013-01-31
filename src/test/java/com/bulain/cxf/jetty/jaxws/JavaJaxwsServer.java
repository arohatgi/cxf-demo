package com.bulain.cxf.jetty.jaxws;

import org.apache.cxf.jaxws.JaxWsServerFactoryBean;
import org.junit.Test;

import com.bulain.cxf.jarws.HelloService;
import com.bulain.cxf.jarws.HelloServiceImpl;

public class JavaJaxwsServer {

    @Test
    public void test() {
        // create service
        HelloServiceImpl helloImpl = new HelloServiceImpl();
        
        // bind to server
        JaxWsServerFactoryBean svrFactory = new JaxWsServerFactoryBean();
        svrFactory.setServiceClass(HelloService.class);
        svrFactory.setAddress("http://localhost:8083/HelloService");
        svrFactory.setServiceBean(helloImpl);
        svrFactory.create();
        
        try {
            Thread.sleep(1000 * 10);
        } catch (InterruptedException e) {
        }
    }

}
