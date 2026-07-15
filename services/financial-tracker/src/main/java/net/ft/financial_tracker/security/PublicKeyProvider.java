package net.ft.financial_tracker.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import jakarta.annotation.PostConstruct;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

@Component
public class PublicKeyProvider {

    @Value("${security.ms.public-key-url}")
    private String publicKeyUrl;

    private final RestTemplate restTemplate = new RestTemplate();
    private volatile PublicKey cachedKey;

    @PostConstruct
    public void init() {
        try {
            refresh();
        } catch (Exception e) {
            System.err.println("Couldn't charge public key: " + e.getMessage());
        }
    }

    public PublicKey getPublicKey() {
        if (cachedKey == null) {
            refresh();
        }
        return cachedKey;
    }

    public synchronized void refresh() {
        String base64Key = restTemplate.getForObject(publicKeyUrl, String.class);
        try {
            byte[] keyBytes = Base64.getDecoder().decode(base64Key);
            X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
            KeyFactory kf = KeyFactory.getInstance("RSA");
            this.cachedKey = kf.generatePublic(spec);
        } catch (Exception e) {
            throw new IllegalStateException("Couldn´t parse public key: ", e);
        }
    }
}