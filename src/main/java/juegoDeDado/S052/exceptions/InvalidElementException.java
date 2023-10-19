package juegoDeDado.S052.exceptions;

public class InvalidElementException extends RuntimeException{

    public InvalidElementException(Class type) {
        super("Id from " + type.getSimpleName() + " is invalid");
    }
}
