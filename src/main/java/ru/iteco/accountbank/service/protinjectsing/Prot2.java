package ru.iteco.accountbank.service.protinjectsing;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
@ToString
@RequiredArgsConstructor
public class Prot2 {

    private final Sing2 sing2;

}
