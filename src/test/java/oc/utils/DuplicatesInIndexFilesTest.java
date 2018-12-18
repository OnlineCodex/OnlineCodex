package oc.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.MapLikeType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Table;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;
import static oc.utils.ResourceUtils.sanitizeKey;
import static org.junit.Assert.fail;

@RunWith(JUnitParamsRunner.class)
public class DuplicatesInIndexFilesTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(DuplicatesInIndexFilesTest.class);

    private final ObjectMapper om;
    private final MapLikeType mapType;

    public DuplicatesInIndexFilesTest() {
        om = new ObjectMapper(new YAMLFactory());
        om.configure(JsonParser.Feature.STRICT_DUPLICATE_DETECTION, true);

        TypeFactory TF = om.getTypeFactory();
        mapType = TF.constructMapLikeType(HashMap.class,
                TF.constructType(String.class),
                TF.constructType(Integer.class));
    }

    public static List<String> indexFiles() throws Exception {
        return ResourceUtilsTest.indexFiles();
    }

    @Test
    @Parameters(method = "indexFiles")
    public void testDuplicatesInFile(String file) throws IOException {
        Map<String, Integer> m = om.readValue(ResourceUtils.class.getResource(file), mapType);
        Table<String, String, Integer> t = HashBasedTable.create();
        m.entrySet().forEach(e -> t.put(file, e.getKey(), e.getValue()));
        warnSimplifiedDuplicates(t);
    }

    private void warnSimplifiedDuplicates(Table<String, String, Integer> entries) {
        List<List<Table.Cell<String, String, Integer>>> conflicts = entries.columnKeySet()
                .stream()
                .map(DuplicatesInIndexFilesTest::simplifyKey)
                .distinct()
                .map(k -> entries.cellSet()
                        .stream()
                        .filter(e -> k.equals(simplifyKey(e.getColumnKey())))
                        .collect(toList()))
                .filter(ex -> ex.size() != 1)
                .collect(toList());
        if (!conflicts.isEmpty()) {
            LOGGER.error("There are duplicate keys that resolve to the same simplified key\n\n"
                    + conflicts.stream()
                         .map(c -> simplifyKey(c.get(0).getColumnKey()) + ":\n"
                                 + c.stream()
                                         .map(e -> "  " + e.getRowKey() + ": " + e.getColumnKey() + " -> " + e.getValue())
                                         .collect(joining("\n")))
                         .collect(joining("\n\n")));
        }
    }

    private static String simplifyKey(String key) {
        return sanitizeKey(key)
                .replaceAll("[^a-zA-Z0-9_']+.*$", "");
    }

    public static Object[] indexSets() {
        return new Object[] {
                ImmutableSet.of(
                        "/oc/wh40k/indices/ae.yaml",
                        "/oc/wh40k/indices/de.yaml"),
                ImmutableSet.of("/oc/wh40k/indices/chaos.yaml"),
                Stream.of("sm", "ba", "da", "sw", "dw", "gk", "am", "ame", "qi", "ami", "oa", "ac", "iaaa")
                        .map(name -> String.format("/oc/wh40k/indices/%s.yaml", name))
                        .collect(toSet()),
                ImmutableSet.of(
                        "/oc/wh40k/indices/ne.yaml",
                        "/oc/wh40k/indices/iane.yaml"),
                ImmutableSet.of("/oc/wh40k/indices/or.yaml"),
                ImmutableSet.of(
                        "/oc/wh40k/indices/ta.yaml",
                        "/oc/wh40k/indices/taaa.yaml"),
                ImmutableSet.of("/oc/wh40k/indices/ty.yaml"),
        };
    }

    @Test
    @Parameters(method = "indexSets")
    public void testWarnDuplicate(Set<String> indexSet) throws Exception {
        Table<String, String, Integer> t = HashBasedTable.create();
        for (String f : indexSet) {
            Map<String, Integer> m = om.readValue(ResourceUtils.class.getResource(f), mapType);
            m.entrySet().forEach(e -> t.put(f, e.getKey(), e.getValue()));
        }
        warnSimplifiedDuplicates(t);
    }

    @Test
    @Parameters(method = "indexSets")
    public void testDuplicate(Set<String> indexSet) throws Exception {
        Table<String, String, Integer> t = HashBasedTable.create();
        for (String f : indexSet) {
            Map<String, Integer> m = om.readValue(ResourceUtils.class.getResource(f), mapType);
            m.entrySet().forEach(e -> t.put(f, e.getKey(), e.getValue()));
        }
        List<Map.Entry<String, Map<String, Integer>>> duplicates = t.columnMap().entrySet().stream()
                .filter(e -> e.getValue().size() != 1)
                .collect(toList());

        if (!duplicates.isEmpty()) {
            fail("\n" + duplicates.stream()
                    .map(e -> e.getKey() + ":\n" + e.getValue().entrySet()
                            .stream()
                            .map(e0 -> "  " + e0.getKey() + " -> " + e0.getValue())
                            .collect(joining("\n")))
                    .collect(joining("\n\n")));
        }
    }
}
