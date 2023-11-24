package stone.payments.challenge.api.core.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import stone.payments.challenge.api.adapters.dto.ClientDTO;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "Client")
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Client(ClientDTO data) {
        this.name = data.name();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
