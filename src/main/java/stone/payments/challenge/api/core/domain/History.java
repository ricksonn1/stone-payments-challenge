package stone.payments.challenge.api.core.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

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
    private String date;


    public History(Client client, Transaction transaction) {
        this.client = client;
        this.transaction = transaction;
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

    public String getDate() throws ParseException {
        LocalDateTime dateTime = LocalDateTime.parse(this.date, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = dateTime.format(formatter);
        return formattedDate;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getTransaction() {
        return transaction.getId();
    }
}
