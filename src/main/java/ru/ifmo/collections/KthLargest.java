package ru.ifmo.collections;

import java.util.PriorityQueue;

/**
 * Design a class to find the kth largest element in a stream. k is from 1 to numbers.length.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * <p>
 * Constructor accepts an integer k and an integer array numbers, which contains initial elements from the stream.
 * For each call to the method KthLargest.add(), return the element representing the kth largest element in the stream.
 */
public class KthLargest {

    private PriorityQueue<Integer> KthMaxElements = new PriorityQueue<Integer>();

    private final Integer kth;

    public KthLargest(int k, int[] numbers) {
        kth = k;
        for (int i : numbers) {
            add(i);
        }
    }

    public int add(int val) {
        KthMaxElements.add(val);
        if (KthMaxElements.size() > kth) {
            KthMaxElements.remove();
        }
        return KthMaxElements.iterator().next();
    }
}