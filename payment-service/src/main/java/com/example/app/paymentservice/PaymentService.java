package com.example.app.paymentservice;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentService {

    @RequestMapping(method = RequestMethod.GET, value = "payment/message")
    public void messagePayment() {
        System.out.println("in Payment Service");
    }
}
