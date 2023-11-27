package stone.payments.challenge.api.core.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import stone.payments.challenge.api.adapters.dto.TransactionDTO;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Transaction")
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    private Integer total_to_pay;

    @Embedded
    private CreditCard credit_card;

    public Transaction(TransactionDTO data) {
        this.id = data.id();
        this.total_to_pay = data.total_to_pay();
        this.credit_card = new CreditCard(data.creditCard());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Integer getTotal_to_pay() {
        return total_to_pay;
    }

    public void setTotal_to_pay(Integer total_to_pay) {
        this.total_to_pay = total_to_pay;
    }

    public CreditCard getCredit_card() {
        return credit_card;
    }

    public void setCredit_card(CreditCard credit_card) {
        this.credit_card = credit_card;
    }

    public String getCardNumber(){
        String lastFourDigits = this.getCredit_card().getCard_number().substring(this.credit_card.getCard_number().length() - 4);
        return "**** **** **** " + lastFourDigits ;
    }
    public Long getIdClient(){
        return client.getId();
    }
    public Integer getCardValue(){
        return credit_card.getValue();
    }
}
