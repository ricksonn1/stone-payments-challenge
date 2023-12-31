package stone.payments.challenge.api.core.bussinesRule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import stone.payments.challenge.api.adapters.dto.HistoryTransactionsDTO;
import stone.payments.challenge.api.core.domain.History;
import stone.payments.challenge.api.core.domain.Transaction;
import stone.payments.challenge.api.infrastructure.exception.TransactionNotfoundException;
import stone.payments.challenge.api.infrastructure.repository.ClientRepository;
import stone.payments.challenge.api.infrastructure.repository.HistoryTransactionRepository;
import stone.payments.challenge.api.infrastructure.repository.TransactionRepository;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HistoryTransactionsBussines {

    @Autowired
    private HistoryTransactionRepository historyTransactionRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private ClientRepository clientRepository;

    public List<HistoryTransactionsDTO> getHistoryOfTransactions() throws ParseException {

        List<HistoryTransactionsDTO> detailsHistoryDTOList = new ArrayList<>();

        List<History> historyList = historyTransactionRepository.findAll();

        for (History history : historyList) {
            Transaction transaction = transactionRepository.findById(history.getTransaction())
                    .orElseThrow(() -> new TransactionNotfoundException(history.getTransaction()));

            detailsHistoryDTOList.add(new HistoryTransactionsDTO(transaction, history));
        }
        return detailsHistoryDTOList;
    }
}
