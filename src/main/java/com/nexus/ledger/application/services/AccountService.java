package com.nexus.ledger.application.services;

import java.math.BigDecimal;
import java.util.UUID;

import com.nexus.ledger.application.ports.input.CreateAccountUseCase;
import com.nexus.ledger.domain.model.Account;
import com.nexus.ledger.domain.repository.AccountRepository;

public class AccountService implements CreateAccountUseCase {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account execute(String holderName, BigDecimal initialBalance) {
        Account newAccount = new Account(UUID.randomUUID(), holderName, initialBalance);
        accountRepository.save(newAccount);
        return newAccount;
    }
}
