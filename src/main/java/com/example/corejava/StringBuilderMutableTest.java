package com.example.corejava;

public class StringBuilderMutableTest {

    public static void main(String[] args) {

        String s = "hello";
        StringBuilder sb = new StringBuilder(s);

        sb.deleteCharAt(4);

        System.out.println(sb);
    }
}
