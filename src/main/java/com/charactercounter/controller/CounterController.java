package com.charactercounter.controller;

import com.charactercounter.service.CounterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Parameter;
@RequiredArgsConstructor
@RestController
public class CounterController {
    private final CounterService counterService;

    @GetMapping("/{string}")
    public String getCharacterCounter(@PathVariable(name = "string")
                                          @Parameter(description = "Строка для подсчета символов",
                                                  example = "aaabcc")String string) {
        return counterService.getCharacterCounter(string);
    }
}
