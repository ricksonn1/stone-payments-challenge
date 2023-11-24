package stone.payments.challenge.api.adapters.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import stone.payments.challenge.api.core.domain.Client;
import stone.payments.challenge.api.core.domain.CreditCard;
import stone.payments.challenge.api.core.domain.History;
import stone.payments.challenge.api.core.domain.Transaction;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public record DetailsHistoryDTO(
        String card_number,
        Long client_id,
        Integer value,
        LocalDate date,
        Long purchase_id
) {

    public DetailsHistoryDTO(Transaction transaction, History history) {
        this(transaction.getCardNumber(), transaction.getIdClient(), transaction.getCardValue(),history.getDate(), transaction.getId());
    }
}
