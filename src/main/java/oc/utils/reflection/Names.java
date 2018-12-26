package oc.utils.reflection;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.stream.Stream;

import static oc.utils.Streams.traverse;

public final class Names {
    private Names() {}

    private static final LoadingCache<Class<?>, Optional<String>> ANNOTATED_NAME_CACHE = CacheBuilder.newBuilder()
                    .weakKeys()
                    .build(CacheLoader.from(Names::annotatedName));

    public static String name(Class<?> cls) {
        return ANNOTATED_NAME_CACHE.getUnchecked(cls)
                .orElseGet(cls::getSimpleName);
    }

    private static Optional<String> annotatedName(Class<?> cls) {
        return superClasses(cls)
                .map(c -> c.getAnnotation(Name.class))
                .filter(Objects::nonNull)
                .map(Name::value)
                .findFirst();
    }

    private static <T> Stream<Class<? super T>> superClasses(Class<T> cls) {
        return traverse(
                cls,
                c -> c != null && c != Object.class
                        ? Stream.of(c.getSuperclass())
                        : Stream.of());
    }
}
