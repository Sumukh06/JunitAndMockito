package com.junit.item;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {
    @GetMapping("/dummyItem")
    public ItemModel dummyItemCon(){
        return new ItemModel(1,"Book",200,5);
    }
}
