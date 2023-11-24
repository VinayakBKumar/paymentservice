package com.dev.paymentservice.controllers;

import com.dev.paymentservice.dtos.PaymentRequestDto;
import com.dev.paymentservice.services.PaymentService;
import com.stripe.exception.StripeException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @GetMapping("/test")
    public String testLocalTunnel(){
        return "Hello!!";
    }

    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService){
        this.paymentService = paymentService;
    }

    @PostMapping("/")
    public String initiatePayment(@RequestBody PaymentRequestDto paymentRequestDto) throws Exception {
        return paymentService.initiatePayment(paymentRequestDto.getOrderId(), paymentRequestDto.getName(), paymentRequestDto.getEmail(), paymentRequestDto.getAmount());
    }

}
