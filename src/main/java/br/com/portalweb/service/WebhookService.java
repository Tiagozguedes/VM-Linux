package br.com.portalweb.service;

import br.com.portalweb.dto.EntregaDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WebhookService {

    @Value("${app.webhook.url}")
    private String webhookUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    public ResponseEntity<String> enviar(EntregaDTO entrega) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<EntregaDTO> request = new HttpEntity<>(entrega, headers);
        return restTemplate.postForEntity(webhookUrl, request, String.class);
    }
}
