package ru.iteco.accountbank.service.cycledependency;

import org.springframework.stereotype.Service;

@Service
public class A {

    private final B b;

    public A(B b) {
        System.out.println(this.getClass().getName() + " constructor");
        this.b = b;
    }
}
