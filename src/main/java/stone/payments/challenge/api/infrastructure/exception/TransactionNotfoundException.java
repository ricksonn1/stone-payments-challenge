package stone.payments.challenge.api.infrastructure.exception;

public class TransactionNotfoundException extends RuntimeException{
    public TransactionNotfoundException(Long id){
        super("Transação não encontrada em nosso sistema!");
    }
}
