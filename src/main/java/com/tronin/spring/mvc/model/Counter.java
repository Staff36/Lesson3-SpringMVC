package com.tronin.spring.mvc.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Counter {
    private Integer counter = 0;

    public Integer incrementAndAssign(){
        counter++;
        return counter;
    }
}
