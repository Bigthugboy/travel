package codewiththugboy.tourist.services;


import codewiththugboy.tourist.data.model.Payment;
import codewiththugboy.tourist.data.repository.PaymentRepository;
import codewiththugboy.tourist.dto.Response.PaymentResponse;
import codewiththugboy.tourist.dto.request.PaymentRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;


import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class PaymentServiceImpl implements PaymentService{


    @Override
    public PaymentResponse initializePayment(PaymentRequest paymentRequest) {


        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        String key = "sk_test_3960fa3e701719ff47c647609752e21e8cb52236" ;
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer "+key);
        HttpEntity<PaymentRequest> request = new HttpEntity<>(paymentRequest, headers);
        ResponseEntity<PaymentResponse> response = restTemplate.postForEntity("https://api.paystack.co/transaction/initialize", request, PaymentResponse.class);


        return response.getBody();

    }



    }
