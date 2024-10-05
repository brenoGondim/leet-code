import java.util.*;

//O(n log n) must be less, not accepted
public class TopKFrequentElements {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent(new int[]{1,1,1,1,1,1,2,2,3}, 2)));
    }

    static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencies = new HashMap<>();
        List<Integer> numsList = Arrays.asList(Arrays.stream(nums).boxed().toArray(Integer[]::new));

        for (int num : nums) {
            frequencies.put(num, Collections.frequency(numsList, num));
        }
        List<Integer> keys = new ArrayList<>(frequencies.keySet().stream().toList());
        if (keys.size() <= 1) return new int[]{keys.get(0)};

        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(frequencies.entrySet());
        entries.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = entries.get(i).getKey();
        }

        return result;
    }
}