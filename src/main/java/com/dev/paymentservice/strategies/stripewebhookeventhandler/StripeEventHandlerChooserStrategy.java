package com.dev.paymentservice.strategies.stripewebhookeventhandler;

import org.springframework.stereotype.Service;

@Service
public class StripeEventHandlerChooserStrategy {
    private PaymentLinkCreatedEventHandlerStrategy paymentLinkCreatedEventHandlerStrategy;
    private PaymentSuceededEventHandlerStrategy paymentSuceededEventHandlerStrategy;

    public StripeEventHandlerChooserStrategy(PaymentLinkCreatedEventHandlerStrategy paymentLinkCreatedEventHandlerStrategy,
                                             PaymentSuceededEventHandlerStrategy paymentSuceededEventHandlerStrategy
                                             ){
        this.paymentLinkCreatedEventHandlerStrategy = paymentLinkCreatedEventHandlerStrategy;
        this.paymentSuceededEventHandlerStrategy = paymentSuceededEventHandlerStrategy;
    }
    public StripeEventHandlerStrategy chooseStripeEventHandlerStrategy(String eventType){
        StripeEventHandlerStrategy stripeEventHandlerStrategy = null;
        switch (eventType) {
            case "payment_link.created": {
                // Then define and call a function to handle the event payment_link.created
                stripeEventHandlerStrategy = paymentLinkCreatedEventHandlerStrategy;
                break;
            }
            case "payment_intent.canceled": {
                // Then define and call a function to handle the event payment_intent.canceled
                break;
            }
            case "payment_intent.payment_failed": {
                // Then define and call a function to handle the event payment_intent.payment_failed
                break;
            }
            case "payment_intent.processing": {
                // Then define and call a function to handle the event payment_intent.processing
                break;
            }
            case "payment_intent.succeeded": {
                // Then define and call a function to handle the event payment_intent.succeeded
                stripeEventHandlerStrategy = paymentSuceededEventHandlerStrategy;
                break;
            }
            // ... handle other event types
            default:
                System.out.println("Unhandled event type: " + eventType);
        }

        return stripeEventHandlerStrategy;
    }
}
