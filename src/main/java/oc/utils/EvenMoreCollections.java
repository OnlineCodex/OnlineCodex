package oc.utils;

import java.util.Collection;
import java.util.List;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

public final class EvenMoreCollections {
    private EvenMoreCollections() {}

    public static <E> List<E> concat(Collection<? extends E>... lists) {
        return stream(lists)
                .flatMap(Collection::stream)
                .collect(toList());
    }
}
