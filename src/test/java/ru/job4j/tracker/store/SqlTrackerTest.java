package ru.job4j.tracker.store;

import org.junit.*;
import ru.job4j.tracker.SqlTracker;
import ru.job4j.tracker.Item;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class SqlTrackerTest {

    static Connection connection;

    @BeforeClass
    public static void initConnection() {
        try (InputStream in = SqlTrackerTest.class.getClassLoader().getResourceAsStream("test.properties")) {
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

    @AfterClass
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @After
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item", LocalDateTime.of(2021, Month.JULY, 02, 20, 31, 59));
        tracker.add(item);
        assertThat(tracker.findById(item.getId()), is(item));
    }

    @Test
    public void whenReplaceItem() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item", LocalDateTime.of(2021, Month.JULY, 02, 20, 31, 59));
        tracker.add(item);
        Item newItem = new Item("newItem", LocalDateTime.of(2021, Month.JULY, 02, 21, 31, 59));
        tracker.replace(item.getId(), newItem);
        newItem.setId(item.getId());
        assertThat(tracker.findById(item.getId()), is(newItem));
    }

    @Test
    public void whenDeleteItem() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item", LocalDateTime.of(2021, Month.JULY, 02, 20, 31, 59));
        tracker.add(item);
        Assert.assertTrue(tracker.delete(item.getId()));
        Assert.assertThat(tracker.findAll(), is( new ArrayList<Item>()));
    }

    @Test
    public void whenFindAll() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item", LocalDateTime.of(2021, Month.JULY, 02, 20, 31, 59));
        tracker.add(item);
        List<Item> res = Arrays.asList(item);
        assertThat(tracker.findAll(), is(res));
    }

    @Test
    public void whenFindByName() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item", LocalDateTime.of(2021, Month.JULY, 02, 20, 31, 59));
        tracker.add(item);
        Assert.assertThat(tracker.findByName("item"), is(Arrays.asList(item)));
    }

    @Test
    public void whenFindById() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item", LocalDateTime.of(2021, Month.JULY, 02, 20, 31, 59));
        tracker.add(item);
        assertThat(tracker.findById(item.getId()), is(item));
    }
}