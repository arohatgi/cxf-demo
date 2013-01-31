package com.bulain.cxf.jarws;

import javax.xml.bind.annotation.XmlType;

@XmlType(name="hello", namespace="http://cxf.bulain.com/hello/1.0")
public class Hello {
    private String request;
    private String response;
    
    public String getRequest() {
        return request;
    }
    public void setRequest(String request) {
        this.request = request;
    }
    public String getResponse() {
        return response;
    }
    public void setResponse(String response) {
        this.response = response;
    }
}
