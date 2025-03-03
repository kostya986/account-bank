package ru.iteco.accountbank.service.protinjectsing;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
@RequiredArgsConstructor
@ToString
public class Prot1 {

    private final Sing2 sing2;

}
