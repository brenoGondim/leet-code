package util;

import java.util.ArrayList;
import java.util.List;

public class Util {
    public static int[] getListOf(int target) {
        List<Integer> list = new ArrayList<>();
        int[] array = new int[target];

        for (int i = 0; i < target; i++) {
            list.add(i*2);
            array[i] = list.get(i);
        }
        return array;
    }
}
