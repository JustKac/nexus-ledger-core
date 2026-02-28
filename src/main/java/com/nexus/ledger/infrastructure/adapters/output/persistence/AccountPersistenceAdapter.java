package com.nexus.ledger.infrastructure.adapters.output.persistence;

import com.nexus.ledger.domain.model.Account;
import com.nexus.ledger.domain.repository.AccountRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class AccountPersistenceAdapter implements AccountRepository {

    private final JpaAccountRepository jpaAccountRepository;

    public AccountPersistenceAdapter(JpaAccountRepository jpaAccountRepository) {
        this.jpaAccountRepository = jpaAccountRepository;
    }

    @Override
    public void save(Account account) {
        AccountEntity entity = new AccountEntity(account.getId(), account.getHolderName(), account.getBalance());
        jpaAccountRepository.save(entity);
    }

    @Override
    public Optional<Account> findById(UUID id) {
        return jpaAccountRepository.findById(id)
                .map(entity -> new Account(entity.getId(), entity.getHolderName(), entity.getBalance()));
    }
}
