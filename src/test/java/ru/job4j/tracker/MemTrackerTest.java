package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MemTrackerTest {
    @Test
    public void whenTestFindById() {
        try (Store tracker = new MemTracker()) {
            Item bug = new Item("Bug");
            Item item = tracker.add(bug);
            Item result = tracker.findById(item.getId());
            assertThat(result.getName()).isEqualTo(item.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenTestFindAll() {
        try (Store tracker = new MemTracker()) {
            Item first = new Item("First");
            Item second = new Item("Second");
            tracker.add(first);
            tracker.add(second);
            Item result = tracker.findAll().get(0);
            assertThat(result.getName()).isEqualTo(first.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenTestFindByNameCheckArrayLength() {
        try (Store tracker = new MemTracker()) {
            Item first = new Item("First");
            Item second = new Item("Second");
            tracker.add(first);
            tracker.add(second);
            tracker.add(new Item("First"));
            tracker.add(new Item("Second"));
            tracker.add(new Item("First"));
            List<Item> result = tracker.findByName(first.getName());
            assertThat(result.size()).isEqualTo(3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenTestFindByNameCheckSecondItemName() {
        try (Store tracker = new MemTracker()) {
            Item first = new Item("First");
            Item second = new Item("Second");
            tracker.add(first);
            tracker.add(second);
            tracker.add(new Item("First"));
            tracker.add(new Item("Second"));
            tracker.add(new Item("First"));
            List<Item> result = tracker.findByName(second.getName());
            assertThat(result.get(1).getName()).isEqualTo(second.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenReplaceItemIsSuccessful() {
        try (Store tracker = new MemTracker()) {
            Item item = new Item("Bug");
            tracker.add(item);
            int id = item.getId();
            Item updateItem = new Item("Bug with description");
            tracker.replace(id, updateItem);
            assertThat(tracker.findById(id).getName()).isEqualTo("Bug with description");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenReplaceItemIsNotSuccessful() {
        try (Store tracker = new MemTracker()) {
            Item item = new Item("Bug");
            tracker.add(item);
            Item updateItem = new Item("Bug with description");
            boolean result = tracker.replace(1000, updateItem);
            assertThat(tracker.findById(item.getId()).getName()).isEqualTo("Bug");
            assertThat(result).isFalse();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenDeleteItemIsSuccessful() {
        try (Store tracker = new MemTracker()) {
            Item item = new Item("Bug");
            tracker.add(item);
            int id = item.getId();
            tracker.delete(id);
            assertThat(tracker.findById(id)).isNull();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenDeleteItemIsNotSuccessful() {
        try (Store tracker = new MemTracker()) {
            Item item = new Item("Bug");
            tracker.add(item);
            tracker.delete(1000);
            assertThat(tracker.findById(item.getId()).getName()).isEqualTo("Bug");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}