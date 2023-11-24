package stone.payments.challenge.api.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestBody;
import stone.payments.challenge.api.core.domain.Client;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {
    @Query("SELECT e FROM Client e WHERE e.name = :name")
    Optional<Client> findByName(@RequestBody String name);

    @Query("Select e FROM Client e WHERE e.id = :id")
    Optional<Client> findById(@RequestBody Long id);
}
