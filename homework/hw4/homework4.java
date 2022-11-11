package homework.hw4;

import homework.hw2.homework2;

public class homework4 {
    public static void main(String[] var) {
        int[] s = { 2, 324, 34, 1, 5, 7, 8, 23, 64, 55 };
        
        System.out.println(printA(s));
        qSort(s, 0, s.length - 1);
        System.out.println(printA(s));
    }

    static void qSort(int[] arr, int from, int to) {
        if (from < to) {
            int comparepoint = division(arr, from, to);
            
            qSort(arr, from, comparepoint - 1);
            qSort(arr, comparepoint, to);
        }
    }

    static int division(int[] arr, int from, int to) {
        homework2 x = new homework2();

        int l = from;
        int r = to;
        int compare = arr[(int) (Math.random() * to)];
        while (l <= r) {
            while (arr[l] < compare)
                l++;
            
            while (arr[r] > compare)
                r--;
            
            if (l <= r) {
                x.swap(arr, r, l);
                l++;
                r--;
            }

        }
        return l;
    }

    static String printA(int[] a) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            sb.append(a[i] + "\t");
        }
        return sb.toString();
    }

}
