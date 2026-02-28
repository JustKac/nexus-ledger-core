package com.nexus.ledger.application.services;

import com.nexus.ledger.application.ports.input.CreateTransactionUseCase;
import com.nexus.ledger.domain.model.Account;
import com.nexus.ledger.domain.model.Transaction;
import com.nexus.ledger.domain.model.TransactionType;
import com.nexus.ledger.domain.repository.AccountRepository;
import com.nexus.ledger.domain.repository.TransactionRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class TransactionService implements CreateTransactionUseCase {

    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;

    public TransactionService(TransactionRepository transactionRepository, AccountRepository accountRepository) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    public Transaction execute(UUID accountId, BigDecimal amount, TransactionType type) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new IllegalArgumentException("Account not found: " + accountId));

        if (type == TransactionType.CREDIT) {
            account.credit(amount);
        } else {
            account.debit(amount);
        }

        accountRepository.save(account);

        Transaction transaction = new Transaction(UUID.randomUUID(), accountId, amount, type, LocalDateTime.now());
        transactionRepository.save(transaction);

        return transaction;
    }
}
