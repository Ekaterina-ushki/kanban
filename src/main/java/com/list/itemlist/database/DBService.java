package com.list.itemlist.database;

import com.list.itemlist.model.Board;
import com.list.itemlist.model.Item;
import com.list.itemlist.model.MyUser;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DBService implements ItemDAO, BoardDAO, UserDao {

    @Override
    public void addItem(Item item) {
        Session session = CreatingSessionFactory.getSessionFactory().openSession();
        try{
            Transaction transaction = session.beginTransaction();
            session.save(item);
            transaction.commit();
        }catch (Exception e){
            System.out.println("Exception: " + e);
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    @Override
    public List<Item> findAllInToDo(int id) {
        Session session = CreatingSessionFactory.getSessionFactory().openSession();
        try {
            List<Item> items = (List<Item>) session.createQuery("From Item where status = 'To Do' and board_id = :id").setParameter("id", id).list();
            return items;
        }catch (Exception e){
            return null;
        }finally {
            session.close();
        }
    }

    @Override
    public Item findById(int id) {
        Session session = CreatingSessionFactory.getSessionFactory().openSession();
        try {
            Query query = session.createQuery("FROM Item where id = :id");
            query.setParameter("id", id);
            return (Item)query.list().get(0);
        } catch (Exception e) {
            return null;
        }finally {
            session.close();
        }
    }

    @Override
    public void deleteItem(int id) {
        Session session = CreatingSessionFactory.getSessionFactory().openSession();
        try{
            Transaction transaction = session.beginTransaction();
            Item item = findById(id);
            session.delete(item);
            transaction.commit();
        }catch (Exception e){
            System.out.println("Exception: " + e);
        }finally {
            session.close();
        }
    }

    @Override
    public List<Item> findAllInProgress(int id) {
        Session session = CreatingSessionFactory.getSessionFactory().openSession();
        try{
            List<Item> items = (List<Item>) session.createQuery("From Item where status = 'In Progress' and board_id = :id").setParameter("id", id).list();
            return items;
        }catch (Exception e){
            return null;
        }finally {
            session.close();
        }
    }

    @Override
    public void addItemToInProgress(int id) {
        Session session = CreatingSessionFactory.getSessionFactory().openSession();
        try{
            Transaction transaction = session.beginTransaction();
            Item item = findById(id);
            item.setStatus("In Progress");
            session.update(item);
            transaction.commit();
        }catch (Exception e){
            System.out.println("Exception: " + e);
            e.printStackTrace();
        }finally {
            session.close();
        }
    }


    public int countOfItems() {
        Session session = CreatingSessionFactory.getSessionFactory().openSession();
        try {
            List<Item> items = (List<Item>) session.createQuery("From Item").list();
            return items.size();
        }catch (Exception e){
            return 0;
        }finally {
            session.close();
        }
    }

    @Override
    public List<Item> findAllInDone(int id) {
        Session session = CreatingSessionFactory.getSessionFactory().openSession();
        try{
            List<Item> items = (List<Item>) session.createQuery("From Item where status = 'Done' and board_id = :id").setParameter("id", id).list();
            return items;
        }catch (Exception e){
            return null;
        }finally {
            session.close();
        }
    }

    @Override
    public void addItemToDone(int id) {
        Session session = CreatingSessionFactory.getSessionFactory().openSession();
        try{
            Transaction transaction = session.beginTransaction();
            Item item = findById(id);
            item.setStatus("Done");
            session.update(item);
            transaction.commit();
        }catch (Exception e){
            System.out.println("Exception: " + e);
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    @Override
    public void editTask(int id, String description) {
        Session session = CreatingSessionFactory.getSessionFactory().openSession();
        try{
            Transaction transaction = session.beginTransaction();
            Item item = findById(id);
            item.setDescription(description);
            session.update(item);
            transaction.commit();
        }catch (Exception e){
            System.out.println("Exception: " + e);
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    @Override
    public List<Board> findAllBoard() {
        Session session = CreatingSessionFactory.getSessionFactory().openSession();
        try{
            List<Board> boards = (List<Board>) session.createQuery("From Board").list();
            return boards;
        }catch (Exception e){
            return null;
        }finally {
            session.close();
        }
    }

    @Override
    public void addBoard(Board board) {
        Session session = CreatingSessionFactory.getSessionFactory().openSession();
        try{
            Transaction transaction = session.beginTransaction();
            session.save(board);
            transaction.commit();
        }catch (Exception e){
            System.out.println("Exception: " + e);
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    @Override
    public MyUser getUser(String login) {
        Session session = CreatingSessionFactory.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(MyUser.class);
        return (MyUser) criteria.add(Restrictions.eq("login", login)).uniqueResult();
    }

    @Override
    public void insertUser(MyUser myUser) {
        Session session = CreatingSessionFactory.getSessionFactory().openSession();
        session.save(myUser);
    }
}
