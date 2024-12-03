package ru.iteco.accountbank.service;

import org.springframework.stereotype.Service;
import ru.iteco.accountbank.model.BankBook;

import java.util.List;

@Service
public class BankBookServiceImpl implements BankBookService {

    @Override
    public List<BankBook> getBankBooksByAccountId(Integer accountId) {
        return List.of(new BankBook().setUserId(accountId).setNumber(1L));
    }

}
