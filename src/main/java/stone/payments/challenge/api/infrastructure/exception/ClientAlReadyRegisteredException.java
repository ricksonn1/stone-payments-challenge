package stone.payments.challenge.api.infrastructure.exception;

public class ClientAlReadyRegisteredException extends RuntimeException {
    public ClientAlReadyRegisteredException(String name) {
        super("Cliente " + name + "já existe em nosso sistema!");
    }
}
