package exercise;

import java.util.List;
import java.util.Arrays;

// BEGIN
public class App {

    public static long getCountOfFreeEmails(List<String> list) {
        long amount = list.stream()
                .filter(mail -> mail.contains("@gmail.com") || mail.contains("@yandex.ru") || mail.contains("@hotmail.com"))
                .count();
        return amount;
    }
}
// END
