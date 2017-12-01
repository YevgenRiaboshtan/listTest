package com.riaboshtan;

import com.riaboshtan.list.ArrayListTest;
import com.riaboshtan.list.LinkedListTest;
import com.riaboshtan.list.VectorTest;

public class Main {

    public static void main(String[] args) {
        for (int i = 0; i < Integer.MAX_VALUE; i+= 10000) {
            new ArrayListTest().runAdding(i);
            new LinkedListTest().runAdding(i);
            new VectorTest().runAdding(i);
            System.out.println();
        }
    }
}
