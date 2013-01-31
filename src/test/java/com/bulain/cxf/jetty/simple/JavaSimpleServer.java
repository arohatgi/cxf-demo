package com.bulain.cxf.jetty.simple;

import org.apache.cxf.frontend.ServerFactoryBean;
import org.junit.Test;

import com.bulain.cxf.jarws.HelloService;
import com.bulain.cxf.jarws.HelloServiceImpl;

public class JavaSimpleServer {
    @Test
    public void test() {
        // create service
        HelloServiceImpl helloImpl = new HelloServiceImpl();

        // bind to server
        ServerFactoryBean svrFactory = new ServerFactoryBean();
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
