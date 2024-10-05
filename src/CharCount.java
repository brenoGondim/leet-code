import java.util.HashMap;
import java.util.Map;

//Write a method that takes a String as a parameter and returns the number of occurrences of each character in a string
//example: for input "hello" we expect to see the following output:
//h 1
//e 1
//l 2
//o 1

public class CharCount
{
    public static void main(String[] args) {
        System.out.println(charCount("Hello"));
    }

    public static Map<Character, Integer> charCount(String str) {
        char[] strChar = str.toCharArray();
        Map<Character, Integer> charMap = new HashMap<>();

        for (int i = 0; i < strChar.length; i++) {
            Integer valueI = charMap.get(strChar[i]);
            charMap.putIfAbsent(strChar[i], 1);

            for (int j = 0; j < strChar.length; j++) {
                if (charMap.get(strChar[i]) != null && valueI != null) {
                    charMap.put(strChar[i], valueI + 1);
                }
            }
        }

        return charMap;
    }
}