package com.bulain.cxf.jetty.jaxws;

import com.bulain.cxf.demo._1.Demo;
import com.bulain.cxf.demo.service._1_0.DemoService;

public class DemoServiceImpl implements DemoService {
    public String say(String hello) {
        return "hello " + hello;
    }

    public Demo handle(String request) {
        Demo hello  = new Demo();
        hello.setRequest(request);
        hello.setResponse("Hello " +  request);
        return hello;
    }

    public Demo hand(Demo hello) {
        hello.setResponse("Hello " +  hello.getRequest());
        return hello;
    }

}
