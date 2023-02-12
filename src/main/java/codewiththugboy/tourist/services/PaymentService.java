package codewiththugboy.tourist.services;

import codewiththugboy.tourist.dto.Response.PaymentResponse;
import codewiththugboy.tourist.dto.request.PaymentRequest;

public interface PaymentService {
    PaymentResponse initializePayment(PaymentRequest paymentRequest);
}
