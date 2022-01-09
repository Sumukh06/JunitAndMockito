package com.junit.item;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertExample {
    private String output="{\"id\":1,\"name\":\"Book\",\"price\":200,\"quantity\":5}";

    @Test
    public void jsonAssetTest() throws JSONException {
        String expected="{\"id\":1,\"name\":\"Book\",\"price\":200,\"quantity\":5}";
        JSONAssert.assertEquals(expected,output,true);
    }
    @Test
    public void jsonAssetTestFalse() throws JSONException {
        String expected="{\"id\":1,\"name\":\"Book\",\"price\":200}";
        JSONAssert.assertEquals(expected,output,false);
    }
    @Test
    public void jsonAssetTestWithoutEscpChar() throws JSONException {
        String expected="{id:1,name:Book,quantity:5,price:200}";
        JSONAssert.assertEquals(expected,output,false);
    }

}
