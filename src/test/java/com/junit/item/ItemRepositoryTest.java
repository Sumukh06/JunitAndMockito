package com.junit.item;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ItemRepositoryTest {
        @Autowired
        ItemRepository repository;
        @Test
        void findByIdTest(){
            ItemModel expected= new ItemModel(1,"fan",1000,10);
            assertEquals(expected,repository.findById(1));
        }
        @Test
        void findAllTest(){
            List<ItemModel> returned= (List<ItemModel>) repository.findAll();
            assertEquals(6,returned.size());
        }
}