package exercise;

import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
// BEGIN

// END


class FileKVTest {

    private static Path filepath = Paths.get("src/test/resources/file").toAbsolutePath().normalize();

    @BeforeEach
    public void beforeEach() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(new HashMap<String, String>());
        Files.writeString(filepath, content, StandardOpenOption.CREATE);
    }

    // BEGIN
    @Test
    public void testGetNonExistentKey() throws Exception {
        FileKV storage = new FileKV(filepath.toString(), new HashMap<String, String>());
        assertNull(storage.get("nonExistent", null));
        storage.close();
    }

    @Test
    public void testGetExistingKey() throws Exception {
        Map<String, String> data = new HashMap<>();
        data.put("key", "value");
        FileKV storage = new FileKV(filepath.toString(), data);
        assertEquals("value", storage.get("key", null));
        storage.close();
    }

    @Test
    public void testSetKey() throws Exception {
        FileKV storage = new FileKV(filepath.toString(), new HashMap<String, String>());
        storage.set("key", "value");
        assertEquals("value", storage.get("key", null));
        storage.close();
    }

    @Test
    public void testUnsetKey() throws Exception {
        Map<String, String> data = new HashMap<>();
        data.put("key", "value");
        FileKV storage = new FileKV(filepath.toString(), data);
        storage.unset("key");
        assertNull(storage.get("key", null));
        storage.close();
    }

    @Test
    public void testToMap() throws Exception {
        Map<String, String> data = new HashMap<>();
        data.put("key", "value");
        FileKV storage = new FileKV(filepath.toString(), data);
        Map<String, String> map = storage.toMap();
        assertEquals(data, map);
        map.put("newKey", "newValue");
        assertEquals(data, storage.toMap());
        storage.close();
    }

    @Test
    public void testSaveDataToFile() throws Exception {
        Map<String, String> data = new HashMap<>();
        data.put("key", "value");
        FileKV storage = new FileKV(filepath.toString(), data);
        storage.set("newKey", "newValue");
        storage.close();
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> savedData = mapper.readValue(filepath.toFile(), Map.class);
        assertEquals(data, savedData);
    }

    @Test
    public void testLoadDataFromFile() throws Exception {
        Map<String, String> data = new HashMap<>();
        data.put("key", "value");
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(data);
        Files.writeString(filepath, content, StandardOpenOption.CREATE);

        FileKV storage = new FileKV(filepath.toString(), new HashMap<String, String>());

        String fileContent = Files.readString(filepath);
        Map<String, String> loadedData = Utils.unserialize(fileContent);

        assertEquals(data, loadedData);
        storage.close();
    }
    // END
}
