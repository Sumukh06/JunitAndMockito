package com.junit.business;

import com.junit.data.SomeDataImpl;
import com.junit.item.ItemModel;
import com.junit.item.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class SomeBusinessImpl {
    @Autowired
    SomeDataImpl someData;

    @Autowired
    ItemRepository repository;
    public int calculateSum(int[] data){
        return Arrays.stream(data).sum();
    }

    public int calcuateSumfromData(){
        int[] data=someData.getAllData();
        return Arrays.stream(data).sum();
    }

    public ItemModel returndummyItem(){
       return new ItemModel(2,"Box",1000,3);
    }

    public List<ItemModel> findAllData(){
        List<ItemModel> items= (List<ItemModel>) repository.findAll();
        items.forEach(itemModel -> itemModel.setValue(itemModel.getPrice() * itemModel.getQuantity()));
        return items;
    }
}
