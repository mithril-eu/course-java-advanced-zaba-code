package eu.mithril.training.spring.boot.todo.model.exception;

public class InvalidIdException extends RuntimeException {
    public InvalidIdException(final String message, final String todoId) {
        super(String.format(message, todoId));
    }
}
