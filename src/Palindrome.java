import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/valid-palindrome/description/
//125. Valid Palindrome
//
//A phrase is a palindrome if, after converting all uppercase letters into Iowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
//
//Given a string s, return true ifit is a palindmme, or false otherwise.
//Example 1:
//Input: s — "A man, a plan, a canal: Panama"
//Output:
//true
//Explanation:
//"amanaplanacanalpanama" is a palindrome.
//Example 2:
//Input :
//s = " race a car"
//Output:
//false
//Explanation:
//' raceacar"
//is not a palindrome.
//Example 3:
//Input :
//Output:
//true
//Explanation:
//s
//Since an empty
//is an empty string
//after removing non—alphanumeric characters.
//string reads the same forward and backward, it is a palindrome.
public class Palindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome(" "));
    }

    static boolean isPalindrome(String s) {
        String letters = "qwertyuiopasdfghjklmnbvcxz0123456789";
        char[] lettersArray = letters.toCharArray();
        List array = new ArrayList<>();
        List reverseArray = new ArrayList<>();

        for (char value : s.toLowerCase().toCharArray()) {
            if (contains(lettersArray, value)) {
                array.add(value);
            }
        }

        for (int i = array.size() - 1; i >= 0; i--) {
            reverseArray.add(array.get(i));
        }

        return reverseArray.equals(array);
    }

    static boolean contains(char[] array, char c) {
        for (char value : array) {
            if (value == c)
                return true;
        }
        return false;
    }
}