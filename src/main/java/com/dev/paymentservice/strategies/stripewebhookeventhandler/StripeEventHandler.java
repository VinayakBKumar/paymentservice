package com.dev.paymentservice.strategies.stripewebhookeventhandler;

import com.stripe.model.Event;
import org.springframework.stereotype.Service;

@Service
public class StripeEventHandler {
    private StripeEventHandlerChooserStrategy stripeEventHandlerChooserStrategy;

    public StripeEventHandler(StripeEventHandlerChooserStrategy stripeEventHandlerChooserStrategy){
        this.stripeEventHandlerChooserStrategy = stripeEventHandlerChooserStrategy;
    }
    public void handleStripeEvent(Event event){
        StripeEventHandlerStrategy stripeEventHandlerStrategy = stripeEventHandlerChooserStrategy.chooseStripeEventHandlerStrategy(event.getType());

        stripeEventHandlerStrategy.handleStripeEvent(event);
    }
}
