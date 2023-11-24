package stone.payments.challenge.api.adapters.dto;

import stone.payments.challenge.api.core.domain.CreditCard;

public record CreditCardDTO(
        String card_number,
        String card_holder_name,
        Integer value,
        Integer cvv,
        String exp_date
) {
    public CreditCardDTO(CreditCard creditCard) {
        this(creditCard.getCard_number(), creditCard.getCard_holder_name(), creditCard.getValue(),
                creditCard.getCvv(), creditCard.getExp_date());
    }

}
