import java.util.*;

public class TopKFrequentElements {
    public static void main(String[] args) {

        //System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(Arrays.toString(topKFrequent(new int[]{1,1,1,1,1,1,2,2,3}, 2)));
    }

    static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencies = new HashMap<>();
        List<Integer> numsList = Arrays.asList(Arrays.stream(nums).boxed().toArray(Integer[]::new));
        Set<Integer> biggerValues = new HashSet<>();

        for (int num : nums) {
            frequencies.put(num, Collections.frequency(numsList, num));
        }
        List<Integer> keys = new ArrayList<>(frequencies.keySet().stream().toList());
        if (keys.size() <= 1) return new int[]{keys.get(0)};

        for (int i = 0; i < k; i++) {
            int bigger = 0;
            int position = 0;

            for (int j = 0; j < keys.size(); j++) {
                int key = keys.get(j);
                int value = frequencies.get(key);
                if (value > bigger) {
                    bigger = value;
                    position = j;
                }
            }
            biggerValues.add(keys.get(position));
            keys.remove(position);
        }

        return biggerValues.stream().mapToInt(Integer::intValue).toArray();
    }
}