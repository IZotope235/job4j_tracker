package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int rsl;
        String[] o1SplitArray = o1.split("/");
        String[] o2SplitArray = o2.split("/");
        rsl = o2SplitArray[0].compareTo(o1SplitArray[0]);
        return rsl != 0 ? rsl : o1.compareTo(o2);
    }
}
