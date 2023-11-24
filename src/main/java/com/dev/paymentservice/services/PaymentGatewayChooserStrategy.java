package com.dev.paymentservice.services;

import com.dev.paymentservice.services.paymentgateway.PaymentGateway;
import com.dev.paymentservice.services.paymentgateway.RazorayPagementGateway;
import com.dev.paymentservice.services.paymentgateway.StripePaymentGateway;
import org.springframework.stereotype.Service;

@Service
public class PaymentGatewayChooserStrategy {
    private RazorayPagementGateway razorayPagementGateway;
    private StripePaymentGateway stripePaymentGateway;

    public PaymentGatewayChooserStrategy(RazorayPagementGateway razorayPagementGateway, StripePaymentGateway stripePaymentGateway){
        this.razorayPagementGateway = razorayPagementGateway;
        this.stripePaymentGateway = stripePaymentGateway;
    }
    public PaymentGateway choosePaymentGateway(){

        if(1 == 2){
            return razorayPagementGateway;
        }
        return stripePaymentGateway;
    }
}
