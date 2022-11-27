package exercise;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;

// BEGIN
public class App {
    public static List<Map<String, String>> findWhere(List<Map<String, String>> list, Map<String, String> map) {
        List<Map<String, String>> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).entrySet().containsAll(map.entrySet())) {
                result.add(list.get(i));
            }
        }
        return  result;
    }
}
//END
