package com.example.creditWiseapi.repository;

import com.example.creditWiseapi.entity.CreditLimitHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditLimitHistoryRepository extends JpaRepository<CreditLimitHistory, Long> {

}