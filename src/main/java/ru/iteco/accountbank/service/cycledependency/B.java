package ru.iteco.accountbank.service.cycledependency;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class B {

    private final A a;

    public B(@Lazy A a) {
        System.out.println(this.getClass().getName() + " constructor");
        this.a = a;
    }
}
