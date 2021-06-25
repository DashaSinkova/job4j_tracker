package ru.job4j.tracker;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 * 5. Реализовать класс Tracker[#188330]
 * написать тесты на все методы
 */
public class Tracker {
    private List<Item> items = new ArrayList<>();
    /**
     * @return
     * добавление заявок
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        items.add(item);

        return item;
    }
    /**
     * Редактирование заявок
     *
     * Ищем по данному id индекс ячейки с этим id
     * Устанавливаем item(у) id ячейки с найденым индексом
     * Добавляем item в ячейку массиву
     */
    public boolean replace(String id, Item item) {
        boolean res = false;
        int i = this.getIndexById(id);
        if (i >= 0) {
            item.setId(id);
            items.set(i, item);
            res = true;
        }
        return res;
    }
    /**
     * удаление заявок
     */
    public boolean delete(String id) {
        boolean res = false;
        int index = this.getIndexById(id);
        if (index >= 0) {
            items.remove(index);
            res = true;
        }
            return res;
        }

    /**
     * получение списка всех заявок
     */
    public List<Item> findAll() {
        return items;
    }
    /**
     * получение списка по имени
     * @param key
     * @return
     */
    public List<Item> findByName(String key) {
        List<Item> list = new ArrayList<>();
        for (Item item : items) {
            if ((item.getName()).equalsIgnoreCase(key)) {
                list.add(item);
            }
        }
        return list;
    }
    /**
     *получение заявки по id
     * @param id
     * @return
     */
    public Item findById(String id) {
                Item item = null;
        int i = this.getIndexById(id);
        if (i >= 0) {
            item = items.get(i);
        }
            return item;
        }
    /**
     * метод генерирует случайное значение id в виде произвольного числа и времени
     * @return
     */
    private String generateId() {
        Random rm = new Random();
        return String.valueOf(rm.nextLong() + System.currentTimeMillis());
    }
    /**
     * Поиск индекса по ID элемента массива
     * @param id
     * @return индекс элемента массива, id которого равно @param
     */
    private int getIndexById(String id) {
        int index = -1;
        int i = 0;
            for (Item item : items) {
                if (item.getId().equals(id)) {
                    index = i;
                    break;
                }
                i++;
            }
        return index;
    }
}
