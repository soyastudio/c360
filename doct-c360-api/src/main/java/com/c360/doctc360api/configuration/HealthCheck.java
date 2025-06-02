package com.c360.doctc360api.configuration;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;

public class HealthCheck implements HealthIndicator {
    @Override
    public Health health() {
        // Perform the health check
        int errorCode = check();
        if (errorCode != 0) {
            return Health.down().withDetail("Error Code", errorCode).build();
        }
        return Health.up().build();
    }

    public int check() {
        // Perform some specific health check
        return 0;
    }
}
