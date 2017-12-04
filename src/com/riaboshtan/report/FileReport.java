package com.riaboshtan.report;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.List;
import java.util.Objects;

public class FileReport {

    private PrintStream printStream;

    public FileReport(List<String> testClasses, String fileName) {

        try {
            printStream = new PrintStream(fileName +".csv");
            printHeaders(testClasses);
        } catch (FileNotFoundException ignored) {
        }
    }

    private void printHeaders(List<String> testClasses) {
        StringBuilder msg = new StringBuilder();
        for (String testClass : testClasses) {
            msg.append("items").append(";").append(testClass);
        }
        printStream.println(msg.toString());
    }

    public void print(int listSize, List<Long> times) {
        if (Objects.nonNull(printStream)) {
            StringBuilder msg = new StringBuilder(String.valueOf(listSize));
            for (Long time : times) {
                msg.append(";").append(time);
            }
            printStream.println(msg.toString());
        }
    }
}
