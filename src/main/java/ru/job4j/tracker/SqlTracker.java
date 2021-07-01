/*
класс будет подключаться к базе данных, создавать в ней записи, редактировать, читать и удалять.
 */
package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store{
    private Connection cn;
    public SqlTracker(Connection cn) {
        this.cn = cn;
    }
    public SqlTracker() {

    }

    @Override
    public void init() {
        try(InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            cn = DriverManager.getConnection(config.getProperty("url"), config.getProperty("username"), config.getProperty("password"));
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public Item add(Item item)  {
        try (PreparedStatement statement = cn.prepareStatement("insert into items(name, created) values(?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, item.getName());
            statement.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            statement.execute();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                while (generatedKeys.next()) {
                    item.setId(generatedKeys.getInt(1));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        boolean res = false;
        try (PreparedStatement statement = cn.prepareStatement("update items set name = ?, created = ? where id = ?")) {
            statement.setString(1, item.getName());
            statement.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            statement.setInt(3, id);
            res = statement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public boolean delete(int id) {
        boolean res = false;
        try (PreparedStatement statement = cn.prepareStatement("delete from items where id = ?")) {
            statement.setInt(1, id);
            res = statement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public List<Item> findAll() {
        List<Item> res = new ArrayList<>();
        try (PreparedStatement statement = cn.prepareStatement("select * from items")) {
            try(ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Item item = new Item(resultSet.getString("name"));
                    item.setId(resultSet.getInt("id"));
                    item.setCreated(resultSet.getTimestamp("created").toLocalDateTime());
                    res.add(item);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> res = new ArrayList<>();
        try (PreparedStatement statement = cn.prepareStatement("select * from items where name = ?")) {
            statement.setString(1, key);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Item item = new Item(resultSet.getString("name"));
                    item.setId(resultSet.getInt("id"));
                    item.setCreated(resultSet.getTimestamp("created").toLocalDateTime());
                    res.add(item);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public Item findById(int id) {
        Item item = new Item("");
        try (PreparedStatement statement = cn.prepareStatement("select * from items where id = ?")) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    item.setName(resultSet.getString("name"));
                    item.setId(resultSet.getInt("id"));
                    item.setCreated(resultSet.getTimestamp("created").toLocalDateTime());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public void close() throws Exception {
        if (cn != null) {
            cn.close();
        }
    }

    public static void main(String[] args) throws Exception {
        SqlTracker sqlTracker = new SqlTracker();
        sqlTracker.init();
        System.out.println("Добавление заявок:");
        sqlTracker.add(new Item("Настройка интернета"));
        sqlTracker.add(new Item("Подключение БД"));
        sqlTracker.add(new Item("Настройка оборудования"));
        System.out.println(sqlTracker.findAll());
        System.out.println("Редактирование заявок:");
        sqlTracker.replace(1, new Item("Перегрузка системы"));
        System.out.println(sqlTracker.findAll());
        System.out.println("Удаление заявок:");
        sqlTracker.delete(1);
        System.out.println(sqlTracker.findAll());
        System.out.println("Поиск по имени/id:");
        System.out.println(sqlTracker.findByName("Настройка оборудования"));
        System.out.println(sqlTracker.findById(3));
        sqlTracker.close();
    }
}
