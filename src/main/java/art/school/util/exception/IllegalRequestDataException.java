package art.school.util.exception;

import org.springframework.lang.NonNull;

public class IllegalRequestDataException extends RuntimeException {

    public IllegalRequestDataException(@NonNull String message) {
        super(message);
    }
}
