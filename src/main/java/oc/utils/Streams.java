package oc.utils;

import java.util.function.Function;
import java.util.stream.Stream;

public final class Streams {
    private Streams() {}

    public static <T> Stream<T> traverse(T root, Function<T, Stream<T>> getChildren) {
        return Stream.concat(
                Stream.of(root),
                getChildren.apply(root)
                    .flatMap(c -> traverse(c, getChildren)));
    }
}
