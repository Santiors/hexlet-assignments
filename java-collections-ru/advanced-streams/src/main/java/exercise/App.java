package exercise;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// BEGIN
public class App {

    public static String getForwardedVariables(String data) {
        List<String> result = Stream.of(data.split("\n"))
                .filter(d -> d.startsWith("environment") && d.contains("X_FORWARDED"))
                .map(d -> d.substring(13, d.length() - 1))
                .collect(Collectors.toList());
        String test = new String();
        for (int i = 0; i<result.size(); i++){
            test+= result.get(i) + ",";
        }
        return Stream.of(test.split(","))
                .filter(d -> d.contains("X_FORWARDED"))
                .map(d -> d.replaceAll("X_FORWARDED_", ""))
                .collect(Collectors.joining(","));
    }
}
//END
