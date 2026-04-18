package org.karinabp;

import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.eclipse.microprofile.health.HealthCheck;

@Readiness
public class ReadinessCheck implements HealthCheck {

    @RestClient
    LacriService lacriService;

    @Override
    public HealthCheckResponse call() {

        if (lacriService.getLacrimaniacos().equals(LacriService.MSG_ERROR)) {
            return HealthCheckResponse.down("RERROR");
        } else {
            return HealthCheckResponse.up("OK");
        }
    }

}

