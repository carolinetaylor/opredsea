package com.mianjing;

/**
 * Created by Tian on 2017/4/6.
 */
public class SolutionSort1 {
    public int[] countingSort(int[] A) {
        int[] B = new int[A.length];
        int max = 10;
        helper(A, B, max);
        return B;
    }

    private void printArray(String title, int[] arr) {
        System.out.print(title + ": ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }

    private void helper(int[] A, int[] B, int k) {
        int[] C = new int[k];
        printArray("A", A);
        //count
        for (int i = 0; i < A.length; i++) {
            int a = A[i];
            C[a]++;
        }
        printArray("C", C);

        //count sum, how many numbers infront of this number
        for (int i = 1; i < k; i++) {
            C[i] += C[i - 1];
        }
        printArray("C", C);

        //collection from back to front to make it as a stable sort
        for (int i = A.length - 1; i >= 0; i--) {
            int a = A[i];
            B[--C[a]] = a;
            //C[a]--;
        }
        printArray("C", C);
        printArray("B", B);
    }
}
