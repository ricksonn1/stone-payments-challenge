package stone.payments.challenge.api.adapters.dto;

import stone.payments.challenge.api.core.domain.Client;
import stone.payments.challenge.api.core.domain.History;
import stone.payments.challenge.api.core.domain.Transaction;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public record HistoryTransactionsDTO(
        Long client_id,
        Long purcharse_id,
        Integer value,
        String date,
        String card_number
) {
    public HistoryTransactionsDTO(Transaction transaction, History history) throws ParseException {
        this(transaction.getIdClient(), transaction.getId(), transaction.getCardValue(), history.getDate(), transaction.getCardNumber());
    }
}
