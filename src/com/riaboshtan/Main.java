package com.riaboshtan;

import com.riaboshtan.list.ArrayListTest;
import com.riaboshtan.list.LinkedListTest;
import com.riaboshtan.list.ListsTests;
import com.riaboshtan.list.VectorTest;
import com.riaboshtan.report.FileReport;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Vector;

public class Main {

    public static void main(String[] args) {

        for(int c = 0; c < 5; c++) {
            final FileReport addReport = new FileReport(
                    Arrays.asList(ArrayList.class.getName(), LinkedList.class.getName(), Vector.class.getName()),
                    "AddReport" + c);
            final FileReport addInnerReport = new FileReport(
                    Arrays.asList(ArrayList.class.getName(), LinkedList.class.getName(), Vector.class.getName()),
                    "AddInnerReport" + c);
            for (int i = 0; i <= 1_000_000; i += 10_000) {
                final ListsTests arrayList = new ArrayListTest();
                final ListsTests linkedList = new LinkedListTest();
                final ListsTests vector = new VectorTest();
                addReport.print(i, Arrays.asList(arrayList.addToList(i), linkedList.addToList(i), vector.addToList(i)));
                addInnerReport.print(i, Arrays.asList(arrayList.addIntoList(i), linkedList.addIntoList(i), vector.addIntoList(i)));
            }
        }
    }
}
