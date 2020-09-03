package com.pksheldon4.springboot.cxf.ws.endpoint;


import com.pksheldon4.services.helloworld.HelloWorldPortType;
import com.pksheldon4.types.helloworld.Greeting;
import com.pksheldon4.types.helloworld.ObjectFactory;
import com.pksheldon4.types.helloworld.Person;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HelloWorldImpl implements HelloWorldPortType {

    @Override
    public Greeting sayHello(Person request) {
        log.warn("############################### sayHello");
        String greeting = "Hello " + request.getFirstName() + " "
            + request.getLastName() + "!";

        ObjectFactory factory = new ObjectFactory();
        Greeting response = factory.createGreeting();
        response.setGreeting(greeting);

        return response;
    }
}