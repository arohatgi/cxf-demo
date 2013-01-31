package com.bulain.cxf.servlet.jaxws;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.server.nio.SelectChannelConnector;
import org.eclipse.jetty.webapp.WebAppContext;

public class JettyServer {
    public static void main(String[] args) throws Exception {
        org.eclipse.jetty.server.Server server = new org.eclipse.jetty.server.Server();

        SelectChannelConnector connector = new SelectChannelConnector();
        connector.setPort(8082);
        server.setConnectors(new Connector[]{connector});

        WebAppContext webappcontext = new WebAppContext();
        webappcontext.setContextPath("/cxf-demo");
        webappcontext.setWar("target/cxf-demo");

        HandlerCollection handlers = new HandlerCollection();
        handlers.setHandlers(new Handler[]{webappcontext, new DefaultHandler()});

        server.setHandler(handlers);
        server.start();
        server.join();
    }
}
