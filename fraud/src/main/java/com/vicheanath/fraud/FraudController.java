package com.vicheanath.fraud;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/fraud-checks")
@AllArgsConstructor
@Slf4j
public class FraudController {
    private final FraudCheckService fraudCheckService;

    @GetMapping(path = "{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId") String customerId) {
        boolean isFraud = fraudCheckService.isFraudulentCustomer(customerId);
        log.info("Customer {} is fraud? {}", customerId, isFraud);
        return new FraudCheckResponse(isFraud);

    }
}
