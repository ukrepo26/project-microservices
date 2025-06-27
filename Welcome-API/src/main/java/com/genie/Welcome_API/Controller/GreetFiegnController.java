package com.genie.Welcome_API.Controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "GREET-API")
public interface GreetFiegnController  {

    @GetMapping("/greet")
    public String invokeGreetApi();
}
