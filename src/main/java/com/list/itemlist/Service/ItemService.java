package com.list.itemlist.Service;

import com.list.itemlist.database.DBService;
import com.list.itemlist.database.ItemDAO;
import com.list.itemlist.model.Item;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private static ItemDAO dataBase = new DBService();

    public void addItem(int id, String name, String description, String type, String responsible, String status, int board_id) {
        Item item = new Item(id, name, description, type, responsible, status, board_id);
        dataBase.addItem(item);
    }

    public void addItemToInProgress(int id) {
        dataBase.addItemToInProgress(id);
    }

    public List<Item> findAllInToDo(int id) {
        return dataBase.findAllInToDo(id);
    }

    public Item findById(int id) {
        return dataBase.findById(id);
    }

    public int countOfItems(){
        return dataBase.countOfItems();
    }


    public void deleteItem(int id) {
        dataBase.deleteItem(id);
    }

    public List<Item> findAllInProgress(int id){
        return dataBase.findAllInProgress(id);
    }

    public List<Item> findAllInDone(int id){
        return dataBase.findAllInDone(id);
    }

    public void addItemToDone(int id) {
        dataBase.addItemToDone(id);
    }

    public void editTask(int id, String description){
        dataBase.editTask(id, description);
    }

}
