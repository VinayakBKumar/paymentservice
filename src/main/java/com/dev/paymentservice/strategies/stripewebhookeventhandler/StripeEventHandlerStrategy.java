package com.dev.paymentservice.strategies.stripewebhookeventhandler;

import com.stripe.model.Event;
import org.springframework.stereotype.Service;

@Service
public interface StripeEventHandlerStrategy {
    public void handleStripeEvent(Event event);
}
