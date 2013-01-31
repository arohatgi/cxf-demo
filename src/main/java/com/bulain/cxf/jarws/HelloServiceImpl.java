package com.bulain.cxf.jarws;

public class HelloServiceImpl implements HelloService {
    public String say(String hello) {
        return "hello " + hello;
    }

    public Hello handle(String request) {
        Hello hello  = new Hello();
        hello.setRequest(request);
        hello.setResponse("Hello " +  request);
        return hello;
    }

    public Hello hand(Hello hello) {
        hello.setResponse("Hello " +  hello.getRequest());
        return hello;
    }

}
