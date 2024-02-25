import java.util.ArrayList;
import java.util.List;

public class TwoSum {
    public static void main(String[] args) {
        System.out.println("hello");
    }
    public static int[] twoSum(int[] nums, int target) {
        int targetSum = 0;
        List<Integer> twoNum = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            twoNum.add(i);
            for (int j = 0; j < nums.length; j++) {
                int numI = nums[i];
                int numJ = nums[j];
                if (i != j) {
                    targetSum = numI + numJ;
                    if (targetSum == target) {
                        twoNum.add(j);
                        break;
                    }
                }
            }
            if (twoNum.size() == 2) break;
            twoNum.remove(0);
        }
        return twoNum.stream().mapToInt(Integer::intValue).toArray();
    }
}