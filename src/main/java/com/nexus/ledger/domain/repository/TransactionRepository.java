package com.nexus.ledger.domain.repository;

import com.nexus.ledger.domain.model.Transaction;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TransactionRepository {
    void save(Transaction transaction);
    Optional<Transaction> findById(UUID id);
    List<Transaction> findByAccountId(UUID accountId);
}
