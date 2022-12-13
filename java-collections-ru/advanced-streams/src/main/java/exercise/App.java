package exercise;

import java.util.Arrays;
import java.util.stream.Collectors;

// BEGIN
public class App {

    public static String getForwardedVariables(String data) {
        String[] strings = data.split("\n");
        return Arrays.stream(strings)
                .filter(s -> s.startsWith("environment") && s.contains("X_FORWARDED"))
                .map(s -> s.replaceAll("environment=", ""))
                .map(s -> s.replaceAll("\"", ""))
                .map(s -> s.split(","))
                .flatMap(Arrays::stream)
                .filter(d -> d.startsWith("X_FORWARDED_"))
                .map(d -> d.replaceFirst("X_FORWARDED_", ""))
                .collect(Collectors.joining(","));
    }
}
//END
