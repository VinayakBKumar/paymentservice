package com.dev.paymentservice.controllers;

import com.stripe.model.Event;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dev.paymentservice.strategies.stripewebhookeventhandler.StripeEventHandler;

@RestController
@RequestMapping("/stripe")
public class StripeWebhookController {

    private StripeEventHandler stripeEventHandler;

    public StripeWebhookController(StripeEventHandler stripeEventHandler){
        this.stripeEventHandler = stripeEventHandler;
    }

    @PostMapping("/webhook")
    public void handleStripeEvent(@RequestBody Event event){
        stripeEventHandler.handleStripeEvent(event);
    }
}
