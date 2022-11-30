package exercise;

import java.util.Arrays;
import java.util.List;

// BEGIN
public class App {

    private static final List<String> FREE_DOMAINS = Arrays.asList(
            "gmail.com", "yandex.ru", "hotmail.com");

    public static long getCountOfFreeEmails(List<String> list) {
        return list
                .stream()
                .map(email -> email.split("@")[1])
                .filter(FREE_DOMAINS::contains)
                .count();
    }
}
// END
