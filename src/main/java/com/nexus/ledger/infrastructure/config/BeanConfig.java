package com.nexus.ledger.infrastructure.config;

import com.nexus.ledger.application.services.AccountService;
import com.nexus.ledger.application.services.TransactionService;
import com.nexus.ledger.domain.repository.AccountRepository;
import com.nexus.ledger.domain.repository.TransactionRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    AccountService accountService(AccountRepository accountRepository) {
        return new AccountService(accountRepository);
    }

    @Bean
    TransactionService transactionService(TransactionRepository transactionRepository, AccountRepository accountRepository) {
        return new TransactionService(transactionRepository, accountRepository);
    }
}