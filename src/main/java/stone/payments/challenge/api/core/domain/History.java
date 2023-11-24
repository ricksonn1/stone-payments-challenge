package stone.payments.challenge.api.core.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import stone.payments.challenge.api.adapters.dto.ClientDTO;
import stone.payments.challenge.api.adapters.dto.HistoryTransactionsDTO;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "History")
@Table(name = "historys")
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "purchase_id")
    private Transaction transaction;

    @Column(name = "date", insertable = false, updatable = false)
    private LocalDate date;

    public History(Client client, Transaction id) {
        this.client = client;
        this.transaction = id;
        this.date = LocalDate.now();
    }

    public History(Long id, Long id1) {
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

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = LocalDate.parse(date);
    }

    public Long getTransaction() {
        return transaction.getId();
    }
}
