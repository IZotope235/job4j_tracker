package ru.job4j.collection;

import java.util.*;

public class Departments {

    public static List<String> fillGaps(List<String> deps) {
        Set<String> output = new LinkedHashSet<>();
        for (String dep : deps) {
            StringBuilder buffer = new StringBuilder();
            String[] depSplitArray  = dep.split("/");
            for (int i = 0; i < depSplitArray.length; i++) {
                if (i > 0) {
                    buffer.append("/");
                }
                buffer.append(depSplitArray[i]);
                output.add(buffer.toString());
            }
        }
        return new ArrayList<>(output);
    }

    public static void sortAsc(List<String> orgs) {
        Collections.sort(orgs);
    }

    public static void sortDesc(List<String> orgs) {
        Comparator<String> descCom = new DepDescComp();
        orgs.sort(descCom);
    }
}
