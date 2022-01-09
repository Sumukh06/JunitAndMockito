package com.junit.business;

import com.junit.data.SomeDataImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SomeBusinessImplTest {

    @InjectMocks
    SomeBusinessImpl someBusiness;

    @Mock
    SomeDataImpl someData;

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
}