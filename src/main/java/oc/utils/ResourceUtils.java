package oc.utils;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Collectors.toSet;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Consumer;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.collect.Table;

public final class ResourceUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(ResourceUtils.class);
    private static final ObjectMapper OM = new ObjectMapper(new YAMLFactory());
    private static final JavaType MAP_STRING_INTEGER_TYPE_REF = mapStringIntegerTypeRef();

    private static JavaType mapStringIntegerTypeRef() {
        final TypeFactory TF = OM.getTypeFactory();
        return TF.constructMapLikeType(HashMap.class,
                TF.constructType(String.class),
                TF.constructType(Integer.class));
    }

    private ResourceUtils() {}

    public static Map<String, Integer> loadPoints(String... uris) {
        return loadPoints(Stream.of(uris));
    }

    public static Map<String, Integer> loadPoints(Stream<String> uris) {
        return loadPoints(ResourceUtils::logDuplicateKeys, uris);
    }

    private static void logDuplicateKeys(Entry<String, List<Table.Cell<URL, String, Integer>>> e) {
        if (LOGGER.isWarnEnabled()) {
            final String uriToValue = e.getValue()
                    .stream()
                    .map(c -> String.format("%s -> %d", c.getRowKey(), c.getValue()))
                    .collect(joining(", "));
            LOGGER.warn("found duplicate points for key {} in resources: {}", e.getKey(), uriToValue);
        }
    }

    static Map<String, Integer> loadPoints(
            Consumer<Entry<String, List<Table.Cell<URL, String, Integer>>>> onDuplicateKeys,
            Stream<String> uris) {
        return loadPointsAsTable(uris)
                .cellSet()
                .stream()
                .collect(groupingBy(Table.Cell::getColumnKey))
                .entrySet()
                .stream()
                .map(c -> mergeCells(onDuplicateKeys, c))
                .collect(toMap(Entry::getKey, Entry::getValue));
    }

    private static Table<URL, String, Integer> loadPointsAsTable(Stream<String> uris) {
        final Table<URL, String, Integer> table = HashBasedTable.create();
        for (final String uri : uris.collect(toSet())) {
            final URL url = ResourceUtils.class.getResource(uri);
            if (url == null) {
                LOGGER.error("Could not find resource {}", uri);
            } else {
                loadPointsResource(url)
                        .entrySet()
                        .stream()
                        .forEach(e -> table.put(url, sanitizeKey(e.getKey()), e.getValue()));
            }
        }
        return table;
    }

    public static String sanitizeKey(String key) {
        return key
                .replaceAll("[-\\s]+", "")
                .toLowerCase();
    }

    private static Entry<String, Integer> mergeCells(
            Consumer<Entry<String, List<Table.Cell<URL, String, Integer>>>> onDuplicateKeys,
            Entry<String, List<Table.Cell<URL, String, Integer>>> e) {
        if (e.getValue().size() > 1) {
            onDuplicateKeys.accept(e);
        }
        return Maps.immutableEntry(e.getKey(), e.getValue().get(0).getValue());
    }

    private static Map<String, Integer> loadPointsResource(URL uri) {
        try {
            return OM.readValue(uri, MAP_STRING_INTEGER_TYPE_REF);
        } catch (final IOException e) {
            LOGGER.error("could not load points resource " + uri, e);
            return ImmutableMap.of();
        }
    }
}
