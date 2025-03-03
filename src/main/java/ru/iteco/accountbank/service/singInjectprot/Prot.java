package ru.iteco.accountbank.service.singInjectprot;

import lombok.ToString;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ru.iteco.accountbank.annotation.InjectRandom;

@Service
@Scope("prototype")
@ToString
public class Prot {

    @InjectRandom
    private int value;

}
