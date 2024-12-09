package com.evo.iam.config;

import lombok.Data;

import java.time.Duration;

@Data
public class AuthenticationProperties {

    private String keyStore;

    private String keyStorePassword;

    private String keyAlias;

    private Duration accessTokenExpiresIn = Duration.ofHours(1);

    private Duration refreshTokenExpiresIn = Duration.ofDays(30);
}
