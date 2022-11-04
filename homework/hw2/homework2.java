package homework.hw2;

public class homework2 {
    public static void main(String[] arg) {
        int[] arr = { 3, 7, 6, 4, 5, 2, 1, 8, 3, 7, 6, 9, 4, 5, 7 };
        int size = arr.length;
        insertionSort(arr, size);
        printarr(arr);

        int height = 6; // высота башни
        int start = 1; // шпиль с которого берем диск
        int stop = 3; // шпиль на который кладем диск
        hanoTower(height, start, stop);
        
        }

    static void insertionSort(int[] a, int n) {
        int i = 1;
        while (i < n) {
            int j = i;
            while (j > 0 && a[j - 1] > a[j]) {
                swap(a, j, j - 1);
                j--;
            }
            i++;
        }
    }

    
    static void swap(int[] a, int i1, int i2) {
        int temp = a[i1];
        a[i1] = a[i2];
        a[i2] = temp;
    }
    
    
    static void printarr(int[] a){
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "\t");
        }
    }


    static void hanoTower(int a, int b, int c){
        if (a == 1)
            System.out.print("Переставьте диск " + a + " с " + b + " шпиля на " + c + " шпиль \n");
        else{
            int temp = 6 - b - c;
            hanoTower(a - 1, b, temp);
            System.out.print("Переставьте диск " + a + " с " + b + " шпиля на " + c + " шпиль \n");
            hanoTower(a - 1, temp, c);
        }
    }


}