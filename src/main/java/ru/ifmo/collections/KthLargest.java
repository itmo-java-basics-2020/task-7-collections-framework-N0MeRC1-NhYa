package ru.ifmo.collections;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Design a class to find the kth largest element in a stream. k is from 1 to numbers.length.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Constructor accepts an integer k and an integer array numbers, which contains initial elements from the stream.
 * For each call to the method KthLargest.add(), return the element representing the kth largest element in the stream.
 */
public class KthLargest {

    LinkedList nums;

    public KthLargest(int k, int[] numbers) {
        nums = new LinkedList();
        Arrays.sort(numbers);
        int j = numbers.length;
        for (int i = 0; i < k; i++){
            nums.add(numbers[--j]);
        }
    }

    public int add(int val) {
        int perfectPlace = 0;
        while (perfectPlace < nums.size() && (int)nums.get(perfectPlace) >= val) {
            perfectPlace++;
        }
        if (perfectPlace < nums.size()) {
            for (int i = nums.size() - 1; i >= Math.max(perfectPlace, 1); i--) {
                nums.set(i, nums.get(i - 1));
            }
            System.out.println("Adding " + val + " to place " + perfectPlace);
            nums.set(perfectPlace, val);
        }
        System.out.println();
        return (int)nums.getLast();
    }
}