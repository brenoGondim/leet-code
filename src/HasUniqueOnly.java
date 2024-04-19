import java.util.*;

public class HasUniqueOnly {
    public static void main(String[] args) {

        System.out.println(hasUniqueOnly("ABCDEF")); //true
        System.out.println(hasUniqueOnly("ABCDEB")); //false
        System.out.println(hasUniqueOnly("ABCDEb")); //true
        System.out.println(hasUniqueOnly("/BCDEF")); // true
        System.out.println(hasUniqueOnly("/BCDE/")); // false
    }


    static boolean hasUniqueOnly(String str) {
        if (str.length() > 256) return false;
        List<Character> list = new ArrayList<>();
        Set<Character> set = new HashSet<>();

        for (char c : str.toCharArray()) {
            list.add(c);
            set.add(c);
        }

        return list.size() == set.size();
    }
}