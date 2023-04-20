package exercise;

import java.util.Set;

// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage storage) {
        Set<String> keys = storage.toMap().keySet();
        for (String key : keys) {
            String value = storage.get(key, null);
            if (value != null) {
                storage.unset(key);
                storage.set(value, key);
            }
        }
    }
}
// END
