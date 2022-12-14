package exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;

// BEGIN
public class App {

    public static Map<String, String> genDiff(Map<String, Object> data1, Map<String, Object> data2) {
        Map<String, String> result = new LinkedHashMap<>();
        MapDifference<String, Object> diff = Maps.difference(data1, data2);
        Map<String, Object> entriesNotDiffering = diff.entriesInCommon();
        Map<String, MapDifference.ValueDifference<Object>> entriesDiffering = diff.entriesDiffering();
        Set<String> keysChanged = entriesDiffering.keySet();
        Set<String> keysUnchanged = entriesNotDiffering.keySet();
        Set<String> keysOnlyInSource = diff.entriesOnlyOnLeft().keySet();
        Set<String> keysOnlyInTarget = diff.entriesOnlyOnRight().keySet();
        for (String set : keysOnlyInTarget) {
            result.put(set, "added");
        }
        for (String set : keysOnlyInSource) {
            result.put(set, "deleted");
        }
        for (String set : keysUnchanged) {
            result.put(set, "unchanged");
        }
        for (String set : keysChanged) {
            result.put(set, "changed");
        }
        return new TreeMap<>(result);
    }
}
//END
