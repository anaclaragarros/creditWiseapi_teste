package com.example.creditWiseapi.service;

import com.example.creditWiseapi.entity.User;
import com.example.creditWiseapi.entity.UserRoles;
import com.example.creditWiseapi.model.UpdateCreditLimit;
import com.example.creditWiseapi.repository.CreditLimitHistoryRepository;
import com.example.creditWiseapi.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.creditWiseapi.entity.Client;
import com.example.creditWiseapi.entity.CreditLimitHistory;
import com.example.creditWiseapi.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private final List<Client> clients = new ArrayList<>();
    private final List<CreditLimitHistory> history = new ArrayList<>();

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CreditLimitHistoryRepository creditLimitHistoryRepository;

    public Client save(Client client) {
        System.out.println("Cliente criado: " + client);
        validateClient(client);
        return clientRepository.save(client);
    }

    public Page<Client> findAll(Pageable pageable) {
        return clientRepository.findAll(pageable);
    }

    public Optional<Client> update(UpdateCreditLimit updateCreditLimit) {
        Client client = clientRepository.findById(updateCreditLimit.getClientId()).orElseThrow();
        Double oldCreditLimit = client.getCreditLimit();
        client.setCreditLimit(updateCreditLimit.getCreditLimit());
        validateUserRole(updateCreditLimit.getUserId());
        validateClient(client);
        clientRepository.save(client);
        CreditLimitHistory history = new CreditLimitHistory();
        history.setUserId(updateCreditLimit.getUserId());
        history.setClientId(client.getId());
        history.setNewLimit(client.getCreditLimit());
        history.setOldLimit(oldCreditLimit);
        history.setChangeDate(LocalDateTime.now());
        creditLimitHistoryRepository.save(history);
        return Optional.of(client);
    }

    private void validateClient(Client client) {
        double creditLimit = client.getCreditLimit();

        if (creditLimit < 0) {
            throw new IllegalArgumentException("O limite de crédito não pode ser menor que 0.");
        }

        if (client.isVip()) {
            if (creditLimit < Client.MIN_VIP_CREDIT_LIMIT) {
                throw new IllegalArgumentException("Para clientes VIP o limite de crédito não pode ser menor que 50.");
            }
        }
    }

    private void validateUserRole(Long userId){
        User user = userRepository.findById(userId).orElseThrow();
        if(!user.getRole().equals(UserRoles.CREDIT_LIMIT_ADMIN)) {
            throw new IllegalArgumentException("Somente usuários ADMIN podem atualizar o credito do cliente");
        }
    }

    public boolean delete(Long clientId) {
        return clients.removeIf(c -> c.getId().equals(clientId));
    }

    public List<CreditLimitHistory> findHistoryByClientId(Long clientId) {
        List<CreditLimitHistory> clientHistory = new ArrayList<>();
        for (CreditLimitHistory entry : history) {
            if (entry.getClientId().equals(clientId)) {
                clientHistory.add(entry);
            }
        }
        return clientHistory;
    }

    public Double getCreditLimitByClientId(Long clientId) {
        Client client = clientRepository.findById(clientId).orElseThrow();
        return client.getCreditLimit();
    }
}