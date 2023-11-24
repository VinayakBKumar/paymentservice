package com.dev.paymentservice.strategies.stripewebhookeventhandler;

import com.stripe.model.Event;
import com.stripe.model.EventDataObjectDeserializer;
import com.stripe.model.StripeObject;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class PaymentLinkCreatedEventHandlerStrategy implements StripeEventHandlerStrategy{
    @Override
    public void handleStripeEvent(Event event) {
        // Deserialize the nested object inside the event
        EventDataObjectDeserializer dataObjectDeserializer = event.getDataObjectDeserializer();
        StripeObject stripeObject = null;
        if (dataObjectDeserializer.getObject().isPresent()) {
            stripeObject = dataObjectDeserializer.getObject().get();
        } else {
            // Deserialization failed, probably due to an API version mismatch.
            // Refer to the Javadoc documentation on `EventDataObjectDeserializer` for
            // instructions on how to handle this case, or return an error here.
        }
        System.out.println("event: " + event.getType());
    }
}
