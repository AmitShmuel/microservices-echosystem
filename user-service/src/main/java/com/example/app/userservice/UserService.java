package com.example.app.userservice;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserService {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(method = RequestMethod.GET, value = "user/go")
    public void goUser() {
        System.out.println("in User Service");
    }

    @HystrixCommand(fallbackMethod = "fallback",
                    groupKey = "userService", commandKey = "userService", threadPoolKey = "userServiceThread")
    @GetMapping("/userService")
    public String method() {
        System.out.println("Going to Payment Service");
        String url = "http://payment-service/payment/message";
        return restTemplate.getForObject(url, String.class);
    }

    public String fallback(Throwable hystrixCommand) {
        return "Fall Back Message";
    }
}
