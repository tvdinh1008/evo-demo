package com.evo.iam.config;

import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.KeyUse;
import com.nimbusds.jose.jwk.RSAKey;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.rsa.crypto.KeyStoreKeyFactory;
import org.springframework.stereotype.Component;

import java.security.KeyPair;
import java.security.interfaces.RSAPublicKey;
import java.util.UUID;

@Component
@EnableConfigurationProperties(AuthenticationProperties.class)
@Slf4j
public class TokenProvider {
    private final AuthenticationProperties properties;
    private KeyPair keyPair;

    public TokenProvider(AuthenticationProperties properties) {
        this.properties = properties;
    }

    @PostConstruct
    private void initKeyPair() {
        keyPair = keyPair(this.properties.getKeyStore(), this.properties.getKeyStorePassword(), this.properties.getKeyAlias());
    }

    private KeyPair keyPair(String keyStore, String password, String alias) {
        KeyStoreKeyFactory keyStoreKeyFactory =
                new KeyStoreKeyFactory(
                        new ClassPathResource(keyStore),
                        password.toCharArray());
        return keyStoreKeyFactory.getKeyPair(alias);
    }

    public JWKSet jwkSet() {
        RSAKey.Builder builder = new RSAKey.Builder((RSAPublicKey) this.keyPair.getPublic()).keyUse(KeyUse.SIGNATURE)
                .algorithm(JWSAlgorithm.RS256)
                .keyID(UUID.randomUUID().toString());
        return new JWKSet(builder.build());
    }

}