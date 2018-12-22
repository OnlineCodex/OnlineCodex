package oc.utils;

import org.reflections.Reflections;

import java.util.stream.Stream;

public final class Classes {
    private Classes() {}

    @SuppressWarnings({
            "unchecked", "rawtypes", // java reflection is too weak
    })
    public static  <T> Stream<Class<? extends T>> subClasses(String basePackage, Class<T> cls) {
        Reflections r = new Reflections(basePackage);
        return Streams.traverse(cls, c -> (Stream) r.getSubTypesOf(c).stream());
    }
}
