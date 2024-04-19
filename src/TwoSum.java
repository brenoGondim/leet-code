import util.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoSum {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        int[] sums = Util.getListOf(100000000);
        System.out.println(Arrays.toString(twoSum(new int[]{1, 5, 8, 1, 2}, 13)));

        long end = System.currentTimeMillis();
        System.out.println("Tempo: "+(end - start));
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