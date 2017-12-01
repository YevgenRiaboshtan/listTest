package com.riaboshtan.list;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

abstract class ListsTest {

    private final List<Long> listToAdding;
    private final List<Long> listToInnerAdding;

    ListsTest(List<Long> listToAdding, List<Long> listToInnerAdding) {
        Objects.requireNonNull(listToAdding);
        Objects.requireNonNull(listToInnerAdding);
        this.listToAdding = listToAdding;
        this.listToInnerAdding = listToInnerAdding;
    }

    public void runAdding(int items) {
        addToList(items);
        addIntoList(items);
    }

    private void addToList(int items) {
        final long start = System.currentTimeMillis();
        final Long newItem = 1L;
        for (int i = 0; i < items; i++) {
            listToAdding.add(newItem);
        }
        final long stop = System.currentTimeMillis();
        System.out.println(listToAdding.getClass() + " items: " + listToAdding.size() + "; Adding: " + (stop - start) + "ms");
    }

    private void addIntoList(int items) {
        final long start = System.currentTimeMillis();
        final Long newItem = 1L;
        for (int i = 0; i < items; i++) {
            listToInnerAdding.add(ThreadLocalRandom.current().nextInt(i == 0 ? 1 : i), newItem);
        }
        final long stop = System.currentTimeMillis();
        System.out.println(listToInnerAdding.getClass() + " items: " + listToInnerAdding.size() + "; Inner adding: " + (stop - start) + "ms");
    }
}
