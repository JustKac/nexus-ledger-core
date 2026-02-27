package com.nexus.ledger.application.ports.input;

import java.math.BigDecimal;

import com.nexus.ledger.domain.model.Account;

public interface CreateAccountUseCase {

    Account execute(String holderName, BigDecimal initialBalance);
}
