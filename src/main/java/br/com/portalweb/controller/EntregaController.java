package br.com.portalweb.controller;

import br.com.portalweb.dto.EntregaDTO;
import br.com.portalweb.service.WebhookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/entregas")
public class EntregaController {

    @Autowired
    private WebhookService webhookService;

    @PostMapping
    public ResponseEntity<String> entregar(@Valid @RequestBody EntregaDTO entrega) {
        ResponseEntity<String> resposta = webhookService.enviar(entrega);
        return ResponseEntity.status(resposta.getStatusCode()).body(resposta.getBody());
    }
}
