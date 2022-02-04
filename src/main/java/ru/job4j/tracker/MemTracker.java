package ru.job4j.tracker;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 * 5. Реализовать класс MemTracker[#188330]
 * написать тесты на все методы
 */
public class MemTracker implements Store{
    private List<Item> items = new ArrayList<>();
    @Override
    public void init() {
    }
     /**
     * @return
     * добавление заявок
     */
    @Override
    public Item add(Item item) {
        item.setId(this.generateId());
        items.add(item);

        return item;
    }
       /** public Item add(Item item) {
        item.setId(this.generateId());
        items.add(item);
        for (int i = 0; i < 10000000; i++) {
            Item newItem = new Item(item.getName() + i, LocalDateTime.now());
            newItem.setId(this.generateId());
            items.add(newItem);
        }

        return item;
    }
    /**
     * метод генерирует случайное значение id в виде произвольного числа и времени
     * @return
     */
    private int generateId() {
        Random rm = new Random();
        return (int) (rm.nextLong() + System.currentTimeMillis());
    }
    /** Редактирование заявок
     *
     * Ищем по данному id индекс ячейки с этим id
     * Устанавливаем item(у) id ячейки с найденым индексом
     * Добавляем item в ячейку массиву
     */
    @Override
    public boolean replace(int id, Item item) {
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
     * Поиск индекса по ID элемента массива
     * @param id
     * @return индекс элемента массива, id которого равно @param
     */
        private int getIndexById(int id) {
        int index = -1;
        int i = 0;
            for (Item item : items) {
                if (item.getId() == id) {
                    index = i;
                    break;
                }
                i++;
            }
        return index;
    }

    @Override
    public boolean delete(int id) {
        boolean res = false;
        int index = this.getIndexById(id);
        if (index >= 0) {
            items.remove(index);
            res = true;
        }
            return res;
    }

    @Override
    public List<Item> findAll() {
        return items;
    }

    @Override
    public List<Item> findByName(String key) {
          List<Item> list = new ArrayList<>();
        for (Item item : items) {
            if ((item.getName()).equalsIgnoreCase(key)) {
                list.add(item);
            }
        }
        return list;
    }

    @Override
    public Item findById(int id) {
        Item item = null;
        int i = this.getIndexById(id);
        if (i >= 0) {
            item = items.get(i);
        }
            return item;
    }

    @Override
    public void close() throws Exception {

    }
}
