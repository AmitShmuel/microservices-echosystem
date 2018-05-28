package com.example.app.userservice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserService {

    @RequestMapping(method = RequestMethod.GET, value = "user/go")
    public void goUser() {
        System.out.println("in User Service");
    }
}
