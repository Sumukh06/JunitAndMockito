package com.junit.item;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Items_Table")
public class ItemModel {
    @Id
    private int id;
    @Column(name="Item_name",unique = true)
    private String name;
    private int price;
    private int quantity;

    @Transient
    private int value;

    public ItemModel(int id, String name, int price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}
