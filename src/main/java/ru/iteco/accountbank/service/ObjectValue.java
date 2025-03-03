package ru.iteco.accountbank.service;

import org.springframework.stereotype.Component;
import ru.iteco.accountbank.annotation.InjectRandom;

@Component
public class ObjectValue implements IObject {

    @InjectRandom
    private int value1;

    @InjectRandom(min = 10, max = 100)
    private int value2;

    @Override
    public String getInfo() {
        return "ObjectValue [value1=" + value1 + ", value2=" + value2 + "]";
    }

}
