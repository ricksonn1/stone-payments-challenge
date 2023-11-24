package stone.payments.challenge.api.core.bussinesRule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import stone.payments.challenge.api.core.domain.Client;
import stone.payments.challenge.api.infrastructure.exception.ClientAlReadyRegisteredException;
import stone.payments.challenge.api.infrastructure.repository.ClientRepository;

import java.util.List;

@Controller
public class ClientBussines {

    @Autowired
    private ClientRepository clientRepository;

    public Client createClient(Client client) throws ClientAlReadyRegisteredException{
        if (clientRepository.findByName(client.getName()).isPresent()) {
            throw new ClientAlReadyRegisteredException(client.getName());
        }
        return clientRepository.save(client);
    }

    public List<Client> getAllClients() {

        return clientRepository.findAll();
    }
}
