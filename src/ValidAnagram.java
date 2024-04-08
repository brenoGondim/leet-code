import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ValidAnagram {
    public static void main(String[] args) {
        System.out.println(isAnagramBetter("anagram", "nagaram"));
    }

    public static boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> anagramCountS = new HashMap<>();
        HashMap<Character, Integer> anagramCountT = new HashMap<>();

        for (char c : s.toCharArray()) {
            Integer value = anagramCountS.getOrDefault(c, 0);
            if (value == 0)
                anagramCountS.put(c, 1);

            anagramCountS.put(c, value + 1);
        }
        for (char c : t.toCharArray()) {
            Integer value = anagramCountT.getOrDefault(c, 0);
            if (value == 0)
                anagramCountT.put(c, 1);

            anagramCountT.put(c, value + 1);
        }

        return anagramCountS.equals(anagramCountT);
    }

    public static boolean isAnagramBetter(String s, String t) {
        if (s.length() != t.length()) { return false; }
        char[] anagramS = s.toCharArray();
        char[] anagramT = t.toCharArray();

        Arrays.sort(anagramS);
        Arrays.sort(anagramT);

        return Arrays.equals(anagramS, anagramT);
    }
}