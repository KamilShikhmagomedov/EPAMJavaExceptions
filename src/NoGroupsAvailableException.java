public class NoGroupsAvailableException extends Exception {
    public NoGroupsAvailableException() {
    }

    public NoGroupsAvailableException(String message) {
        super(message);
    }

    public NoGroupsAvailableException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoGroupsAvailableException(Throwable cause) {
        super(cause);
    }
}
