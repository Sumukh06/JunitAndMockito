package com.junit.item;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemRepository extends CrudRepository<ItemModel,Integer> {
    ItemModel findById(int id);
}
