package stone.payments.challenge.api.infrastructure.exception;

public class ProductAlreadyRegisteresException extends RuntimeException {
    public ProductAlreadyRegisteresException(String title) {
        super("Produto com o titulo: " + title + "já existe em nosso sistema");
    }
}
