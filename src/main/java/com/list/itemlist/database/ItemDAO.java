package com.list.itemlist.database;

import com.list.itemlist.model.Item;

import java.util.List;


public interface ItemDAO {
    void addItem(Item item);
    List<Item> findAllInToDo(int id);
    Item findById(int id);
    void deleteItem(int id);
    int countOfItems();
    List<Item> findAllInProgress(int id);
    void addItemToInProgress(int id);
    List<Item> findAllInDone(int id);
    void addItemToDone(int id);
}
