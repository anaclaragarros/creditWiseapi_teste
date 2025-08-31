package com.example.creditWiseapi.service;

import com.example.creditWiseapi.entity.Client;
import com.example.creditWiseapi.entity.CreditLimitHistory;
import com.example.creditWiseapi.repository.CreditLimitHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CreditLimitService {

    @Autowired
    private CreditLimitHistoryRepository creditLimitHistoryRepository;

    public Page<CreditLimitHistory> findAll(Pageable pageable) {
        return creditLimitHistoryRepository.findAll(pageable);
    }
}
