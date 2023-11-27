package stone.payments.challenge.api.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import stone.payments.challenge.api.core.domain.History;

public interface HistoryTransactionRepository extends JpaRepository<History, Long> {

}
