public class DoesntHaveLessonException extends Exception {
    public DoesntHaveLessonException() {
    }

    public DoesntHaveLessonException(String message) {
        super(message);
    }

    public DoesntHaveLessonException(String message, Throwable cause) {
        super(message, cause);
    }

    public DoesntHaveLessonException(Throwable cause) {
        super(cause);
    }
}
