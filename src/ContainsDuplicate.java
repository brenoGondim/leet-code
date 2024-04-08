import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContainsDuplicate {
    public static void main(String[] args) {
        System.out.println(containsDuplicatePrimary(new int[]{1, 2, 3, 1}));
    }

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> numsCompare = new HashSet<>();

        for (int num: nums) {
            if (numsCompare.contains(num)) {
                return true;
            }
            numsCompare.add(num);
        }
        return false;
    }

    public static boolean containsDuplicatePrimary(int[] nums) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
                if (count > 1) {
                    return true;
                }
            }
            count = 0;
        }
        return false;
    } //Time Limit Exceeded
}