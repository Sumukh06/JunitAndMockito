package com.junit.business;

import com.junit.data.SomeDataImpl;
import com.junit.item.ItemModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
@Component
public class SomeBusinessImpl {
    @Autowired
    SomeDataImpl someData;
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
}
