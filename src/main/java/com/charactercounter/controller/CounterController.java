package com.charactercounter.controller;

import com.charactercounter.service.CounterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Parameter;
/**
 * Контроллер подсчета строки
 */
@RequiredArgsConstructor
@RestController
public class CounterController {
    private final CounterService counterService;
    @Operation(summary = "вычисление частоты встречи символов в заданной строке")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(
                    array = @ArraySchema(schema = @Schema(implementation = String.class)))),
            @ApiResponse(responseCode = "204", description = "No Content", content = @Content(schema = @Schema())),
    })
    @GetMapping("/{string}")
    public String getCharacterCounter(@PathVariable(name = "string")
                                          @Parameter(description = "Строка для подсчета символов",
                                                  example = "aaabcc")String string) {
        return counterService.getCharacterCounter(string);
    }
}
