package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store {

    private Connection cn;

    public SqlTracker() {
        init();
    }

    public SqlTracker(Connection cn) {
        this.cn = cn;
    }

    private void init() {
        try (InputStream in = SqlTracker.class.getClassLoader().
                getResourceAsStream("db/liquibase.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            cn = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void close() throws SQLException {
        if (cn != null) {
            cn.close();
        }
    }

    @Override
    public Item add(Item item) {
        List<Item> itemsList = new ArrayList<>();
        try (PreparedStatement ps = cn.prepareStatement(
                "INSERT INTO items (name, created) values (?, ?) RETURNING *;")) {
            ps.setString(1, item.getName());
            ps.setTimestamp(2, Timestamp.valueOf(item.getDate()));
            itemsList = getItemsList(ps.executeQuery());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return itemsList.isEmpty() ? null : itemsList.get(0);
    }

    @Override
    public boolean replace(int id, Item item) {
        boolean rsl = findById(id) != null;
        if (rsl) {
            try (PreparedStatement ps = cn.prepareStatement(
                    "UPDATE items SET (name, created) = (?, ?) WHERE id = ?;")) {
                ps.setString(1, item.getName());
                ps.setTimestamp(2, Timestamp.valueOf(item.getDate()));
                ps.setInt(3, id);
                ps.execute();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return rsl;
    }

    @Override
    public void delete(int id) {
        try (PreparedStatement ps = cn.prepareStatement(
                "DELETE FROM items WHERE id = ?;")) {
            ps.setInt(1, id);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Item> findAll() {
        List<Item> itemsList = new ArrayList<>();
        try (PreparedStatement ps = cn.prepareStatement(
                "SELECT * FROM items;")) {
            itemsList = getItemsList(ps.executeQuery());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return itemsList;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> itemsList = new ArrayList<>();
        try (PreparedStatement ps = cn.prepareStatement(
                "SELECT * FROM items WHERE name = ?;")) {
            ps.setString(1, key);
            itemsList = getItemsList(ps.executeQuery());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return itemsList;
    }

    @Override
    public Item findById(int id) {
        List<Item> itemsList = new ArrayList<>();
        try (PreparedStatement ps = cn.prepareStatement(
                "SELECT * FROM items WHERE id = ?;")) {
            ps.setInt(1, id);
            itemsList = getItemsList(ps.executeQuery());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return itemsList.isEmpty() ? null : itemsList.get(0);
    }

    private static List<Item> getItemsList(ResultSet returning) throws SQLException {
        List<Item> itemsList = new ArrayList<>();
        while (returning.next()) {
            itemsList.add(new Item(returning.getInt(1),
                    returning.getString(2),
                    returning.getTimestamp(3).toLocalDateTime()));
        } return itemsList;
    }
}

