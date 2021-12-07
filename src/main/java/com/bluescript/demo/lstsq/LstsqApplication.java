package com.bluescript.demo.lstsq;

import java.util.function.Function;

 

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
//import org.springframework.messaging.Message;

//import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue.Supplier;
 
import reactor.core.publisher.Flux;

@SpringBootApplication
public class LstsqApplication {

	public static void main(String[] args) {
		SpringApplication.run(LstsqApplication.class, args);
	}
	
}
