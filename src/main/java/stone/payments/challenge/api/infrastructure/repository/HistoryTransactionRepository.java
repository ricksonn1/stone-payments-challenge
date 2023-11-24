package stone.payments.challenge.api.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import stone.payments.challenge.api.adapters.dto.DetailsHistoryDTO;
import stone.payments.challenge.api.core.domain.History;

import java.util.List;

public interface HistoryTransactionRepository extends JpaRepository<History, Long> {

}
