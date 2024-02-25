import java.util.ArrayList;
import java.util.List;

public class Mobius {
    public static void main(String[] args) {

        System.out.println(allPrimes(25));
        System.out.println(mobius(9894));
    }
    static int mobius(long number) {
        List<Long> allPrimes = allPrimes(number);
        int count = 0;

        for (Long prime : allPrimes) {
            if (number % Math.pow(prime, 2) == 0)
                return 0;

            if (number % prime == 0)
                count++;
        }
        if (count > 0 && count % 2 == 0)
            return 1;

        return -1;
    }
    public static int mobius2(long n) {
        if (n == 1)
            return 1;

        int count = 0;
        for (long i = 2; i <= n; i++) {
            if (n % i == 0) {
                count++;
                n /= i;
                if (n % i == 0)
                    return 0;
            }
        }
        return (count % 2 == 0) ? 1 : -1;
    }

    static List<Long> allPrimes(long number) {
        List<Long> listPrimes = new ArrayList<>();

        for (int i = 2; i < number; i++) {
            if (isPrimeRecursively(i)) {
                listPrimes.add((long) i);
            }
        }
        return listPrimes;
    }

    static boolean isPrimeRecursively(long number, long divisor) {
        if (number == 2) return true;
        if (number <= 1) return false;

        if (divisor > Math.sqrt(number))
            return true;

        if (number % divisor == 0)
            return false;

        return isPrimeRecursively(number, divisor + 1);
    }

    static boolean isPrimeRecursively(long number) {
        return isPrimeRecursively(number, 2);
    }

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}