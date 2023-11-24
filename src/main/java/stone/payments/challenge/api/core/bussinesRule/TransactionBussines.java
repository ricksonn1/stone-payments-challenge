package stone.payments.challenge.api.core.bussinesRule;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import stone.payments.challenge.api.adapters.dto.CreditCardDTO;
import stone.payments.challenge.api.adapters.dto.TransactionDTO;
import stone.payments.challenge.api.core.domain.Client;
import stone.payments.challenge.api.core.domain.CreditCard;
import stone.payments.challenge.api.core.domain.History;
import stone.payments.challenge.api.core.domain.Transaction;
import stone.payments.challenge.api.infrastructure.exception.ClientNotFoundException;
import stone.payments.challenge.api.infrastructure.repository.ClientRepository;
import stone.payments.challenge.api.infrastructure.repository.HistoryTransactionRepository;
import stone.payments.challenge.api.infrastructure.repository.TransactionRepository;

@Controller
public class TransactionBussines {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private HistoryTransactionRepository historyTransactionRepository;

    public Transaction createTransaction(@RequestBody Transaction data) throws ClientNotFoundException {
        Transaction savedTransaction = transactionRepository.save(data);
        History history = new History(savedTransaction.getClient().getId(), savedTransaction.getId());
        historyTransactionRepository.save(history);
        return savedTransaction;
    }
}

