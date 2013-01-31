package com.bulain.cxf.jarws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(name="HelloService", serviceName="HelloService", targetNamespace="http://cxf.bulain.com/hello/service/1.0")
public interface HelloService {
    @WebMethod(action="say")
    String say(@WebParam(name = "hello") String hello);

    @WebMethod(action="handle")
    @WebResult(name = "response")
    Hello handle(@WebParam(name = "request") String request);
    
    @WebMethod(action="hand")
    @WebResult(name = "response")
    Hello hand(@WebParam(name = "request") Hello hello);
}
