package com.charactercounter.service;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
/**
 * Сервис подсчета строки
 */
@Service
public class CounterService {
    Map<Character, Integer> map = new HashMap<Character, Integer>();
    /**  Метод вычисление частоты встречи символов в заданной строке  */
    public String getCharacterCounter(String string) {
        // Вычисление количества символов в строке
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            Integer val = map.get(c);
            if (val != null) {
                map.put(c, val + 1);
            }
            else {
                map.put(c, 1);
            }
        }
        // Сортировка в обратном порядке и перевод в строку
        return map.entrySet().stream()
                .sorted(Comparator.comparingInt(e -> -e.getValue()))
                .map(e -> e.getKey() + ":" + e.getValue())
                .collect(Collectors.joining(","));
    }
}
