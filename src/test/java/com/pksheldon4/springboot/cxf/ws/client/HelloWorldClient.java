package com.pksheldon4.springboot.cxf.ws.client;

import com.pksheldon4.services.helloworld.HelloWorldPortType;
import com.pksheldon4.types.helloworld.Greeting;
import com.pksheldon4.types.helloworld.ObjectFactory;
import com.pksheldon4.types.helloworld.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HelloWorldClient {

    @Autowired
    private HelloWorldPortType helloWorldProxy;

    public String sayHello(String firstName, String lastName) {

        ObjectFactory factory = new ObjectFactory();
        Person person = factory.createPerson();
        person.setFirstName(firstName);
        person.setLastName(lastName);

        Greeting response = helloWorldProxy.sayHello(person);

        return response.getGreeting();
    }
}
