package exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// BEGIN
public class App {
    public static boolean scrabble(String string, String word) {
        List<String> listOfStringValues = new ArrayList<>();
        List<String> listOfWordValues = new ArrayList<>();
        List<String> checkList = new ArrayList<>();
        for (int i = 0; i < string.length(); i ++)
            listOfStringValues.add(String.valueOf(string.toLowerCase().charAt(i)));
        for (int i = 0; i < word.length(); i ++)
            listOfWordValues.add(String.valueOf(word.toLowerCase().charAt(i)));
        Collections.sort(listOfStringValues);
        Collections.sort(listOfWordValues);
        for (int i = 0; i < listOfWordValues.size(); i++)
            for (int j = 0; j < listOfStringValues.size(); j++) {
                if (listOfWordValues.get(i).equals(listOfStringValues.get(j))) {
                    checkList.add(listOfWordValues.get(i));
                    listOfStringValues.remove(j);
                }
            }
        Collections.sort(checkList);
        return listOfWordValues.equals(checkList);
    }
}
//END
