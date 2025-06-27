package com.genie.Greet_API.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {

    @Autowired
    private Environment environment;

    private static final Logger logger= LoggerFactory.getLogger(GreetController.class);

   @GetMapping("/greet")
    public String greetMsg()
    {
        logger.info("inside greet msg method...");
      String port=environment.getProperty("server.port");
        return "Good Morning..." +port;
    }
}
