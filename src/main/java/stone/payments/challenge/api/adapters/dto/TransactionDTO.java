package stone.payments.challenge.api.adapters.dto;



public record TransactionDTO(
        Long id,
        Long client_id,
        String client_name,
        Integer total_to_pay,
        CreditCardDTO creditCard
) {
}
