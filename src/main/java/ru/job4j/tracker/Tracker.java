package ru.job4j.tracker;

import java.util.ArrayList;

public class Tracker {
    private final ArrayList<Item> items = new ArrayList<>();
    private int ids = 1;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (Item item : items) {
            if (item.getId() == id) {
                rsl = items.indexOf(item);
            }
        }
        return rsl;
    }

    public ArrayList<Item> findAll() {
        return new ArrayList<>(items);
    }

    public ArrayList<Item> findByName(String key) {
        ArrayList<Item> arrayListWithEqualNames = new ArrayList<>();
        for (Item item: items) {
            if (item.getName().equals(key)) {
                arrayListWithEqualNames.add(item);
            }
        }
        return arrayListWithEqualNames;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            item.setId(id);
            items.set(index, item);
        }
        return rsl;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            items.remove(index);
        }
        return rsl;
    }
}

