package com.dev.paymentservice.services;

import com.dev.paymentservice.dtos.PaymentRequestDto;
import com.dev.paymentservice.services.paymentgateway.PaymentGateway;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentLink;
import com.stripe.model.Price;
import com.stripe.param.PaymentLinkCreateParams;
import com.stripe.param.PriceCreateParams;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    private PaymentGatewayChooserStrategy paymentGatewayChooserStrategy;

    public PaymentService(PaymentGatewayChooserStrategy paymentGatewayChooserStrategy){
        this.paymentGatewayChooserStrategy = paymentGatewayChooserStrategy;
    }
    public String initiatePayment(String orderId, String name, String email, long amount) throws Exception{
        PaymentGateway paymentGateway = paymentGatewayChooserStrategy.choosePaymentGateway();

        return paymentGateway.generatePaymentLink(orderId, name, email, amount);
    }
}
