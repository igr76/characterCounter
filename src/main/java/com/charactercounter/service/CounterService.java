package com.charactercounter.service;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
/**
 * Сервис подсчета строки
 */
@Service
public class CounterService {

    /**  Метод вычисление частоты встречи символов в заданной строке  */
    public String getCharacterCounter(String string) {

        return  string.chars()
                .mapToObj(e -> Character.toLowerCase(Character.valueOf((char) e)))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .sorted(Comparator.comparingInt(e -> Math.toIntExact(-e.getValue())))
                .map(e -> e.getKey() + ":" + e.getValue())
                .collect(Collectors.joining(","));

    }
}
