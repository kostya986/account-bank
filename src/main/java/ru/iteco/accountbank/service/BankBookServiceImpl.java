package ru.iteco.accountbank.service;

import org.springframework.stereotype.Service;
import ru.iteco.accountbank.annotation.InjectRandom;
import ru.iteco.accountbank.model.BankBook;

import java.util.List;

@Service
public class BankBookServiceImpl implements BankBookService {

    @InjectRandom(max = 100)
    private Integer number;

    @Override
    public List<BankBook> getBankBooksByAccountId(Integer accountId) {
        return List.of(new BankBook()
                .setUserId(accountId)
                .setNumber(number.longValue()));
    }

}
