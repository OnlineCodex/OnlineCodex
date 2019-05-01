package oc.utils;

import static java.lang.ClassLoader.getSystemResource;
import static java.util.stream.Collectors.toList;
import static oc.utils.ResourceUtils.sanitizeKey;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.common.collect.ImmutableMap;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class ResourceUtilsTest {

    @Test
    public void testLoadPointsNoCollision() {
        final Map<String, Integer> points = ResourceUtils.loadPoints(
                e -> fail(String.format("unexpected collision: %s", e)),
                Stream.of(
                        "/oc/wh40k/indices/yn.yaml",
                        "/oc/wh40k/indices/oa.yaml"));
        assertEquals(
                ImmutableMap.<String, Integer>builder()
                    .put(sanitizeKey("The Visarch"), 120)
                    .put(sanitizeKey("The Yncarne"), 337)
                    .put(sanitizeKey("Yvraine"), 132)
                    .put(sanitizeKey("Callidus Assassin"), 85)
                    .put(sanitizeKey("Culexus Assassin"), 85)
                    .put(sanitizeKey("Eversor Assassin"), 85)
                    .put(sanitizeKey("Vindicare Assassin"), 85)
                    .build(),
                points
        );
    }


    public static List<String> indexFiles() throws Exception {
        final Path indices = Paths.get(getSystemResource("oc/wh40k/indices/").toURI());
        try (Stream<Path> dir = Files.list(indices)) {
            return dir.map(Path::getFileName)
                    .map(n -> "/oc/wh40k/indices/" + n)
                    .collect(toList());
        }
    }

    @Test
    @Parameters(method = "indexFiles")
    public void testLoadPointsAllFilesLoadable(String file) {
        final Map<String, Integer> points = ResourceUtils.loadPoints(file);
        assertFalse("points are not empty", points.isEmpty());
    }
}