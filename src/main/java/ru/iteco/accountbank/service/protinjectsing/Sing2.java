package ru.iteco.accountbank.service.protinjectsing;

import lombok.ToString;
import org.springframework.stereotype.Service;
import ru.iteco.accountbank.annotation.InjectRandom;

@Service
@ToString
public class Sing2 {

    @InjectRandom
    private int value;

}
