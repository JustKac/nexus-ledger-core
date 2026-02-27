package com.nexus.ledger.domain.repository;

import java.util.Optional;
import java.util.UUID;

import com.nexus.ledger.domain.model.Account;

public interface AccountRepository {
    void save(Account account);
    Optional<Account> findById(UUID id);
}
