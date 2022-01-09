package com.junit.business;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ListMockTest {
    @Mock
    List<String> listMock;

    @Mock
    ArrayList arrayListMock;

    @Spy
    ArrayList arrayListSpy;

    @Test
    public void size_basic() {
        when(listMock.size()).thenReturn(5);
        assertEquals(5,listMock.size());
    }
    @Test
    public void returnDiffValues(){
        when(listMock.size()).thenReturn(10).thenReturn(0);
        assertEquals(10,listMock.size());//when called first time returns 10
        assertEquals(0,listMock.size());//when called second time returns 0
    }
    @Test
    public void returnWithParameters(){
        when(listMock.get(0)).thenReturn("Hello World");
        assertEquals("Hello World",listMock.get(0));
        assertEquals(null,listMock.get(1));
    }
    @Test
    public void retunrWithAnyParameter(){
        when(listMock.get(anyInt())).thenReturn("Hi All");
        assertEquals("Hi All",listMock.get(100));
        assertEquals("Hi All",listMock.get(7));
    }
    @Test
    public void verificationBasics(){
        //System under test
        String val1=listMock.get(0);
        String val2=listMock.get(1);
        String val3=listMock.get(1);
        verify(listMock).get(0);
        verify(listMock,times(3)).get(anyInt());
        verify(listMock,atLeast(1)).get(0);
        verify(listMock,atMost(2)).get(1);
    }

    @Test
    public void mocking(){
        System.out.println(arrayListMock.get(0));
        System.out.println(arrayListMock.size());
        arrayListMock.add("Hello");
        arrayListMock.add("Hello World");
        System.out.println(arrayListMock.get(0));
        System.out.println(arrayListMock.size());
        when(arrayListMock.get(anyInt())).thenReturn("Hello All");
        when(arrayListMock.size()).thenReturn(2);
        System.out.println(arrayListMock.get(10));
        System.out.println(arrayListMock.size());
    }
    @Test
    public void spyTest(){
        arrayListSpy.add("hihi");
        assertEquals("hihi",arrayListSpy.get(0));
        arrayListSpy.add("Hello World");
        assertEquals("Hello World",arrayListSpy.get(1));
        assertEquals(2,arrayListSpy.size());

        verify(arrayListSpy).add("hihi");
        verify(arrayListSpy).add("Hello World");
    }
}
