package com.junit.business;

import com.junit.data.SomeDataImpl;
import com.junit.item.ItemModel;
import com.junit.item.ItemRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SomeBusinessImplTest {

    @InjectMocks
    SomeBusinessImpl someBusiness;

    @Mock
    SomeDataImpl someData;

    @Mock
    ItemRepository repository;

    @Test
    void calculateSum() {
        int actualRes=someBusiness.calculateSum(new int[]{1,2,3});
        int expectedRes=6;
        assertEquals(expectedRes,actualRes);
    }
    @Test
    void calculateSum_noEle() {
        int actualRes=someBusiness.calculateSum(new int[]{});
        int expectedRes=0;
        assertEquals(expectedRes,actualRes);
    }
    @Test
    void calculateSum_oneEle() {
        int actualRes=someBusiness.calculateSum(new int[]{100});
        int expectedRes=100;
        assertEquals(expectedRes,actualRes);
    }

    @Test
    void calcuateSumfromData() {
        when(someData.getAllData()).thenReturn(new int[]{1,2,3});
        assertEquals(6,someBusiness.calcuateSumfromData());
    }
    @Test
    void returndummyItemTest(){
        ItemModel expected=new ItemModel(2,"Box",1000,3);
        assertEquals(expected,someBusiness.returndummyItem());
    }
    @Test
    public void findAllDataTest(){
        when(repository.findAll()).thenReturn(Arrays.asList(
                new ItemModel(1,"Fan",100,2),
                new ItemModel(2,"Book",50,3)));
        List<ItemModel> expected=Arrays.asList(
                new ItemModel(1,"Fan",100,2,200),
                new ItemModel(2,"Book",50,3,150));
        assertEquals(expected,someBusiness.findAllData());
        verify(repository,times(1)).findAll();
    }
}