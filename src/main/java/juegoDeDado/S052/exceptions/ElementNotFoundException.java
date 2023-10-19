package juegoDeDado.S052.exceptions;

public class ElementNotFoundException extends RuntimeException{

    public ElementNotFoundException(Class type, Long id) {
        super(type.getSimpleName() + " with id " + id + " not found");
    }
}
