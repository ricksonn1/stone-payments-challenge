package stone.payments.challenge.api.adapters.dto;

import stone.payments.challenge.api.core.domain.Client;

public record ClientDTO(
        Long id,
        String name
) {
    public ClientDTO(Client client){
        this(client.getId(), client.getName());
    }
}
