package com.nexus.ledger.application.ports.input;

import com.nexus.ledger.domain.model.Transaction;
import com.nexus.ledger.domain.model.TransactionType;

import java.math.BigDecimal;
import java.util.UUID;

public interface CreateTransactionUseCase {

    Transaction execute(UUID accountId, BigDecimal amount, TransactionType type);
}
