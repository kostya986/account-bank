package ru.iteco.accountbank.service.singInjectprot;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@ToString
public class Sing {

    private final Prot prot;

}
