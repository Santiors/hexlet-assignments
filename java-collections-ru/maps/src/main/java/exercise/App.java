package exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// BEGIN
public class App {

    public static Map<String, Integer> getWordCount(String sentence) {
        Map<String, Integer> map = new HashMap<>();
        if (!sentence.isEmpty()) {
            String[] letters = sentence.split(" ");
            ArrayList coll = new ArrayList(Arrays.asList(letters));
            ArrayList helpList = new ArrayList(Arrays.asList(letters));
            for (int i = 0; i < coll.size(); i++) {
                int counter = 0;
                for (int j = 0; j < helpList.size(); j++) {
                    if (coll.get(i).equals(helpList.get(j))) {
                        counter++;
                    }
                }
                map.put(String.valueOf(coll.get(i)), counter);
            }
        }
        return map;
    }

    public static String toString(Map wordCount1) {
        if (wordCount1.isEmpty()) {
            return "{}";
        } else {
            ArrayList values = new ArrayList(wordCount1.values());
            ArrayList keys = new ArrayList(wordCount1.keySet());
            String output = "{" + "\n";
            for (int i = 0; i < keys.size(); i++) {
                output += "  " + keys.get(i) + ":" + " " + values.get(i) + "\n";
            }
            output += "}";
            return output;
        }
    }
}
//END
