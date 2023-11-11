package com.charactercounter.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CounterServiceTest {
    private CounterService counterService = new CounterService();
    @Test
    void getCharacterCounterTest() {
       assertEquals(counterService.getCharacterCounter("aabccc"), "c:3,a:2,b:1");
    }
}
