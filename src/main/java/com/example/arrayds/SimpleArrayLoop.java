package com.example.arrayds;

public class SimpleArrayLoop {
    public static void main(String[] args) {
        int[] arr = {5, 4, 1, 2};

        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + "--- > ");
            for (int j = i + 1; j < arr.length; j++) {
                System.out.print("(" + arr[i] + " , " + arr[j] + ")");
            }
            System.out.println();
        }
    }
}
