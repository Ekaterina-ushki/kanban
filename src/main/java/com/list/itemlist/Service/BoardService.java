package com.list.itemlist.Service;

import com.list.itemlist.database.BoardDAO;
import com.list.itemlist.database.DBService;
import com.list.itemlist.model.Board;
import com.list.itemlist.model.Item;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    private static BoardDAO dataBase = new DBService();

    public void addBoard (int id, String name){
        Board board = new Board(id, name);
        dataBase.addBoard(board);
    }

    public List<Board> findAllBoard() {
        return dataBase.findAllBoard();
    }



}
