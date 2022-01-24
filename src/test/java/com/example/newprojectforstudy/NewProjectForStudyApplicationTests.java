package com.example.newprojectforstudy;

import com.example.newprojectforstudy.Utils.JWTUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



import java.util.HashMap;
import java.util.Map;

class JWTUtilsTests {
    private String token;

    @BeforeEach
    void beforeEach(){
        Map<String,String> playLoad = new HashMap<>();
        playLoad.put("useId","123");
        this.token = JWTUtils.makeSignTure(playLoad);
    }
    @Test
    void testSign() {
        //Assert.notNull(this.token);
    }

    @Test
    void testAssertWithHMAC256Error() {
        boolean isThrow = false;
        try {
            JWTUtils.assertWithHMAC256("1234");
        }catch (Exception ex){
            isThrow = true;
        }
        Assertions.assertTrue(isThrow);
    }

    @Test
    void testAssertWithHMAC256Right() {
        boolean isThrow = false;
        try {
            JWTUtils.assertWithHMAC256(this.token);
        }catch (Exception ex){
            isThrow = true;
        }
        Assertions.assertFalse(isThrow);
    }

    @Test
    void testGetPlayload(){
        Assertions.assertEquals(JWTUtils.getPlayload(this.token,"useId"),"123");
    }

}
