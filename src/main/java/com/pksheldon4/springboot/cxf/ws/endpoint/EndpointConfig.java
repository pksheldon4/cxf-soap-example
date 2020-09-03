package com.pksheldon4.springboot.cxf.ws.endpoint;


import org.apache.cxf.Bus;
import org.apache.cxf.ext.logging.LoggingFeature;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;
import java.util.ArrayList;
import java.util.Arrays;

@Configuration
public class EndpointConfig {

    private Bus cxfBus;

    public EndpointConfig(Bus bus) {
        this.cxfBus = bus;
    }

    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus(), new HelloWorldImpl());
        endpoint.publish("/helloworld");
        return endpoint;
    }

    @Bean
    public Bus bus() {
        cxfBus.setFeatures(
            new ArrayList<>(Arrays.asList(loggingFeature())));

        return cxfBus;
    }

    @Bean
    public LoggingFeature loggingFeature() {
        LoggingFeature loggingFeature = new LoggingFeature();
        loggingFeature.setPrettyLogging(true);

        return loggingFeature;
    }
}