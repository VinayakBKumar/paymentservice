package com.dev.paymentservice.services.paymentgateway;

import com.stripe.exception.StripeException;

public interface PaymentGateway {

    String generatePaymentLink(String orderId, String name, String email, long amount) throws Exception;

}
