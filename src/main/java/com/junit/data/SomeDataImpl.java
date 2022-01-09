package com.junit.data;

import org.springframework.stereotype.Component;

@Component
public class SomeDataImpl {
    public int[] getAllData(){
         return new int[]{1,2,3,4,5,6,7,8,9,10};
    }
}
