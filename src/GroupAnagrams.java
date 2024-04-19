
import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagrams {
    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"tea","","eat","","tea",""}));
    }
    static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> totalList = new ArrayList<>();

        for (int i = 0; i < strs.length; i++) {
            if (strs[i] != null) {
                int strsSize = strs[i].length();
                char[] orderedChar1 = strs[i].toCharArray();
                List<String> currentList = new ArrayList<>();

                for (int j = 0; j < strs.length; j++) {
                    if (strs[j] != null) {
                        if (strsSize != strs[j].length()) continue;
                        String unorderedStr2 = strs[j];
                        char[] orderedChar2 = strs[j].toCharArray();
                        Arrays.sort(orderedChar1);
                        Arrays.sort(orderedChar2);

                        if (Arrays.equals(orderedChar1, orderedChar2)) {
                            currentList.add(unorderedStr2);
                            strs[j] = null;
                        }
                    }
                }

                totalList.add(currentList);
            }
        }
        return totalList;
    }
}