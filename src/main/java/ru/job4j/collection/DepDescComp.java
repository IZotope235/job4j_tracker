package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int rsl;
        String[] o1SplitArray = o1.split("/");
        String[] o2SplitArray = o2.split("/");
        rsl = o2SplitArray[0].compareTo(o1SplitArray[0]);
        if (rsl == 0) {
            StringBuilder o1Buffer = new StringBuilder();
            StringBuilder o2Buffer = new StringBuilder();
            for (int i = 1; i < o1SplitArray.length; i++) {
                o1Buffer.append("/").append(o1SplitArray[i]);
            }
            for (int i = 1; i < o2SplitArray.length; i++) {
                o2Buffer.append("/").append(o2SplitArray[i]);
            }
            rsl = o1Buffer.toString().compareTo(o2Buffer.toString());
        }
        return rsl;
    }
}
