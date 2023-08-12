package ru.job4j.collection;

import java.util.*;

public class Departments {

    public static List<String> fillGaps(List<String> deps) {
        Set<String> output = new LinkedHashSet<>();
        for (String dep : deps) {
            StringBuilder buffer = new StringBuilder();
            String[] depSplitArray  = dep.split("/");
            for (String string : depSplitArray) {
                buffer.append(string);
                output.add(buffer.toString());
                buffer.append("/");
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
