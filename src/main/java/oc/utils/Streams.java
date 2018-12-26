package oc.utils;

import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.stream.Stream.concat;

public final class Streams {
    private Streams() {}

    public static <T> Stream<T> traverse(T root, Function<? super T, Stream<? extends T>> getChildren) {
        return concat(
                Stream.of(root),
                getChildren.apply(root));
    }
}
