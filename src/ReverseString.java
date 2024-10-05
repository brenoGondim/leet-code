import java.util.*;

//    Write a method that takes a String as a parameter and returns the exact string in reverse. Do not use predefined reverse functions.
//    example: for input "hello" we expect "olleh" to be returned

public class ReverseString
{
    public static void main(String[] args) {
        System.out.println(reverse1("Welcome"));
    }
    public static String reverse1(String str) {
        char[] strChar = str.toCharArray();
        char[] strReversed = new char[strChar.length];
        int count = 0;

        for (int j = strChar.length - 1; j >= 0 ; j--) {
            strReversed[count] = strChar[j];
            count++;
        }

        return new String(strReversed);
    }
}
