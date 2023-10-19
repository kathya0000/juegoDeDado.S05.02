package juegoDeDado.S052.exceptions;

public class ElementAlreadyExistsException extends RuntimeException{

    public ElementAlreadyExistsException(Class type, String name) {
        super("Element of " + type.getSimpleName() + " with name " + name + " already exists");
    }
}
