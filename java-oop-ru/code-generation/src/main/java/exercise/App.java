package exercise;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Objects;

// BEGIN
public class App {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static void save(Path path, Car car) throws IOException {
        Objects.requireNonNull(path, "Path should not be null");
        Objects.requireNonNull(car, "Car should not be null");

        String json = mapper.writeValueAsString(car);
        Files.writeString(path, json);
    }

    public static Car extract(Path path) throws IOException {
        Objects.requireNonNull(path, "Path should not be null");

        String json = Files.readString(path);
        return mapper.readValue(json, Car.class);
    }
}
// END
