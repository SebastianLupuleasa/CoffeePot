package com.lupuleasa.coffee.controller;


import com.lupuleasa.coffee.dto.CreatePayment;
import com.lupuleasa.coffee.dto.CreatePaymentResponse;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class PaymentController {


    @PostMapping("/create-payment-intent/{value}")
    public CreatePaymentResponse createPaymentIntent(@RequestBody CreatePayment createPayment, @PathVariable String value) throws StripeException {

            PaymentIntentCreateParams createParams = new PaymentIntentCreateParams.Builder()
                    .setCurrency("usd")
                    .setAmount((long) (Float.parseFloat(value) * 100L)) // createPayment... what product does user want to buy..how much does product cost
                    .build();

            // Create a PaymentIntent with the order amount and currency
            PaymentIntent intent = PaymentIntent.create(createParams);

            return new CreatePaymentResponse(intent.getClientSecret());

        }

   }
