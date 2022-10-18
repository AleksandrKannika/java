package homework.hw1;

public class homework1 {

    public static void main(String[] arg) {
        int[] arr = { 3, 7, 6, 4, 5, 2, 1, 8, 3, 7, 6, 9, 4, 5, 7 };
        int size = arr.length;

        int num = 6;
        System.out.println(trianglenum(num));
        sort(arr, size);
        printArr(arr);
    }

    static int trianglenum(int x) {
        int res;
        res = ((x * (x + 1)) / 2);
        return res;
    }

    public static void sort(int[] a, int n) {

        pre(a, n);

        for (int i = n - 1; i >= 0; i--) {

            swap(a, i, 0);
            process(a, i, 0);
        }

    }

    static void pre(int[] a, int n) {
        for (int i = n / 2 - 1; i >= 0; i--)
            process(a, n, i);

    }

    static void process(int[] a, int h, int i) {
        int largest = i;
        int l = i * 2 + 1;
        int r = i * 2 + 2;
        if (l < h && a[largest] < a[l]) {
            largest = l;
        }
        if (r < h && a[largest] < a[r]) {
            largest = r;
        }
        if (largest != i) {
            swap(a, i, largest);
            process(a, h, largest);
        }
    }

    static void printArr(int[] a) {
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    static void swap(int[] a, int i1, int i2) {
        int temp = a[i1];
        a[i1] = a[i2];
        a[i2] = temp;
    }

}