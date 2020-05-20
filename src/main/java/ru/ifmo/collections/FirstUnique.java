package ru.ifmo.collections;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Design a class which contains integers and returns first unique integer (in order of addition).
 * FirstUniqueTest can be used as an example.
 */
public class FirstUnique {

    private ArrayList<Integer> nums;
    public FirstUnique(int[] numbers) {
        nums = new ArrayList<Integer>();
        for (int i : numbers){
            nums.add(i);
        }
    }

    public int showFirstUnique() {
        int uniq = 0;
        int count = 0;
        for (int i : nums){
            for (int j : nums){
                if (j == i){
                    count++;
                }
            }
            if (count == 1){
                return i;
            }
            count = 0;
        }
        return -1;
    }

    public void add(int value) {
        nums.add(value);
    }
}
