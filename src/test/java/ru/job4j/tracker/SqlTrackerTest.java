package ru.job4j.tracker;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import static org.assertj.core.api.Assertions.*;

public class SqlTrackerTest {

    private static Connection connection;

    @BeforeAll
    public static void initConnection() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("db/liquibase_test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterAll
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @AfterEach
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("TRUNCATE TABLE items RESTART IDENTITY;")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId())).isEqualTo(item);
    }

    @Test
    public void whenReplace() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        Item itemNew = new Item("newItem");
        tracker.add(item);
        Item expected = new Item(item.getId(), itemNew.getName(), itemNew.getDate());
        assertThat(tracker.replace(item.getId(), itemNew)).isTrue();
        assertThat(tracker.findById(item.getId())).isEqualTo(expected);
    }

    @Test
    public void whenDelete() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId())).isEqualTo(item);
        tracker.delete(item.getId());
        assertThat(tracker.findById(item.getId())).isNull();
    }

    @Test
    public void whenDeleteOneThenOtherItemsNotDelete() {
        SqlTracker tracker = new SqlTracker(connection);
        Item itemOne = new Item("itemOne");
        Item itemTwo = new Item("itemTwo");
        Item itemThree = new Item("itemThree");
        tracker.add(itemOne);
        tracker.add(itemTwo);
        tracker.add(itemThree);
        List<Item> expected = List.of(itemOne, itemThree);
        tracker.delete(itemTwo.getId());
        assertThat(tracker.findAll()).isEqualTo(expected);
    }

    @Test
    public void whenFindAll() {
        SqlTracker tracker = new SqlTracker(connection);
        Item itemOne = new Item("itemOne");
        Item itemTwo = new Item("itemTwo");
        Item itemThree = new Item("itemThree");
        tracker.add(itemOne);
        tracker.add(itemTwo);
        tracker.add(itemThree);
        List<Item> expected = List.of(itemOne, itemTwo, itemThree);
        assertThat(tracker.findAll()).isEqualTo(expected);
    }

    @Test
    public void whenFindByName() {
        SqlTracker tracker = new SqlTracker(connection);
        Item itemOne = new Item("itemOne");
        Item itemTwo = new Item("itemTwo");
        Item itemThree = new Item("itemOne");
        tracker.add(itemOne);
        tracker.add(itemTwo);
        tracker.add(itemThree);
        List<Item> expected = List.of(itemOne, itemThree);
        assertThat(tracker.findByName("itemOne")).isEqualTo(expected);
    }

    @Test
    public void whenFindById() {
        SqlTracker tracker = new SqlTracker(connection);
        Item itemOne = new Item("itemOne");
        Item itemTwo = new Item("itemTwo");
        Item itemThree = new Item("itemThree");
        tracker.add(itemOne);
        tracker.add(itemTwo);
        tracker.add(itemThree);
        assertThat(tracker.findById(itemTwo.getId())).isEqualTo(itemTwo);
    }
}
