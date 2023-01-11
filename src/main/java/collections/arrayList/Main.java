package collections.arrayList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> test = new MyArrayList<>();
        test.add(1);
        test.add(56);
        test.add(3);
        test.add(0);

        int[] array = new int[]{1,2,3,4,5};
        test.sort(array);

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);

        }
    }
}
