package com.pksheldon4.springboot.cxf.ws;

import static org.assertj.core.api.Assertions.assertThat;


import com.pksheldon4.springboot.cxf.ws.client.HelloWorldClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class CxfSoapWSExampleApplicationTests {

	@Autowired
	private HelloWorldClient helloWorldClient;

	@Test
	public void testSayHello() {
		assertThat(helloWorldClient.sayHello("John", "Doe"))
				.isEqualTo("Hello John Doe!");
	}

}
