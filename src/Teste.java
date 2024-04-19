import java.util.*;

public class Teste {
    public static void main(String[] args) {

        //System.out.println(isAnagram("anagram", "nagaram"));
//        System.out.println(getHash("anagram"));
        StringBuilder sb = new StringBuilder();
        sb.append("Hello");
        sb.append(" ");
        sb.append("World");
        String result = sb.toString();
        System.out.println("SB: "+sb);
    }


    public static char[] isAnagram(String s, String t) {
        char[] ordered = s.toCharArray();
        char[] unordered = s.toCharArray();

        Arrays.sort(ordered);
        return unordered;
    }

    static double getHash(String str) {
        double[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 100, 121};
        double hash = 1d;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            double pr = prime[c - 'a'];
            hash = hash * pr;
        }
        return hash;
    }
}