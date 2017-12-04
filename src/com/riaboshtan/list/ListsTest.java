package com.riaboshtan.list;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

abstract class ListsTest implements ListsTests {

    private final List<Long> listToAdding;
    private final List<Long> listToInnerAdding;

    ListsTest(List<Long> listToAdding, List<Long> listToInnerAdding) {
        Objects.requireNonNull(listToAdding);
        Objects.requireNonNull(listToInnerAdding);
        this.listToAdding = listToAdding;
        this.listToInnerAdding = listToInnerAdding;
    }

    @Override
    public long addToList(int items) {
        final long start = System.currentTimeMillis();
        final Long newItem = 1L;
        for (int i = 0; i < items; i++) {
            listToAdding.add(newItem);
        }
        return System.currentTimeMillis() - start;
    }

    @Override
    public long addIntoList(int items) {
        final long start = System.currentTimeMillis();
        final Long newItem = 1L;
        for (int i = 0; i < items; i++) {
            listToInnerAdding.add(ThreadLocalRandom.current().nextInt(i == 0 ? 1 : i), newItem);
        }
        return System.currentTimeMillis() - start;
    }
}
