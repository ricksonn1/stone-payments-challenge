package stone.payments.challenge.api.adapters.dto;

import stone.payments.challenge.api.core.domain.Client;
import stone.payments.challenge.api.core.domain.Transaction;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public record HistoryTransactionsDTO(
        String card_number,
        Long client_id,
        Integer value,
        String date,
        Long purcharse_id
) {
}
