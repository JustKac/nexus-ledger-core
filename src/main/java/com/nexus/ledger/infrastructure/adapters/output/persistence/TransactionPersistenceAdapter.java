package com.nexus.ledger.infrastructure.adapters.output.persistence;

import com.nexus.ledger.domain.model.Transaction;
import com.nexus.ledger.domain.model.TransactionType;
import com.nexus.ledger.domain.repository.TransactionRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class TransactionPersistenceAdapter implements TransactionRepository {

    private final JpaTransactionRepository jpaTransactionRepository;

    public TransactionPersistenceAdapter(JpaTransactionRepository jpaTransactionRepository) {
        this.jpaTransactionRepository = jpaTransactionRepository;
    }

    @Override
    public void save(Transaction transaction) {
        TransactionEntity entity = new TransactionEntity(
                transaction.getId(),
                transaction.getAccountId(),
                transaction.getAmount(),
                TransactionTypeEntity.valueOf(transaction.getType().name()),
                transaction.getTimestamp()
        );
        jpaTransactionRepository.save(entity);
    }

    @Override
    public Optional<Transaction> findById(UUID id) {
        return jpaTransactionRepository.findById(id)
                .map(this::toDomain);
    }

    @Override
    public List<Transaction> findByAccountId(UUID accountId) {
        return jpaTransactionRepository.findByAccountId(accountId)
                .stream()
                .map(this::toDomain)
                .toList();
    }

    private Transaction toDomain(TransactionEntity entity) {
        return new Transaction(
                entity.getId(),
                entity.getAccountId(),
                entity.getAmount(),
                TransactionType.valueOf(entity.getType().name()),
                entity.getTimestamp()
        );
    }
}
