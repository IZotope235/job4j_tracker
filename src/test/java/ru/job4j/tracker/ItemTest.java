package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ItemTest {

    @Test
    public void whenItemsSortByNaturalOrder()     {
        Item itemOne = new Item(1, "Bob");
        Item itemTwo = new Item(2, "Ann");
        Item itemThree = new Item(3, "Carl");
        List<Item> items = new ArrayList<>(List.of(
                itemThree,
                itemTwo,
                itemOne
        ));
        List<Item> expected = new ArrayList<>(List.of(
                itemTwo,
                itemOne,
                itemThree
        ));
        items.sort(new ItemAscByName());
        assertThat(items).isEqualTo(expected);
    }

    @Test
    public void whenItemsSortByReverseOrder()     {
        Item itemOne = new Item(3, "Carl");
        Item itemTwo = new Item(1, "Bob");
        Item itemThree = new Item(2, "Ann");
        List<Item> items = new ArrayList<>(List.of(
                itemThree,
                itemTwo,
                itemOne
        ));
        List<Item> expected = new ArrayList<>(List.of(
                itemOne,
                itemTwo,
                itemThree
        ));
        items.sort(new ItemDescByName());
        assertThat(items).isEqualTo(expected);
    }
}