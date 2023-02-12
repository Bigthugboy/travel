package codewiththugboy.tourist.controller;

import codewiththugboy.tourist.dto.Response.PaymentResponse;
import codewiththugboy.tourist.dto.request.PaymentRequest;
import codewiththugboy.tourist.services.PaymentServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/tourist/payment")
public class PaymentController {
    private PaymentServiceImpl paymentService;

    @PostMapping()
    public PaymentResponse response(@RequestBody PaymentRequest request){
        return paymentService.initializePayment(request);

    }
}
