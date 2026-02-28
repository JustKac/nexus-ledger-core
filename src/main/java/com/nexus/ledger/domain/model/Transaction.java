package com.nexus.ledger.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Transaction {

    private final UUID id;
    private final UUID accountId;
    private final BigDecimal amount;
    private final TransactionType type;
    private final LocalDateTime timestamp;

    public Transaction(UUID id, UUID accountId, BigDecimal amount, TransactionType type, LocalDateTime timestamp) {
        this.id = id;
        this.accountId = accountId;
        this.amount = amount;
        this.type = type;
        this.timestamp = timestamp;
    }

    public UUID getId() {
        return id;
    }

    public UUID getAccountId() {
        return accountId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public TransactionType getType() {
        return type;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
