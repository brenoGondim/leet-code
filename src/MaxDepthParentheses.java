import java.util.Stack;

public class MaxDepthParentheses {
    public static void main(String[] args) {
        System.out.println(maxDepth("(1+(2*3)+((8)/4))+1"));
        System.out.println(maxDepth("(1)+((2))+(((3)))"));
        System.out.println(maxDepth("(1)"));
    }
    public static int maxDepth(String s) {
        int count = 0;
        int biggerCount = 0;

        for (char c : s.toCharArray()) {
            if (c == '(')
                count++;
            if (c == ')')
                count--;

            biggerCount = Math.max(biggerCount, count);
        }
        return biggerCount;
    }
}
