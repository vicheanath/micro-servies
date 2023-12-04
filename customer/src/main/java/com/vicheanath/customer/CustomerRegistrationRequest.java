package com.vicheanath.customer;

public record CustomerRegistrationRequest(
        String name,
        String firstName,
        String lastName,
        String email
) {
}
