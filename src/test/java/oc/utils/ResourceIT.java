package oc.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.MapLikeType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import static oc.utils.ResourceUtils.sanitizeKey;
import static org.junit.Assert.fail;

@RunWith(JUnitParamsRunner.class)
public class ResourceIT {

    private final ObjectMapper om;
    private final MapLikeType mapType;

    public ResourceIT() {
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
        assertNoDuplicates(t);
    }

    private void assertNoDuplicates(Table<String, String, Integer> entries) {
        List<List<Table.Cell<String, String, Integer>>> conflicts = entries.columnKeySet()
                .stream()
                .map(ResourceIT::simplifyKey)
                .map(k -> entries.cellSet()
                        .stream()
                        .filter(e -> k.equals(simplifyKey(e.getColumnKey())))
                        .collect(toList()))
                .filter(ex -> ex.size() != 1)
                .collect(toList());
        if (!conflicts.isEmpty()) {
            fail("There are duplicate keys that resolve to the same simplified key\n\n"
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

    @Test
    public void testDuplicate() throws Exception {
        Table<String, String, Integer> t = HashBasedTable.create();
        for (String f : indexFiles()) {
            Map<String, Integer> m = om.readValue(ResourceUtils.class.getResource(f), mapType);
            m.entrySet().forEach(e -> t.put(f, e.getKey(), e.getValue()));
        }
        assertNoDuplicates(t);
    }
}
