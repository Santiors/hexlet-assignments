package exercise;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class AppTest {

    @Test
    void testTake() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        int numberOfElements = 3;
        List<Integer> checkList = new ArrayList<>();
        for (int i = 0; i < numberOfElements; i++) {
            checkList.add(numbers.get(i));
        }
        assertThat(App.take(numbers, numberOfElements)).isEqualTo(checkList);
    }

    @Test
    void testTakeWithEdgePositionsStart() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        int numberOfElements = 1;
        List<Integer> checkList = new ArrayList<>();
        for (int i = 0; i < numberOfElements; i++) {
            checkList.add(numbers.get(i));
        }
        assertThat(App.take(numbers, numberOfElements)).isEqualTo(checkList);
    }

    @Test
    void testTakeWithEdgePositionsEnd() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        int numberOfElements = 5;
        List<Integer> checkList = new ArrayList<>();
        for (int i = 0; i < numberOfElements; i++) {
            checkList.add(numbers.get(i));
        }
        assertThat(App.take(numbers, numberOfElements)).isEqualTo(checkList);
    }

    @Test
    void testTakeOutOfLength() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        int numberOfElements = 6;
        List<Integer> checkList = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            checkList.add(numbers.get(i));
        }
        assertThat(App.take(numbers, numberOfElements)).isEqualTo(checkList);
    }
}
