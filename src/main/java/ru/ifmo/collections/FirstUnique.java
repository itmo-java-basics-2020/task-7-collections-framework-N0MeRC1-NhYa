package ru.ifmo.collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Design a class which contains integers and returns first unique integer (in order of addition).
 * FirstUniqueTest can be used as an example.
 */
public class FirstUnique {
    private Set<Integer> nums = new HashSet<>();

    private Set<Integer> unique = new LinkedHashSet<>();

    public FirstUnique(int[] numbers) {
        for (int i : numbers) {
            add(i);
        }
    }

    public int showFirstUnique() {
        if (!unique.isEmpty()) {
            return unique.iterator().next();
        } else
            return -1;
    }

    public void add(int value) {
        if (!nums.contains(value)) {
            nums.add(value);
            unique.add(value);
        } else {
            unique.remove(value);
        }
    }
}