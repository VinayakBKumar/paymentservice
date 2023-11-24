package com.dev.paymentservice.services.paymentgateway;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentLink;
import com.stripe.model.Price;
import com.stripe.param.PaymentLinkCreateParams;
import com.stripe.param.PriceCreateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class StripePaymentGateway implements PaymentGateway{
    //String apiKey = "sk_test_51ODW7bSDN6uwoBIVdrs1UlklnQH9Qmu8RpgFUkIBHjVcnBzloAtq5YEJ5pRjpbBuIg5zRmjTPTsNjBP6R0zmAuuR00f0gckqxg";


    @Value("${STRIPE_SECRET_KEY}")
    private String apiKey;

    @Value("${STRIPE_CALLBACK_URL}")
    private String callbackURL;
    @Override
    public String generatePaymentLink(String orderId, String name, String email, long amount) throws StripeException {

        Stripe.apiKey = apiKey;

        PriceCreateParams params =
                PriceCreateParams.builder()
                        .setCurrency("inr")
                        .setUnitAmount(amount)
                        .setProductData(
                                PriceCreateParams.ProductData.builder().setName(orderId).build()
                        )
                        .build();
        Price price = Price.create(params);

        PaymentLinkCreateParams params1 =
                PaymentLinkCreateParams.builder()
                        .addLineItem(
                                PaymentLinkCreateParams.LineItem.builder()
                                        .setPrice(price.getId())
                                        .setQuantity(1L)
                                        .build()
                        ).setAfterCompletion(
                                PaymentLinkCreateParams.AfterCompletion.builder()
                                        .setType(PaymentLinkCreateParams.AfterCompletion.Type.REDIRECT)
                                        .setRedirect(
                                                PaymentLinkCreateParams.AfterCompletion.Redirect.builder()
                                                        .setUrl(callbackURL)
                                                        .build()
                                        )
                                        .build()
                        )
                        .build();

        PaymentLink paymentLink = PaymentLink.create(params1);



        return paymentLink.getUrl();

    }
}
