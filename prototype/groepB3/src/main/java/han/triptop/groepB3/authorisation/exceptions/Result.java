package han.triptop.groepB3.authorisation.exceptions;


import java.util.function.Function;

public class Result<T, E> {
    private final T value;
    private final E error;

    private Result(T value, E error) {
        this.value = value;
        this.error = error;
    }

    public static <T, E> Result<T, E> fromValue(T value) {
        return new Result<>(value, null);
    }

    public static <T, E> Result<T, E> fromError(E error) {
        return new Result<>(null, error);
    }

    public boolean isError() {
        return error != null;
    }

    public boolean isSuccess() {
        return value != null;
    }

    public E getError() {
        if (error == null) {
            throw new IllegalStateException("The error was not set");
        }
        return error;
    }

    public T getValue() {
        if (value == null) {
            throw new IllegalStateException("The value was not set, the error that occurred was: " + this.error);
        }
        return value;
    }

    public <T2> Result<T2, E> map(Function<T, T2> mapper) {
        if (isSuccess()) {
            return Result.fromValue(mapper.apply(value));
        }
        return Result.fromError(error);
    }

    public T orElse(T value) {
        if (isSuccess()) {
            return this.value;
        }
        return value;
    }

    public T orElseGet(Function<E, T> value) {
        if (isSuccess()) {
            return this.value;
        }
        return value.apply(this.error);
    }

    public <E2 extends Throwable> T orElseThrow(Function<E, E2> t) throws E2 {
        if (isSuccess()) {
            return this.value;
        }
        throw t.apply(this.error);
    }
}
