package stone.payments.challenge.api.core.domain;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import stone.payments.challenge.api.adapters.dto.CreditCardDTO;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreditCard {

    private String card_number;
    private String card_holder_name;
    private Integer value;
    private Integer cvv;
    private String exp_date;

    public CreditCard(CreditCardDTO data) {
        this.card_number = data.card_number();
        this.card_holder_name = data.card_holder_name();
        this.value = data.value();
        this.cvv = data.cvv();
        this.exp_date = data.exp_date();
    }

    public String getCard_number() {
        return card_number;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }

    public String getCard_holder_name() {
        return card_holder_name;
    }

    public void setCard_holder_name(String card_holder_name) {
        this.card_holder_name = card_holder_name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getCvv() {
        return cvv;
    }

    public void setCvv(Integer cvv) {
        this.cvv = cvv;
    }

    public String getExp_date() {
        return exp_date;
    }

    public void setExp_date(String exp_date) {
        this.exp_date = exp_date;
    }
}
