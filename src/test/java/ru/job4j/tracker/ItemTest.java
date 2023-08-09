package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ItemTest {

    @Test
    public void whenItemsSortByNaturalOrder()     {
        List<Item> items = new ArrayList<>(List.of(
                new Item(3, "Carl"),
                new Item(1, "Bob"),
                new Item(2, "Ann")
        ));
        List<Item> expected = new ArrayList<>(List.of(
                new Item(2, "Ann"),
                new Item(1, "Bob"),
                new Item(3, "Carl")
        ));
        Collections.sort(items, new ItemAscByName());
        assertThat(items).isEqualTo(expected);
    }

    @Test
    public void whenItemsSortByReverseOrder()     {
        List<Item> items = new ArrayList<>(List.of(
                new Item(3, "Ann"),
                new Item(2, "Bob"),
                new Item(1, "Carl")
        ));
        List<Item> expected = new ArrayList<>(List.of(
                new Item(1, "Carl"),
                new Item(2, "Bob"),
                new Item(3, "Ann")
        ));
        Collections.sort(items, new ItemDescByName());
        assertThat(items).isEqualTo(expected);
    }
}