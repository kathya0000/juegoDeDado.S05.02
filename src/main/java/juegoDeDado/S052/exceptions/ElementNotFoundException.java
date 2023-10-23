package juegoDeDado.S052.exceptions;

public class ElementNotFoundException extends RuntimeException {

    public ElementNotFoundException(Class<?> type, Long id) {
        super(type.getSimpleName() + " with id " + id + " not found");
    }

    public ElementNotFoundException(Class<?> type, String key) {
        super(type.getSimpleName() + " with key " + key + " not found");
    }
}

