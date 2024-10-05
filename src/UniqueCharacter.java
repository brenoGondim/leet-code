import java.util.*;

//CoderByte challenge 'unique-character'
class UniqueCharacter {
    public static void main (String[] args) {
        System.out.println(uniqueCharacter("3aabacbebebe"));
    }

    static String uniqueCharacter(String str) {
        int k = Character.getNumericValue(str.toCharArray()[0]);
        List<String> substrings = new ArrayList<>();
        subRec(substrings, k, str.substring(1));

        return challengeToken(
                substrings.stream()
                .max(Comparator.comparingInt(String::length))
                .orElse(null)
        );
    }

    static void subRec(List<String> substrings, int k, String substr) {
        Set<Character> set = new HashSet<>();
        for (char c : substr.toCharArray()) {
            set.add(c);
        }
        if (set.size() == k) {
            substrings.add(substr);
        }

        if (substr.length() > 0) {
            substr = subLogic(substrings, k, substr);
            subRec(substrings, k, substr);
        }

        System.out.println("Substrings: " + substrings);
    }

    private static String subLogic(List<String> substrings, int k, String substr) {
        Set<Character> set = new HashSet<>();
        char[] strChar = substr.toCharArray();
        int index = 0;

        for (int i = 0; i < substr.length(); i++) {
            char current = strChar[i];
            if (set.size() == k) {
                if (!set.contains(current)) {
                    substrings.add(substr.substring(0, i));
                    return substr.substring(index);
                }
            }
            if (set.size() < k) {
                if (set.size() == 1) {
                    index = i;
                }
                set.add(current);
            }
        }
        return "";
    }
    private static String challengeToken(String result) {
        String challengeToken = "9t3mnbiyc2";

        result = result.replaceAll("(?i)["+ challengeToken + "]", "");
        if (result.isEmpty()) {
            result = "EMPTY";
        }
        return result;
    }

}