package juegoDeDado.S052.exceptions;

public class ElementsDoesntEqualsException extends RuntimeException{

    public ElementsDoesntEqualsException(Class type, Long id, Long idDto) {
        super("Id's in " + type.getSimpleName() + " must be equals. Entered values " + id + " - "+ idDto);
    }
}
