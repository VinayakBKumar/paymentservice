package com.dev.paymentservice.services.paymentgateway;

import com.stripe.exception.StripeException;
import org.springframework.stereotype.Service;

@Service
public class RazorayPagementGateway implements PaymentGateway{


    @Override
    public String generatePaymentLink(String orderId, String name, String email, long amount) throws Exception {
        return null;
    }
}
