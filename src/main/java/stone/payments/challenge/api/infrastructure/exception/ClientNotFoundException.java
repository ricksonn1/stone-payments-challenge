package stone.payments.challenge.api.infrastructure.exception;

public class ClientNotFoundException extends RuntimeException {
    public ClientNotFoundException(Long id) {
        super("Cliente " + id + "não existe no sistema!");
    }
}
