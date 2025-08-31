package com.example.creditWiseapi.controller;


import com.example.creditWiseapi.model.UpdateCreditLimit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.creditWiseapi.entity.Client;
import com.example.creditWiseapi.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client create(@RequestBody Client client) {
        return clientService.save(client);
    }

    @GetMapping
    public Page<Client> listAll(@PageableDefault(page = 0, size = 10) Pageable pageable) {
        return clientService.findAll(pageable);
    }

    @GetMapping("/creditlimit/{clientId}")
    public Double getCreditLimitByClientId(@PathVariable Long clientId) {
        return clientService.getCreditLimitByClientId(clientId);
    }


    @PutMapping("/edit-credit-limit/")
    public ResponseEntity<Client> update(@RequestBody UpdateCreditLimit updateCreditLimit) {
        Optional<Client> updated = clientService.update(updateCreditLimit);

        return updated.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/{clientId}")
    public ResponseEntity<Void> delete(@PathVariable Long clientId) {
        boolean removed = clientService.delete(clientId);

        if (removed) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}