package com.vicheanath.customer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {
    public final CustomerService customerService;

    @PostMapping
    public void create(@RequestBody CustomerRegistrationRequest request) {
        log.info("Request to create customer {}", request);
        customerService.registerCustomer(request);
    }

}
