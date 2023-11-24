package stone.payments.challenge.api.adapters.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import stone.payments.challenge.api.adapters.dto.DetailsHistoryDTO;
import stone.payments.challenge.api.adapters.dto.HistoryTransactionsDTO;
import stone.payments.challenge.api.core.bussinesRule.HistoryTransactionsBussines;

import java.util.List;

@RestController
@RequestMapping
public class HistoryTransactionsController {

    @Autowired
    private HistoryTransactionsBussines historyTransactionsBussines;

//    @GetMapping("/starstore/history")
//    public ResponseEntity<List<DetailsHistoryDTO>> getAllTransactions() {
//        List<DetailsHistoryDTO> transactions = historyTransactionsBussines.getHistoryOfTransactions();
//        return ResponseEntity.ok(transactions);
//    }
//}
}
