package com.junit.item;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemModel {
    private int id;
    private String name;
    private int price;
    private int quantity;
}
