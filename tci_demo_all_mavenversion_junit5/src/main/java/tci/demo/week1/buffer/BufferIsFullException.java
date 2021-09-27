package tci.demo.week1.buffer;

public class BufferIsFullException extends Exception {
    public BufferIsFullException() {
        super();
    }

    public BufferIsFullException(String message) {
        super(message);
    }

    public BufferIsFullException(String message, Throwable cause) {
        super(message, cause);
    }

    public BufferIsFullException(Throwable cause) {
        super(cause);
    }

    protected BufferIsFullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
