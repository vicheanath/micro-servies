package com.vicheanath.customer;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;
    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        // TODO: check if email valid
        // TODO: check if email is not taken
        customerRepository.saveAndFlush(customer);
        // TODO: check if fraudster
        FraudCheckResponse fraudCheckResponse =  restTemplate.getForObject(
                "http://localhost:8082/api/v1/fraud-checks/{customerId}",
                FraudCheckResponse.class,
                customer.getId()
        );

        if (fraudCheckResponse.isFraudster()){
            throw new IllegalStateException("Fraudster");
        }

        // TODO: send notification
    }
}
