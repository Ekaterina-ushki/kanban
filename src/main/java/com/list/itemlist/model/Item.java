package com.list.itemlist.model;

import javax.persistence.*;

@Entity
@Table(name = "item_list")
public class Item {

    public Item(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;

    @Column
    private String description;

    @Column
    private String type;

    @Column
    private String responsible;

    @Column
    private String status;

    @Column
    private int board_id;

    public Item(int id, String name, String description,
                String type, String responsible, String status, int board_id) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.responsible = responsible;
        this.status = status;
        this.board_id = board_id;
    }

    public Item(int id, String name, String description,
                String type, String responsible, String status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.responsible = responsible;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription(){return description;}

    public void setDescription(){this.description = description;}

    public String getType(){return type;}

    public void setType(){this.type = type;}

    public String getResponsible(){return responsible;}

    public void setResponsible(){this.responsible = responsible;}

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + description +
                '}';
    }
}
