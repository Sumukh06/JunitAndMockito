package com.junit.item;

import com.junit.business.SomeBusinessImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {
    @Autowired
    SomeBusinessImpl someBusiness;
    @GetMapping("/dummyItem")
    public ItemModel dummyItemCon(){
        return new ItemModel(1,"Book",200,5);
    }
    @GetMapping("/dummyItem-business")
    public ItemModel dummyItemBis(){
        return someBusiness.returndummyItem();
    }
    @GetMapping("/itemList")
    public List<ItemModel> getListData(){
        return someBusiness.findAllData();
    }
}
