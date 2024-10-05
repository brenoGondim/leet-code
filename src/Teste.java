import java.util.*;

public class Teste {
    public static void main(String[] args) {

        //System.out.println(isAnagram("anagram", "nagaram"));
//        System.out.println(getHash("anagram"));
        String vehicles = "Car,Jeep, Wagon   Scooter        Truck, Van";
        List<String> result = new ArrayList<>(List.of(vehicles.split(",")));
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5));

        // Using stream() - sequential processing
//        System.out.println("Sequential Stream:");
//        numbers
//                .forEach(num -> {
//                    System.out.println("Processing " + num + " on thread " + Thread.currentThread().getName());
//                });

        // Using parallelStream() - parallel processing
        System.out.println("\nParallel Stream:");
        numbers.parallelStream()
                .forEach(num -> {
                    System.out.println("Processing " + num + " on thread " + Thread.currentThread().getName());
                });
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