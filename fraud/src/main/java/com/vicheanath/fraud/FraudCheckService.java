package com.vicheanath.fraud;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class FraudCheckService {
    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;

    public boolean isFraudulentCustomer(String customerId) {
        fraudCheckHistoryRepository.save(FraudCheckHistory.builder()
                .customerId(Integer.valueOf(customerId))
                .isFraud(false)
                .createdAt(LocalDate.now())
                .build());
        return false;
    }
}
