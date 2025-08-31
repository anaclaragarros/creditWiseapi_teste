package com.example.creditWiseapi.controller;

import com.example.creditWiseapi.entity.Client;
import com.example.creditWiseapi.entity.CreditLimitHistory;
import com.example.creditWiseapi.service.ClientService;
import com.example.creditWiseapi.service.CreditLimitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/credit-history")
public class CreditHistoryController {

    @Autowired
    private CreditLimitService creditLimitService;

    @GetMapping
    public Page<CreditLimitHistory> listAll(@PageableDefault(page = 0, size = 10) Pageable pageable) {
        return creditLimitService.findAll(pageable);
    }
}
