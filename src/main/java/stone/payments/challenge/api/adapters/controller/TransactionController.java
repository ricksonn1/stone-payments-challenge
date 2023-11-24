package stone.payments.challenge.api.adapters.controller;


import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import stone.payments.challenge.api.adapters.dto.CreditCardDTO;
import stone.payments.challenge.api.adapters.dto.TransactionDTO;
import stone.payments.challenge.api.core.bussinesRule.TransactionBussines;
import stone.payments.challenge.api.core.domain.CreditCard;
import stone.payments.challenge.api.core.domain.Transaction;


@RestController
@RequestMapping
public class TransactionController {

    @Autowired
    private TransactionBussines transactionBussines;

    @Transactional
    @PostMapping("/starstore/buy")
    public ResponseEntity create(@RequestBody @Valid Transaction data) {
            Transaction transaction = transactionBussines.createTransaction(data);
            return ResponseEntity.status(HttpStatus.CREATED).body(transaction);
        }
    }

