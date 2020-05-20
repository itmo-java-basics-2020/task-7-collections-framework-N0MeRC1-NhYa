package ru.ifmo.collections;

import java.util.*;

/**
 * Represents sorted set of unique values.
 * create() returns a SortedSet instance with natural ordering. (i.e. from smallest to largest in case of integer numbers)
 * from() is used to create a SortedSet instance with given Comparator.
 * Instances of a class can be created using only these two methods above.
 *
 * This class should not be abstract and should be capable of adding/removing single/multiple elements.
 * It has two more methods: getSorted() and getReversed() which return an array of set contents in forward and reverse order respectively.
 *
 * NB! This class must have only map(s) as an internal data structure(s).
 *
 * @param <T> set contents type
 */
public class SortedSet<T> extends AbstractSet<T> {
     private  Map<T, T> contents;

     public SortedSet(){
         contents = new TreeMap<T, T>();
    }

    public SortedSet(Comparator<T> comparator){
         contents = new TreeMap<T,T>(comparator);
    }

    @Override
    public Iterator<T> iterator() {
        return contents.keySet().iterator();
    }

    @Override
    public int size() {
        return contents.size();
    }
    @Override
    public boolean add(T t) {
        int temp = contents.size();
        contents.put(t, t);
        return temp != contents.size();
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        int temp = contents.size();
        for (T i : collection) {
            this.add(i);
        }
        return temp != contents.size();
    }

    @Override
    public boolean remove(Object obj) {
        return contents.remove(obj, obj);
    }
    @Override
    public boolean removeAll(Collection<?> col){
         int tmp = size();
         for (Object obj : col){
             this.remove(obj);
         }
         return tmp != size();
    }

    public static <T> SortedSet<T> create() {
        return new SortedSet();

    }

    public static <T> SortedSet<T> from(Comparator<T> comparator) {
        return new SortedSet(comparator);
    }

    public List getSorted() {
       return new ArrayList(contents.values());
    }

    public List getReversed() {
        List<T> rev = new ArrayList(contents.values());
        Collections.reverse(rev);
        return rev;
    }
}
